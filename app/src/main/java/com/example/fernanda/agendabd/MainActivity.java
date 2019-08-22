package com.example.fernanda.agendabd;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fernanda.agendabd.Modelos.ModeloContacto;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public Button btnAdicionar;
    public Button btnBuscar;
    public Button btnEliminar;
    public Button btnEditar;
    public TextView t1;
    public TextView t2;
    public TextView busqueda;
    Logica logica;
    final List<String> contactos = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t1=(TextView) findViewById(R.id.t1);
        t2=(TextView) findViewById(R.id.t2);
        busqueda=(TextView) findViewById(R.id.busqueda);
        btnAdicionar=(Button) findViewById(R.id.adicionar);
        btnBuscar=(Button) findViewById(R.id.buscar);
        btnEliminar=(Button) findViewById(R.id.eliminar);
        btnEditar=(Button) findViewById(R.id.editar);
        logica= new Logica(getApplicationContext());
        btnAdicionar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
              logica.adicionar_contacto(t1.getText().toString(),Integer.parseInt(t2.getText().toString()));
                Toast.makeText(getApplicationContext(),"Se ha adicionado correctamente",Toast.LENGTH_LONG).show();

            }
        });
        btnEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               logica.delete_contacto(t1.getText().toString());
                Toast.makeText(getApplicationContext(),"Se ha eliminado correctamente",Toast.LENGTH_LONG).show();

            }
        });
        btnEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logica.editar_contacto(t1.getText().toString(),Integer.parseInt(t2.getText().toString()));
                Toast.makeText(getApplicationContext(),"Se ha editado correctamente",Toast.LENGTH_LONG).show();

            }
        });
        btnBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ModeloContacto ret = logica.encontrar_contacto(t1.getText().toString());
                String  cadena="";
                if(ret!=null)
                    cadena="nombre:    "+ret.getNombre() +"\nnumero:  "+ret.getNumero()+"\n";
                else
                    cadena="el contacto no existe";
                busqueda.setText(cadena);
            }
        });



    }
}
