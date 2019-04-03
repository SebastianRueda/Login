package com.infinixsoft.login;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.infinixsoft.login.entity.adapter.ObjetivoAdapter;

import java.util.ArrayList;
import java.util.List;

public class ObjetivosActivity extends AppCompatActivity {

    private ObjetivoAdapter objetivoAdapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setTitle("Objetivos");
        setContentView(R.layout.activity_objetivos);

        List<String> objetivos = new ArrayList<String>();

        objetivos.add("objetivo1");
        objetivos.add("objetivo2");
        objetivos.add("objetivo3");
        objetivos.add("objetivo4");
        objetivos.add("objetivo5");

        this.objetivoAdapter = new ObjetivoAdapter(objetivos);
        this.recyclerView = findViewById(R.id.recyclerViewObjetivo);
        this.recyclerView.setAdapter(this.objetivoAdapter);
        this.recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
    }
}
