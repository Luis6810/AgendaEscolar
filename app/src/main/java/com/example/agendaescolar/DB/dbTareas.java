package com.example.agendaescolar.DB;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.example.agendaescolar.Entidades.Tareas;
import com.example.agendaescolar.MainActivity;

import java.util.ArrayList;

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

            id = db.insert(TABLE_TAREAS, null, values);


        }catch(Exception ex){
                ex.toString();
        }
        return id;
    }

    public ArrayList<Tareas> mostrarTareas(){
        AgendaDB agendaDB = new AgendaDB(context);
        SQLiteDatabase db = agendaDB.getWritableDatabase();

        ArrayList<Tareas> listaTareas = new ArrayList<>();
        Tareas tarea = null;
        Cursor cursorTareas =null;
        cursorTareas = db.rawQuery("SELECT * FROM " + TABLE_TAREAS + " ORDER BY id DESC", null);

        if(cursorTareas.moveToFirst()){
            do{
                tarea = new Tareas();
                tarea.setId(cursorTareas.getInt(0));
                tarea.setNombre(cursorTareas.getString(1));
                tarea.setMateria(cursorTareas.getString(2));
                tarea.setDescripcion(cursorTareas.getString(3));
                tarea.setHora(cursorTareas.getString(4));
                tarea.setFecha(cursorTareas.getString(5));
                listaTareas.add(tarea);
            }while(cursorTareas.moveToNext());
        }

        cursorTareas.close();

        return listaTareas;
    }
}
