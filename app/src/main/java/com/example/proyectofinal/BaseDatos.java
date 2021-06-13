package com.example.proyectofinal;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class BaseDatos extends SQLiteOpenHelper {
    public BaseDatos(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version){
        super(context,name,factory,version);
    }
    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL("create table citas(ID_cita int primary key, ID_user int, ID_med int, fecha text, hora text, estatus int)");
        db.execSQL("create table medicos(ID_medico int primary key, especialidad text, nombre text, correo text, password text )");
        db.execSQL("create table especialidad(ID_especialidad int primary key, nombre text)");
        db.execSQL("create table usuarios(ID_user int primary key, nombre text, correo text, password text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


}