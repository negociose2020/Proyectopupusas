package com.example.proyectopupusas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class PruebaActivity extends AppCompatActivity {

    private String recibiendo;
    private TextView tvRecibiendo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prueba);

        Intent i = this.getIntent();
        recibiendo = i.getStringExtra("Usuario");

        tvRecibiendo = findViewById(R.id.tvTexto);
        tvRecibiendo.setText("Bienvenido " + recibiendo);
    }
}
