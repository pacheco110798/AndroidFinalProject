package com.example.proyectofinal;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class InterMedPac extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inter_med_pac);
    }
    public void Medico(View view){
        Intent login=new Intent(this,Login.class);
        login.putExtra("type", "medico");
        startActivity(login);
    }
    public void Paciente(View view){
        Intent login=new Intent(this,Login.class);
        login.putExtra("type", "paciente");
        startActivity(login);
    }
}