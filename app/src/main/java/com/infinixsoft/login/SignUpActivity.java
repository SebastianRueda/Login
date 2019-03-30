package com.infinixsoft.login;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.gson.Gson;

public class SignUpActivity extends AppCompatActivity {

    private Button buttonSignUp;
    private ImageButton imageButtonAdd;
    private EditText editTextUser;
    private EditText editTextEmail;
    private EditText editTextPassword;

    private SharedPreferences prefs;

    public final static String PREFERENCES_USER = "preferencesUser";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        buttonSignUp = findViewById(R.id.buttonSignUp);
        imageButtonAdd = findViewById(R.id.imageButtonAdd);
        editTextUser = findViewById(R.id.editTextUserSignUp);
        editTextEmail = findViewById(R.id.editTextEmailSignUp);
        editTextPassword = findViewById(R.id.editTextPasswordSignUp);

        prefs = getSharedPreferences(PREFERENCES_USER, Context.MODE_PRIVATE);

        imageButtonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SignUpActivity.this, "dasdas", Toast.LENGTH_SHORT).show();
            }
        });

        buttonSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String user = editTextUser.getText().toString();
                String email = editTextEmail.getText().toString();
                String password = editTextPassword.getText().toString();

                if(validateUser(user, email, password)) {

                    SharedPreferences.Editor editor = prefs.edit();

                    Gson gson = new Gson();
                    User usuario = new User(user, email, password);

                    String json = gson.toJson(usuario);

                    editor.putString("usuario", json);
                    editor.commit();

                    Intent intent = new Intent(SignUpActivity.this, StartActivity.class);
                    startActivity(intent);
                }

            }
        });
    }

    private boolean validateUser(String user, String email, String password) {

        if(user.isEmpty()) {
            Toast.makeText(SignUpActivity.this, "User is not valid.", Toast.LENGTH_SHORT);
            return false;
        }

        if(password.isEmpty()) {
            Toast.makeText(SignUpActivity.this, "Password is not valid.", Toast.LENGTH_SHORT);
            return false;
        }

        if(email.isEmpty()) {
            Toast.makeText(SignUpActivity.this, "Email is not valid.", Toast.LENGTH_SHORT);
            return false;
        }

        return true;
    }
}
