package com.infinixsoft.login;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class InfoActivity extends AppCompatActivity {

    private TextView textViewName;
    private TextView textViewSurname;
    private TextView textViewEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setTitle("Info");
        setContentView(R.layout.activity_info);

        String name = getIntent().getStringExtra("name");
        String surname = getIntent().getStringExtra("surname");
        String email = getIntent().getStringExtra("email");

        textViewName.setText(name);
        textViewSurname.setText(surname);
        textViewEmail.setText(email);
    }
}
