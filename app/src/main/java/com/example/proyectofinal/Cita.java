package com.example.proyectofinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Cita extends AppCompatActivity {
    private TextView nombre,correo,fecha;
    private Spinner especialidad, hora;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cita);
        nombre=(EditText)findViewById(R.id.txtNombre);
        correo=(EditText)findViewById(R.id.txtEmail);
        fecha=(EditText)findViewById(R.id.dtFecha);
        especialidad=(Spinner)findViewById(R.id.spinEspecialidades);
        String [] especialidades={"Pediatría","Cardiología","Hematología","Internista","Psiquiatría"};
        ArrayAdapter<String> adapterSpinner = new ArrayAdapter<String>(this, R.layout.layoutspinner,especialidades);
        especialidad.setAdapter(adapterSpinner);
        hora=(Spinner)findViewById(R.id.spinHora);
        String [] horario={"10:00","11:00","12:00","13:00","14:00","16:00","17:00","18:00"};//crear un metodo que indique las horas disponibles
        ArrayAdapter<String> adapterSpinner2 = new ArrayAdapter<String>(this, R.layout.layoutspinner,horario);
        hora.setAdapter(adapterSpinner2);
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
        }
    }
}