package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class Lista extends AppCompatActivity {

    // Campos que llena el usuario.
    EditText panFrances;
    EditText panManteca;

    // Campos de la tabla que se llenan automaticamente.
    TextView viewFecha;
    Spinner clientes;
    TextView viewCliente;
    TextView viewFrances;
    TextView viewManteca;
    TextView viewTotal;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);

        /*
           Colocando el texto para el titulo
           basado en el boton seleccionado de
           la actividad anterior.
         */
        Intent intent = getIntent();
        String listaRecibida = intent.getStringExtra("lista");
        TextView titulo = (TextView)findViewById(R.id.titulo);
        titulo.setText("LISTA " + listaRecibida);

        // Lista de clientes con Spinner.
        Spinner mySpinner = (Spinner)findViewById(R.id.clientes);
        ArrayAdapter<String> listaClientes = new ArrayAdapter<String>(Lista.this, android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.Clientes));
        listaClientes.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner.setAdapter(listaClientes);
        clientes = (Spinner) findViewById(R.id.clientes);


//      Inicializando Campos de cantidades llenados por usuario.
        panFrances = (EditText) findViewById(R.id.cantidadFrances);
        panManteca = (EditText) findViewById(R.id.cantidadManteca);


//      Inicializando Vistas que se van agregando a la orden.
        viewFecha = (TextView)findViewById(R.id.txtFecha);
        viewCliente = (TextView)findViewById(R.id.txtCliente);
        viewFrances = (TextView)findViewById(R.id.txtFrannces);
        viewManteca = (TextView)findViewById(R.id.txtManteca);
        viewTotal = (TextView)findViewById(R.id.txtTotal);


    }



    public void agregarOrden(View v){
        int total = 0;
        
        viewFecha.setText(Calendar.getInstance().getTime().toString());
        viewCliente.setText(clientes.getSelectedItem().toString());
        viewFrances.setText(panFrances.getText());
        viewManteca.setText(panManteca.getText());
        total = (Integer.parseInt(panFrances.getText().toString())+Integer.parseInt(panManteca.getText().toString()));
        viewTotal.setText(Integer.valueOf(total).toString());

    }

}