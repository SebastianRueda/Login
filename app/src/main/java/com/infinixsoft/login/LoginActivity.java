package com.infinixsoft.login;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;

public class LoginActivity extends AppCompatActivity {

    private EditText editTextEmail;
    private EditText editTextPassword;
    private Button buttonLogin;

    private SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_login);

        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPassword = findViewById(R.id.editTextPassword);
        buttonLogin = findViewById(R.id.buttonLoginLogin);

        prefs = getSharedPreferences(SignUpActivity.PREFERENCES_USER, Context.MODE_PRIVATE);

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = editTextEmail.getText().toString();
                String password = editTextPassword.getText().toString();

                Gson gson = new Gson();
                String json = prefs.getString("usuario", "");

                User usuario = new User();

                if(!json.equals(""))
                    usuario = gson.fromJson(json, User.class);

                if (validLogin(usuario, email, password)) {

                    usuario.setLogged(true);

                    SharedPreferences.Editor editor = prefs.edit();

                    json = gson.toJson(usuario);

                    editor.putString("usuario", json);
                    editor.commit();

                    cleanEditText();

                    Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);

                    startActivity(intent);

                } else
                    Toast.makeText(LoginActivity.this, "User or Password is not valid.", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private boolean validLogin(User user, String email, String password) {
        if (email.equals(user.getEmail()) && password.equals(user.getPassword()))
            return true;
        else
            return false;
    }

    private void cleanEditText() {
        editTextEmail.setText("");
        editTextPassword.setText("");
    }
}
