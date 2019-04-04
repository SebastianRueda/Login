package com.infinixsoft.login;

import android.app.Activity;
import android.content.Intent;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.gson.Gson;
import com.infinixsoft.login.entity.Materia;

public class AddMateriaActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText editTextNombre;
    private EditText editTextEstado;
    private EditText editTextOfertado;
    private Button buttonAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_materia);

        this.editTextNombre = findViewById(R.id.editTextNombreMateria);
        this.editTextEstado = findViewById(R.id.editTextEstadoMateria);
        this.editTextOfertado = findViewById(R.id.editTextOfertadoMateria);
        this.buttonAdd = findViewById(R.id.buttonAddMateria);

        this.buttonAdd.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        Vibrator vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);
        vibrator.vibrate(100);

        Intent intent;

        switch (v.getId()) {
            case R.id.buttonAddMateria:

                Gson gson = new Gson();

                String nombre = this.editTextNombre.getText().toString();
                String estado = this.editTextEstado.getText().toString();
                String ofertado = this.editTextOfertado.getText().toString();

                String json = gson.toJson(new Materia(nombre, estado,ofertado), Materia.class);

                intent = new Intent(this, MateriasActivity.class);
                intent.putExtra("materia", json);
                setResult(Activity.RESULT_OK, intent);

                finish();

                break;
        }

    }
}
