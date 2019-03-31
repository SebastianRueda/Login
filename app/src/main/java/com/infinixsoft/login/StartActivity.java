package com.infinixsoft.login;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.google.gson.Gson;

public class StartActivity extends AppCompatActivity {

    private ImageView imageViewStart;
    private Button buttonLoginStart;
    private Button buttonSignUpStart;

    private SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        imageViewStart = findViewById(R.id.imageViewStart);
        buttonLoginStart = findViewById(R.id.buttonLoginStart);
        buttonSignUpStart = findViewById(R.id.buttonSignUpStart);

        prefs = getSharedPreferences(SignUpActivity.PREFERENCES_USER, Context.MODE_PRIVATE);

        Gson gson = new Gson();
        String json = prefs.getString("usuario", "");

        User user;

        if (!json.equals("")) {

            user = gson.fromJson(json, User.class);

            if(prefs.contains("usuario") && user.getLogged()) {

                Intent intent = new Intent(StartActivity.this, HomeActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            }
        }

        buttonLoginStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StartActivity.this, LoginActivity.class);

                startActivity(intent);
            }
        });

        buttonSignUpStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StartActivity.this, SignUpActivity.class);

                startActivity(intent);
            }
        });
    }
}
