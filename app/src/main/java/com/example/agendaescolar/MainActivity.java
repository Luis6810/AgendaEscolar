package com.example.agendaescolar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.agendaescolar.DB.AgendaDB;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity);

        AgendaDB dbHelper = new AgendaDB (MainActivity.this);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        if(db!=null){
            Toast.makeText(MainActivity.this,"Base de datos creada", Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(MainActivity.this,"Error al crear la base de datos", Toast.LENGTH_LONG).show();
        }


        Button info = findViewById(R.id.btnTareas);
        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), VerTareas.class);
                startActivityForResult(intent, 0);
            }
        });
    }
}