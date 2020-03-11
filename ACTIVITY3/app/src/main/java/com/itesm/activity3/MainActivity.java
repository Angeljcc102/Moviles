package com.itesm.activity3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.session.MediaController;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText nombre;
    private Button botonNombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nombre = findViewById(R.id.nombresin);
        botonNombre = findViewById(R.id.botonNombre);

        botonNombre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cambiarActividad(v);
            }
        });

    }

    public void cambiarActividad(View v){

        // cambiar de actividad
        // crear una solicitud
        Intent intentito = new Intent(this, MenuActivity.class);

        //startActivity(intentito);

        intentito.putExtra("nombresin", nombre.getText().toString());

        startActivity(intentito);

    }
}
