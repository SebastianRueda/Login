package com.infinixsoft.login;

import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class InfoActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView textViewName;
    private TextView textViewSurname;
    private TextView textViewEmail;
    private Button buttonBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setTitle("Info");
        setContentView(R.layout.activity_info);

        String name = getIntent().getStringExtra("name");
        String surname = getIntent().getStringExtra("surname");
        String email = getIntent().getStringExtra("email");

        this.textViewName = findViewById(R.id.textViewName);
        this.textViewSurname = findViewById(R.id.textViewSurname);
        this.textViewEmail = findViewById(R.id.textViewEmail);
        this.buttonBack = findViewById(R.id.buttonBackInfo);

        this.textViewName.setText(name);
        this.textViewSurname.setText(surname);
        this.textViewEmail.setText(email);


    }

    @Override
    public void onClick(View v) {
        Vibrator vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);
        vibrator.vibrate(100);

        switch (v.getId()) {
            case R.id.buttonBackInfo:
                finish();

                break;
        }
    }
}
