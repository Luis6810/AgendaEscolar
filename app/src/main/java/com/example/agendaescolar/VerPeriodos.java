package com.example.agendaescolar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.agendaescolar.Adaptadores.ListaPeriodosAdapter;
import com.example.agendaescolar.Adaptadores.ListaTareasAdapter;
import com.example.agendaescolar.DB.dbTareas;
import com.example.agendaescolar.Entidades.Tareas;

import java.util.ArrayList;

public class VerPeriodos extends AppCompatActivity {

    RecyclerView listaPeriodos;
    ArrayList<Tareas> listaArrayPeriodos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_periodos);

        listaPeriodos = findViewById(R.id.listaPeriodos);
        listaPeriodos.setLayoutManager(new LinearLayoutManager(this));

        dbTareas dbTareas = new dbTareas(this);
        listaArrayPeriodos = new ArrayList<>();

        ListaPeriodosAdapter adapter = new ListaPeriodosAdapter(dbTareas.mostrarTareas());
        listaPeriodos.setAdapter(adapter);
    }


}