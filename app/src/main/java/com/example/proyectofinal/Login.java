package com.example.proyectofinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {
public   String tipo;
private EditText correo,contra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        correo=(EditText)findViewById(R.id.et_correo2);
        tipo = getIntent().getStringExtra("type");
        Toast.makeText(this,tipo,Toast.LENGTH_SHORT);

    }
    public void Regresarse(View view){
        Intent inter=new Intent(this,InterMedPac.class);
        startActivity(inter);
    }
   public void RegistrarUsuario(View view){
       Intent registro=new Intent(this,Registro.class);
       registro.putExtra("type",tipo);
       startActivity(registro);
   }
    public void Login(View view){
        Intent intercon=new Intent(this,InterCitas.class);
        startActivity(intercon);
    }
}