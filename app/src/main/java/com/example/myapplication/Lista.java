package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
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
        ImageButton viewDelete = new ImageButton(this);
        TableRow fila = new TableRow(this);
        int total = 0;

//      Detectando campos vacios.
        viewDelete.setBackgroundResource(R.drawable.delete);
        if(panFrances.getText().toString().equals(""))
            viewFrances.setText("0");
        else
            viewFrances.setText(panFrances.getText().toString());

        if(panManteca.getText().toString().equals(""))
            viewManteca.setText("0");
        else
            viewManteca.setText(panManteca.getText());

//      Obteniendo fecha y dandole formato.
        Date fecha = Calendar.getInstance().getTime();
        DateFormat formatoFecha = new SimpleDateFormat("dd-MM-yy hh:mm");
        viewFecha.setText(formatoFecha.format(fecha).toString());


//      Agregando todas las views a a la fila y tabla.
        fila.addView(viewFecha);
        viewCliente.setText(clientes.getSelectedItem().toString()); //clientes.getSelectedItem().toString()
        fila.addView(viewCliente);
        fila.addView(viewFrances);
        fila.addView(viewManteca);
        total = (Integer.parseInt(viewFrances.getText().toString())+Integer.parseInt(viewManteca.getText().toString()));
        viewTotal.setText(Integer.valueOf(total).toString());
        fila.addView(viewTotal);
        fila.addView(viewDelete);
        tabla.addView(fila, 1);


    }
}