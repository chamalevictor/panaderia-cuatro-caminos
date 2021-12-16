package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Lista extends AppCompatActivity {

    TableLayout tabla;

    //  Lista de clientes.
    Spinner clientes;

    // Campos que llena el usuario.
    EditText panFrances;
    EditText panManteca;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);

        // Titulo basado en opcion mañana o tarde.
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

        tabla = (TableLayout)findViewById(R.id.tabla);

    }

    public void agregarOrden(View v){
//      Inicializando Vistas que se van agregando a la orden.
        TextView viewFecha = new TextView(this);
        TextView viewCliente = new TextView(this);
        TextView viewFrances = new TextView(this);
        TextView viewManteca = new TextView(this);
        TextView viewTotal = new TextView(this);

        int total = 0;
        TableRow fila = new TableRow(this);

        Location ubicacion = new Location("");

        Date fecha = Calendar.getInstance().getTime();
        DateFormat formatoFecha = new SimpleDateFormat("dd-mm-yy hh:mm");
        /*9DateFormat dateFormat = new java.text.format.DateFormat();//android.text.format.DateFormat.getDateFormat(getApplicationContext());
        dateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT).format(date);*/
        //viewFecha.setText(dateFormat.format(date));

        //viewFecha.setText(DateFormat.getDateTimeInstance().format(fecha));

        viewFecha.setText(formatoFecha.format(fecha).toString());


        /*viewFecha.setText(Calendar.getInstance().getTime().toString());*/


        fila.addView(viewFecha);
        viewCliente.setText(clientes.getSelectedItem().toString()); //clientes.getSelectedItem().toString()
        fila.addView(viewCliente);
        viewFrances.setText(panFrances.getText().toString());
        fila.addView(viewFrances);
        viewManteca.setText(panManteca.getText());
        fila.addView(viewManteca);
        total = (Integer.parseInt(panFrances.getText().toString())+Integer.parseInt(panManteca.getText().toString()));
        viewTotal.setText(Integer.valueOf(total).toString());
        fila.addView(viewTotal);
        tabla.addView(fila);
    }




}