package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MenuCrearLista extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_crear_lista);

       Intent intent = getIntent();
    }

    public void goToNext(View view){
        Intent myIntent = new Intent(MenuCrearLista.this, Lista.class);
        String lista = new String("");
        switch (view.getId()){
            case R.id.manana:
                lista = "MAÑANA";
                break;
            case R.id.tarde:
                lista = "TARDE";
                break;
            default:
            throw new RuntimeException("Unknown button ID");
        }
        myIntent.putExtra("lista",lista);

        startActivity(myIntent);
    }


}