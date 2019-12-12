package org.izv.pgc.mycontentresolver;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText etNombre, etTelefono;
    private Button btBuscar;

    private String nombre = "nombre", telefono ="telefono";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    private void init() {
        etNombre = findViewById(R.id.etNombre);
        etTelefono = findViewById(R.id.etTelefono);

        btBuscar = findViewById(R.id.btBuscar);
        btBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(chekInputs()){
                    Intent i = new Intent(MainActivity.this, ContactoActivity.class);
                    i.putExtra("nombre", etNombre.getText().toString());
                    i.putExtra("telefono", etTelefono.getText().toString());
                    startActivity(i);
                }else{
                    Toast.makeText(MainActivity.this, "Algun campo está vacio", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private boolean chekInputs() {
        boolean chekInputs = true;
        if (etNombre.getText().toString().isEmpty() || etTelefono.getText().toString().isEmpty()){
            chekInputs = false;
        }
        return chekInputs;
    }



}