package com.example.fernanda.agendabd.BDD;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


import com.example.fernanda.agendabd.Modelos.ModeloContacto;

import java.util.ArrayList;
import java.util.List;

public class BaseDeDatos extends SQLiteOpenHelper {
    public  static final  String name ="name8";
    public  static final  int version =1;

    public BaseDeDatos(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("PRAGMA user_version = 1");
        db.execSQL("PRAGMA foreign_keys = ON");

        String dbPath = db.getPath();
        Log.d("llllllllllllllllll","******************dbpath: "+dbPath);
        String sql ;
        sql= "CREATE  TABLE contacto (id  INTEGER PRIMARY KEY AUTOINCREMENT, nombre TEXT, numero INTEGER)";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS contacto");
        onCreate(db);
    }

    public void addContacto (ModeloContacto contacto){
        ContentValues values = new ContentValues();
        values.put("nombre", contacto.getNombre());
        values.put("numero", contacto.getNumero());
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert("contacto",null,values);
    }

    public void deleteContacto(String id) {
        String[] args={id}; getWritableDatabase().delete("contacto", "id=?", args);
    }

    public List<ModeloContacto> listContactos(){
        String sql = "select * from contacto";
        SQLiteDatabase db = this.getReadableDatabase();
        List<ModeloContacto> ListaContactos = new ArrayList<>();
        Cursor cursor = db.rawQuery(sql, null);
        if (cursor.moveToFirst()){
            do{
                int id = Integer.parseInt( cursor.getString(0));
                String nombre = cursor.getString(1);
                int numero = Integer.parseInt(cursor.getString(2));
                ListaContactos.add(new ModeloContacto(id,nombre,numero));
            }while(cursor.moveToNext());
        }
        cursor.close();
        return ListaContactos;
    }

    public void cambiarContacto(ModeloContacto contacto){
        ContentValues values = new ContentValues();
        values.put("nombre",contacto.getNombre());
        values.put("numero",contacto.getNumero());
        SQLiteDatabase db = this.getWritableDatabase();
        db.update("contacto", values,  "id = ?", new String[] { String.valueOf(contacto.getId())});
    }



}


