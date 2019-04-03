package com.infinixsoft.login;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.Button;
import android.widget.LinearLayout;

import com.infinixsoft.login.entity.Materia;
import com.infinixsoft.login.entity.adapter.MateriaAdapter;

import java.util.ArrayList;
import java.util.List;

public class MateriasActivity extends AppCompatActivity {

    private MateriaAdapter materiaAdapter;
    private RecyclerView recyclerView;
    private Button buttonBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setTitle("Materias");
        setContentView(R.layout.activity_materias);

        Toolbar toolbar = findViewById(R.id.toolbarAdd);
        setSupportActionBar(toolbar);

        this.recyclerView = findViewById(R.id.recyclerViewMateria);
        this.buttonBack = findViewById(R.id.buttonBackMateria);

        List<Materia> materias = new ArrayList<Materia>();

        this.materiaAdapter = new MateriaAdapter(materias);

        materias.add(new Materia("Programación", "Cursando", "Ofetada - 1er C"));

        recyclerView.setAdapter(this.materiaAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayout.VERTICAL, false));
    }
}
