package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView bienvenido = (TextView)findViewById(R.id.bienvenido);
        bienvenido.setText("Bienvenido!");

    }

    public void goToNext(View view){
        Intent myIntent = new Intent(MainActivity.this, MenuListas.class);
        startActivity(myIntent);
    }


}