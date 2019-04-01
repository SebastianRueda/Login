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

public class HomeActivity extends AppCompatActivity {

    private Button buttonLogOut;
    private SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        prefs = getSharedPreferences(SignUpActivity.PREFERENCES_USER, Context.MODE_PRIVATE);

        Gson gson = new Gson();
        String json = prefs.getString("usuario", "");

        User usuario = gson.fromJson(json, User.class);

        getSupportActionBar().setTitle("Hello, " + usuario.getUser() + "!");
        setContentView(R.layout.activity_home);

        buttonLogOut = findViewById(R.id.buttonLogOut);

        buttonLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Vibrator vibe = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                vibe.vibrate(100);

                Intent intent = new Intent(HomeActivity.this, StartActivity.class);
                cleanSharedPreferences();
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            }
        });
    }

    private void cleanSharedPreferences() {
        SharedPreferences prefs = getSharedPreferences(SignUpActivity.PREFERENCES_USER, Context.MODE_PRIVATE);

        Gson gson = new Gson();
        String json = prefs.getString("usuario", "");

        User usuario = gson.fromJson(json, User.class);
        usuario.setLogged(false);

        SharedPreferences.Editor editor = prefs.edit();

        json = gson.toJson(usuario);

        editor.putString("usuario", json);
        editor.commit();
    }
}
