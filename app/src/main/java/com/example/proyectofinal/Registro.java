package com.example.proyectofinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Registro extends AppCompatActivity {
    private EditText nombrereg, contrasenareg, correoreg, especialidadreg;
    public TextView tvnombre;
    private Spinner Especialidades;
    private RadioButton rbMedico, rbPaciente;
    private String tipo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        nombrereg=(EditText)findViewById(R.id.et_nombrereg);
        correoreg=(EditText)findViewById(R.id.et_correoreg);
        contrasenareg=(EditText)findViewById(R.id.et_contrasenareg);
        tipo=getIntent().getStringExtra("type");
        tvnombre=(TextView)findViewById(R.id.tv_nombre);

        Especialidades=(Spinner)findViewById(R.id.spin_especialidades);
        String [] especialidades={"Pediatría","Cardiología","Hematología","Internista","Psiquiatría"};
        ArrayAdapter<String> adapterSpinner2 = new ArrayAdapter<String>(this,R.layout.layoutspinner,especialidades);
        Especialidades.setAdapter(adapterSpinner2);
        CambiarInterfaz(tipo);
    }
    public void CambiarInterfaz(String tipo){
        tvnombre.setText(tipo);
        if(tipo.contentEquals("medico")){
            tvnombre.setText(tipo);
        }
        else if(tipo.equals("paciente")){
            Especialidades.setVisibility(View.INVISIBLE);
        }
    }

    public int ultimoID(String campo,String tabla){
        int UltimoID=0;

         BaseDatos admin = new BaseDatos(this,"administracion",null,1);
            SQLiteDatabase baseDatos= admin.getWritableDatabase();

            Cursor fila = baseDatos.rawQuery("select MAX("+campo+") FROM "+tabla,null);
            if(fila.moveToFirst()){
               UltimoID=Integer.parseInt(fila.getString(0));
               Toast.makeText(this,UltimoID, Toast.LENGTH_SHORT).show();
                baseDatos.close();
            }
            else{
                Toast.makeText(this,"No existe el artículo", Toast.LENGTH_SHORT).show();
                baseDatos.close();
            }

        return UltimoID;
    }
    public void Registrar(View view){

        BaseDatos admin=new BaseDatos(this,"administracion",null,1);
        SQLiteDatabase db = admin.getWritableDatabase();
        String Nombre=nombrereg.getText().toString();
        String Password =contrasenareg.getText().toString();
        String Correo=correoreg.getText().toString();
        if(tipo=="medico"){
            String Especialid =Especialidades.getSelectedItem().toString();
        }

        if((!Nombre.isEmpty()||!Correo.isEmpty()&&!Password.isEmpty())&&(tipo=="paciente")){
            ContentValues registro = new ContentValues();
            //db.execSQL("create table usuarios(ID_user int primary key, nombre text, correo text, password text)");
            int ID=ultimoID("ID_user","usuarios");
            registro.put("ID_user", ID);
            registro.put("nombre",Nombre);
            registro.put("correo",Correo);
            registro.put("password",Password);
            db.insert("usuario",null,registro);
            db.close();
            nombrereg.setText("");
            correoreg.setText("");
            contrasenareg.setText("");
            Toast.makeText(this,"Registro exitoso",Toast.LENGTH_SHORT).show();
        }
        else if((!Nombre.isEmpty()||!Correo.isEmpty()&&!Password.isEmpty())&&(tipo=="paciente")){
            int ID=ultimoID("ID_medico","medicos");
            ContentValues registro = new ContentValues();
            //db.execSQL("create table medicos(ID_medico int primary key, especialidad text, nombre text ,correo text,password text)");
            String Especialid =Especialidades.getSelectedItem().toString();
            registro.put("ID_medico", ID);
            registro.put("nombre",Nombre);
            registro.put("correo",Correo);
            registro.put("password",Password);
            registro.put("especialidad",Especialid);
            db.insert("medicos",null,registro);
            db.close();
            nombrereg.setText("");
            correoreg.setText("");
            contrasenareg.setText("");
            Toast.makeText(this,"Registro exitoso",Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this,"Favor de llenar todos los campos",Toast.LENGTH_SHORT).show();
        }
    }
    public void Regresarse(View view){
        Intent login=new Intent(this,Login.class);
        login.putExtra("type",tipo);
        startActivity(login);
    }
}