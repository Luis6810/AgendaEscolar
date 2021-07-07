package com.example.agendaescolar.DB;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class AgendaDB extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "agenda.db";
    public static final String TABLE_TAREAS = "t_contactos";
    public static final String TABLE_PERIODOS = "t_periodos";


    public AgendaDB(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_TAREAS + "(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT,"+
                "nombre varchar NOT NULL,"+
                "materia varchar NOT NULL,"+
                "descripcion varchar NOT NULL,"+
                "fecha varchar NOT NULL,"+
                "hora varchar NOT NULL)"
        );

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
