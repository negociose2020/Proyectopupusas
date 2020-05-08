package com.example.proyectopupusas;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class PruebaActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    private DrawerLayout drawer;
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
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){

            case R.id.nav_restaurante:
                getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment,
                        new PupuseriasFragmento()).commit();
                break;
            case R.id.nav_historial:
                getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment,
                        new HistorialFragmento()).commit();
                break;
            case R.id.nav_salir:
                Toast.makeText(this, "Salir", Toast.LENGTH_SHORT).show();
                break;
        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}
