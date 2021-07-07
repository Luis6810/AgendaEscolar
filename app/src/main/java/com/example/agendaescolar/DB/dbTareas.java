package com.example.agendaescolar.DB;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.example.agendaescolar.MainActivity;

public class dbTareas extends AgendaDB {

    Context context;

    public dbTareas(@Nullable @org.jetbrains.annotations.Nullable Context context) {
        super(context);
        this.context = context;
    }

    public long insertarTarea(String nombre, String materia, String descripcion, String hora, String fecha){

        long id=0;
        try {
            AgendaDB agendaDB = new AgendaDB(context);
            SQLiteDatabase db = agendaDB.getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put("nombre", nombre);
            values.put("materia", materia);
            values.put("descripcion", descripcion);
            values.put("hora", hora);
            values.put("fecha", fecha);
            values.put("periodo", "7° Semestre");

            id = db.insert(TABLE_TAREAS, null, values);


        }catch(Exception ex){
                ex.toString();
        }
        return id;
    }
}
