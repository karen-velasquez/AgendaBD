package com.example.fernanda.agendabd;

import android.content.Context;

import com.example.fernanda.agendabd.BDD.BaseDeDatos;
import com.example.fernanda.agendabd.Modelos.ModeloContacto;

import java.util.ArrayList;
import java.util.List;

public class Logica {
    BaseDeDatos data;

    public Logica(Context context)
    {
        data = new BaseDeDatos(context, BaseDeDatos.name, null, BaseDeDatos.version);
    }

    public void adicionar_contacto (String nombre, int numero)
    {
        ModeloContacto rrrw = new ModeloContacto(nombre,numero);
        if(encontrar_contacto(nombre)== null)
            data.addContacto(rrrw);
    }
    public void editar_contacto ( String nombre, int numero)
    {
        ModeloContacto ret = encontrar_contacto(nombre);
        ModeloContacto neew = new ModeloContacto(ret.getId(),nombre,numero);
        data.cambiarContacto(neew);
    }
    public void delete_contacto (String name)
    {
        ModeloContacto ret = encontrar_contacto(name);
        data.deleteContacto(String.valueOf(ret.getId()));
    }
    public ArrayList<ModeloContacto> lista_contacto() {
        return (ArrayList<ModeloContacto>) data.listContactos();

    }
    public ModeloContacto encontrar_contacto(String nombre) {
        List<ModeloContacto> contactos = data.listContactos();
        ModeloContacto ret = null;
        for (ModeloContacto valor : contactos){
            if(valor.getNombre().equals(nombre)){
                ret= valor;
            }
        }
        return ret;

    }
}
