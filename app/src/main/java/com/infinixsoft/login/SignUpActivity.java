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
import android.widget.ImageButton;
import android.widget.Switch;
import android.widget.Toast;

import com.google.gson.Gson;
import com.infinixsoft.login.entity.Person;
import com.infinixsoft.login.entity.User;
import com.infinixsoft.login.entity.UserPreferences;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageButton imageButtonAdd;
    private EditText editTextUser;
    private EditText editTextName;
    private EditText editTextSurname;
    private EditText editTextEmail;
    private EditText editTextPassword;
    private Switch switchSignUp;
    private Button buttonSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_sign_up);

        imageButtonAdd = findViewById(R.id.imageButtonAdd);
        editTextUser = findViewById(R.id.editTextUserSignUp);
        editTextName = findViewById(R.id.editTextNameSignUp);
        editTextSurname = findViewById(R.id.editTextSurnameSignUp);
        editTextEmail = findViewById(R.id.editTextEmailSignUp);
        editTextPassword = findViewById(R.id.editTextPasswordSignUp);
        switchSignUp = findViewById(R.id.switchSignUp);
        buttonSignUp = findViewById(R.id.buttonSignUp);

        imageButtonAdd.setOnClickListener(this);
        buttonSignUp.setOnClickListener(this);

    }

    private boolean validateUser(String user, String name, String surname, String email, String password) {

        if(user.isEmpty()) {
            Toast.makeText(SignUpActivity.this, "User is not valid.", Toast.LENGTH_SHORT).show();
            return false;
        }

        if(name.isEmpty()) {
            Toast.makeText(SignUpActivity.this, "Name is not valid.", Toast.LENGTH_SHORT).show();
            return false;
        }

        if(surname.isEmpty()) {
            Toast.makeText(SignUpActivity.this, "Surname is not valid.", Toast.LENGTH_SHORT).show();
            return false;
        }

        if(password.isEmpty()) {
            Toast.makeText(SignUpActivity.this, "Password is not valid.", Toast.LENGTH_SHORT).show();
            return false;
        }

        if(email.isEmpty()) {
            Toast.makeText(SignUpActivity.this, "Email is not valid.", Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }

    @Override
    public void onClick(View v) {
        Vibrator vibe = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        vibe.vibrate(100);

        Intent intent;

        UserPreferences userPreferences = new UserPreferences(SignUpActivity.this);

        String user = editTextUser.getText().toString();
        String name = editTextName.getText().toString();
        String surname = editTextSurname.getText().toString();
        String email = editTextEmail.getText().toString();
        String password = editTextPassword.getText().toString();

        switch (v.getId()) {
            case R.id.imageButtonAdd:
                Toast.makeText(SignUpActivity.this, "A implementar.", Toast.LENGTH_SHORT).show();

                break;

            case R.id.buttonSignUp:

                if(switchSignUp.isChecked()) {

                    if(validateUser(user, name, surname, email, password)) {

                        userPreferences.setUser(new User(user, email, password, new Person(name, surname)));

                        intent = new Intent(SignUpActivity.this, StartActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        startActivity(intent);
                    }
                } else
                    Toast.makeText(SignUpActivity.this, "To continue first accept the Terms and Condition.", Toast.LENGTH_SHORT).show();

                break;

        }
    }
}
