package com.infinixsoft.login;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.gson.Gson;
import com.infinixsoft.login.entity.User;
import com.infinixsoft.login.entity.UserPreferences;

public class HomeActivity extends AppCompatActivity {

    private Button buttonLogOut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final UserPreferences userPreferences = new UserPreferences(this);

        User usuario = userPreferences.getUser();

        getSupportActionBar().setTitle("Hello, " + usuario.getUser() + "!");
        setContentView(R.layout.activity_home);

        buttonLogOut = findViewById(R.id.buttonLogOut);

        buttonLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Vibrator vibe = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                vibe.vibrate(100);

                Intent intent = new Intent(HomeActivity.this, StartActivity.class);
                userPreferences.userLogged(false);

                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            }
        });
    }
}
