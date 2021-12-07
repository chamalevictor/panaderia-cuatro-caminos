package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MenuListas extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_listas);

        Intent intent = getIntent();


    }

    public void goToNext(View view){
        Intent myIntent = new Intent(MenuListas.this, MenuCrearLista.class);
        startActivity(myIntent);
    }

    public void noLists(View toastView) {
        Toast toast = Toast.makeText(this, "No hay listas existentes.", Toast.LENGTH_LONG);
                toast.show();
    }

}