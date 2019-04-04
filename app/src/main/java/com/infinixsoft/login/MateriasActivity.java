package com.infinixsoft.login;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.LinearLayout;

import com.google.gson.Gson;
import com.infinixsoft.login.entity.Materia;
import com.infinixsoft.login.entity.adapter.MateriaAdapter;

import java.util.ArrayList;
import java.util.List;

public class MateriasActivity extends AppCompatActivity {

    private MateriaAdapter materiaAdapter;
    private RecyclerView recyclerView;
    private Button buttonBack;
    private List<Materia> materias;

    private static final int REQUEST_NUMBER = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setTitle("Materias");
        setContentView(R.layout.activity_materias);

        this.recyclerView = findViewById(R.id.recyclerViewMateria);
        this.buttonBack = findViewById(R.id.buttonBackMateria);

        materias = new ArrayList<Materia>();

        this.materiaAdapter = new MateriaAdapter(materias);




        recyclerView.setAdapter(this.materiaAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayout.VERTICAL, false));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.action_bar_menu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.menuActionBar:

                Intent intent = new Intent(this, AddMateriaActivity.class);
                startActivityForResult(intent, REQUEST_NUMBER);

                return true;

                default:
                    return super.onOptionsItemSelected(item);
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == REQUEST_NUMBER) {
            if(resultCode == Activity.RESULT_OK) {
                String json = data.getExtras().getString("materia");

                if(json != null) {

                    Gson gson = new Gson();
                    Materia materia = gson.fromJson(json, Materia.class);

                    this.materias.add(materia);
                    this.materiaAdapter.notifyDataSetChanged();
                }
            }
        }
    }
}
