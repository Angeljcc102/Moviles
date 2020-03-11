package com.itesm.activity3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MenuActivity extends AppCompatActivity {

    private TextView hola, nada;
    private Button hobby, friends, leave;
    String nombresin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        hola = findViewById(R.id.Hello);
        nada = findViewById(R.id.textView2);
        leave = findViewById(R.id.mesage);
        hobby = findViewById(R.id.hobbies);
        friends = findViewById(R.id.amigos);


        Intent intentonte = getIntent();

            nombresin = intentonte.getStringExtra("nombresin");
            hola.setText("Hi: " + nombresin);

        if(intentonte.getStringExtra("editText") != null) {
            nada.setText("Hobby: " + intentonte.getStringExtra("editText"));
        }
        hobby.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cambiarActividadH(v);
            }
        });

        friends.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cambiarActividadF(v);
            }
        });

        leave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cambiarActividadL(v);
            }
        });
    }

    public void cambiarActividadH(View v){

        // cambiar de actividad
        // crear una solicitud
        Intent intentito = new Intent(this, HobbyActivity.class);
        intentito.putExtra("nombresin", nombresin);
        startActivity(intentito);

    }

    public void cambiarActividadF(View v){

        // cambiar de actividad
        // crear una solicitud
        Intent intentito = new Intent(this, FriendsActivity.class);
        intentito.putExtra("nombresin", nombresin);
        startActivity(intentito);

    }

    public void cambiarActividadL(View v){

        // cambiar de actividad
        // crear una solicitud
        Intent intentito = new Intent(this, MessageActivity.class);
        intentito.putExtra("nombresin", nombresin);
        startActivity(intentito);

    }
}
