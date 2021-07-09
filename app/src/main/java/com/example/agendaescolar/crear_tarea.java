package com.example.agendaescolar;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.agendaescolar.DB.dbTareas;

import java.util.Calendar;

public class crear_tarea extends AppCompatActivity implements View.OnClickListener{

    Button btnHora, btnFecha,btnSave,btnCancell;
    EditText etNombre,etMateria,etDescripcion;
    TextView textViewHora, textViewFecha;
    private int dia,mes,año,hora,minutos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_tarea);

        btnSave=(Button) findViewById(R.id.btnSave);
        btnCancell=(Button) findViewById(R.id.btnCancell);
        btnFecha=(Button) findViewById(R.id.btnFecha);
        btnHora=(Button) findViewById(R.id.btnHora);
        textViewFecha=(TextView) findViewById(R.id.textViewFecha);
        //editFecha=(EditText) findViewById(R.id.editFecha);

        textViewHora=(TextView) findViewById(R.id.textViewHora);
        //editHora=(EditText) findViewById(R.id.editHora);
        btnFecha.setOnClickListener(this);
        btnHora.setOnClickListener(this);


        //Añadir tarea a la base de datos
        etNombre=(EditText) findViewById(R.id.etNombre);
        etMateria=(EditText) findViewById(R.id.etMateria);
        etDescripcion=(EditText) findViewById(R.id.etDescripcion);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbTareas dbTarea = new dbTareas(crear_tarea.this);
                long id = dbTarea.insertarTarea(etNombre.getText().toString(), etMateria.getText().toString(), etDescripcion.getText().toString(),textViewHora.getText().toString(),textViewFecha.getText().toString());
                if(validar())
                {
                    Toast.makeText(crear_tarea.this,"Tarea creada correctamente" + id, Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(v.getContext(), VerTareas.class);
                    startActivityForResult(intent, 0);
                }
            }
        });

        btnCancell.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });


    }


    //para que ningun campo quede vacio
    public boolean validar()
    {
        boolean retorno=true;
        String c1=etNombre.getText().toString();
        String c2=etMateria.getText().toString();
        String c3=etDescripcion.getText().toString();

        if(c1.isEmpty())
        {
            etNombre.setError("No puede quedar vacio");
            retorno=false;
        }
        if(c2.isEmpty())
        {
            etMateria.setError("No puede quedar vacio");
            retorno=false;
        }
        if(c3.isEmpty())
        {
            etDescripcion.setError("No puede quedar vacio");
            retorno=false;
        }

        return retorno;
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
                    textViewFecha.setText(dayOfMonth+"/"+(month+1)+"/"+year);

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
                    textViewHora.setText(hourOfDay+":"+minute);
                }
            },hora,minutos,false);
            timePickerDialog.show();

        }
    }
}