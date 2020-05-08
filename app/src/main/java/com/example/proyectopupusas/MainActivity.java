package com.example.proyectopupusas;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.firebase.ui.auth.AuthUI;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText etUsuario;
    private EditText etClave;
    private Button btnEntrar;
    private ProgressDialog progressDialog;

    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firebaseAuth = FirebaseAuth.getInstance();

        etUsuario = findViewById(R.id.etUsuario);
        etClave = findViewById(R.id.etPassword);
        btnEntrar = findViewById(R.id.btnLogIn);

        progressDialog = new ProgressDialog(this);

    }


    public void cerrarSesion(View view) {

    }

    public void abrirMenu(View view) {
        final String user = etUsuario.getText().toString().trim();
        String password = etClave.getText().toString().trim();

        if (TextUtils.isEmpty(user)){
            Toast.makeText(this, "Se debe ingresar un usuario", Toast.LENGTH_LONG).show();
            return;
        }

        if (TextUtils.isEmpty(password)){
            Toast.makeText(this, "Falta ingresar la contraseña", Toast.LENGTH_LONG).show();
            return;
        }

        progressDialog.setMessage("Iniciando Sesión");
        progressDialog.show();

        firebaseAuth.signInWithEmailAndPassword(user, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            //Toast.makeText(MainActivity.this, "Bienvenido " + etUsuario.getText(), Toast.LENGTH_SHORT).show();

                            Intent openMain = new Intent(MainActivity.this, PruebaActivity.class);
                            openMain.putExtra("Usuario", user);
                            MainActivity.this.startActivity(openMain);
                            etUsuario.setText("");
                            etClave.setText("");
                            finish();
                        }
                        else {
                            Toast.makeText(MainActivity.this, "Usuario incorrecto " + etUsuario.getText(), Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }
}
