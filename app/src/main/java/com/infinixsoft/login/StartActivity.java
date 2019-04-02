package com.infinixsoft.login;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.google.gson.Gson;
import com.infinixsoft.login.entity.User;
import com.infinixsoft.login.entity.UserPreferences;

public class StartActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView imageViewStart;
    private Button buttonLoginStart;
    private Button buttonSignUpStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_start);

        imageViewStart = findViewById(R.id.imageViewStart);
        buttonLoginStart = findViewById(R.id.buttonLoginStart);
        buttonSignUpStart = findViewById(R.id.buttonSignUpStart);

        UserPreferences userPreferences = new UserPreferences(this);

        User user = userPreferences.getUser();

        if (user != null) {

            if(user.getLogged()) {

                Intent intent = new Intent(StartActivity.this, HomeActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            }
        }

        buttonLoginStart.setOnClickListener(this);

        buttonSignUpStart.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Vibrator vibe = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        vibe.vibrate(100);

        Intent intent;

        switch (v.getId()) {
            case R.id.buttonLoginStart:
                intent = new Intent(StartActivity.this, LoginActivity.class);
                startActivity(intent);

                break;

            case R.id.buttonSignUpStart:
                intent = new Intent(StartActivity.this, SignUpActivity.class);
                startActivity(intent);

                break;
        }
    }
}
