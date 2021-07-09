package com.example.agendaescolar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.agendaescolar.Adaptadores.ListaTareasAdapter;
import com.example.agendaescolar.DB.dbTareas;
import com.example.agendaescolar.Entidades.Tareas;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class VerTareas extends AppCompatActivity {

    RecyclerView listaTareas;
    ArrayList<Tareas> listaArrayTareas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_tareas);

        FloatingActionButton newTask = findViewById(R.id.btnNewTask);
        newTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), crear_tarea.class);
                startActivityForResult(intent, 0);
            }
        });

        listaTareas = findViewById(R.id.listaTareas);
        listaTareas.setLayoutManager(new LinearLayoutManager(this));

        dbTareas dbTareas = new dbTareas(this);
        listaArrayTareas = new ArrayList<>();

        ListaTareasAdapter adapter = new ListaTareasAdapter(dbTareas.mostrarTareas());
        listaTareas.setAdapter(adapter);



    }


}