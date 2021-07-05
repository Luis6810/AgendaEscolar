package com.example.agendaescolar;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import java.util.Calendar;

public class crear_tarea extends AppCompatActivity implements View.OnClickListener{

    Button btnHora, btnFecha;
    EditText editHora, editFecha;
    private int dia,mes,año,hora,minutos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_tarea);

        btnFecha=(Button) findViewById(R.id.btnFecha);
        btnHora=(Button) findViewById(R.id.btnHora);
        editFecha=(EditText) findViewById(R.id.editFecha);
        editHora=(EditText) findViewById(R.id.editHora);
        btnFecha.setOnClickListener(this);
        btnHora.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if(v==btnFecha){
            final Calendar c= Calendar.getInstance();
            dia=c.get(Calendar.DAY_OF_MONTH);
            mes=c.get(Calendar.MONTH);
            año=c.get(Calendar.YEAR);

            DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                    editFecha.setText(dayOfMonth+"/"+(month+1)+"/"+year);

                }
            },dia,mes,año);
            datePickerDialog.show();
        }
        if (v==btnHora){
            final Calendar c= Calendar.getInstance();
            hora=c.get(Calendar.HOUR_OF_DAY);
            minutos=c.get(Calendar.MINUTE);

            TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
                @Override
                public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                    editHora.setText(hourOfDay+":"+minute);
                }
            },hora,minutos,false);
            timePickerDialog.show();

        }
    }
}