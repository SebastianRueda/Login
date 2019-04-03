package com.infinixsoft.login;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.google.gson.Gson;
import com.infinixsoft.login.entity.Materia;
import com.infinixsoft.login.entity.User;
import com.infinixsoft.login.entity.UserPreferences;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {

    private Button buttonLogOut;
    private ImageButton imageButtonInfo;
    private ImageButton imageButtonMateria;
    private ImageButton imageButtonObjetivo;
    private ImageButton imageButtonExamen;
    private UserPreferences userPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.userPreferences = new UserPreferences(this);

        User usuario = this.userPreferences.getUser();

        getSupportActionBar().setTitle("Hello, " + usuario.getUser() + "!");
        setContentView(R.layout.activity_home);

        this.buttonLogOut = findViewById(R.id.buttonLogOut);
        this.imageButtonInfo = findViewById(R.id.imageButtonInfo);
        this.imageButtonMateria = findViewById(R.id.imageButtonMaterias);
        this.imageButtonObjetivo = findViewById(R.id.imageButtonObjetivos);
        this.imageButtonExamen = findViewById(R.id.imageButtonExámenes);

        this.buttonLogOut.setOnClickListener(this);
        this.imageButtonInfo.setOnClickListener(this);
        this.imageButtonMateria.setOnClickListener(this);
        this.imageButtonObjetivo.setOnClickListener(this);
        this.imageButtonExamen.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Vibrator vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);
        vibrator.vibrate(100);

        Intent intent;

        switch (v.getId()) {
            case R.id.buttonLogOut:

                intent = new Intent(HomeActivity.this, StartActivity.class);
                this.userPreferences.userLogged(false);

                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);

                break;

            case R.id.imageButtonInfo:

                intent = new Intent(this, InfoActivity.class);

                User user = this.userPreferences.getUser();

                intent.putExtra("name", user.getPersona().getNombre());
                intent.putExtra("surname", user.getPersona().getApellido());
                intent.putExtra("email", user.getEmail());

                startActivity(intent);

                break;

            case  R.id.imageButtonMaterias:

                intent = new Intent(this, MateriasActivity.class);
                startActivity(intent);

                break;

            case R.id.imageButtonObjetivos:

                intent = new Intent(this, ObjetivosActivity.class);
                startActivity(intent);

                break;

            case  R.id.imageButtonExámenes:
                break;
        }
    }
}
