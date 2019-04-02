package com.infinixsoft.login;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;
import com.infinixsoft.login.entity.User;
import com.infinixsoft.login.entity.UserPreferences;

public class LoginActivity extends AppCompatActivity {

    private EditText editTextEmail;
    private EditText editTextPassword;
    private Button buttonLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_login);

        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPassword = findViewById(R.id.editTextPassword);
        buttonLogin = findViewById(R.id.buttonLoginLogin);



        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Vibrator vibe = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                vibe.vibrate(100);

                String email = editTextEmail.getText().toString();
                String password = editTextPassword.getText().toString();

                UserPreferences userPreferences = new UserPreferences(LoginActivity.this);

                User usuario = userPreferences.getUser();

                if (validLogin(usuario, email, password)) {

                    userPreferences.userLogged(true);

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
