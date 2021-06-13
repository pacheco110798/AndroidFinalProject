package com.example.proyectofinal;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;


import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.content.ContentValues;

import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TextView nombre,correo,fecha;
    private Spinner especialidad, hora;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        Intent inter=new Intent(this,InterMedPac.class);
        startActivity(inter);
    }/*
    public void RegistrarMedico(){

    }
    public void CrearCita(View view){
        BaseDatos admin=new BaseDatos(this,"administracion",null,1);
        SQLiteDatabase db = admin.getWritableDatabase();
        String Nombre=nombre.getText().toString();
        String Fecha =fecha.getText().toString();
        String Correo=correo.getText().toString();
        String Especialidad=especialidad.getSelectedItem().toString();
        String Hora=especialidad.getSelectedItem().toString();
        String ID;
        if(!Nombre.isEmpty()||!Correo.isEmpty()&&!Fecha.isEmpty()){
            ContentValues registro = new ContentValues();
            registro.put("ID_cita", 1);
            registro.put("nombre",Nombre);
            registro.put("correo",Correo);
            registro.put("fecha",Fecha);
            registro.put("especialidad","random");
            registro.put("Hora","hora");
            db.insert("citas",null,registro);
            db.close();
            nombre.setText("");
            correo.setText("");
            fecha.setText("");
            Toast.makeText(this,"Se ha agendado la cita",Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this,"Favor de llenar todos los campos",Toast.LENGTH_SHORT).show();
        }*/

}