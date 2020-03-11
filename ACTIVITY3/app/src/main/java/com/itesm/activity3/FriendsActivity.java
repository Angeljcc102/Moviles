package com.itesm.activity3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class FriendsActivity extends AppCompatActivity {

    private ImageView imagenAmigos;
    private Button bac;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friends);

        imagenAmigos = findViewById(R.id.imageView2);
        bac = findViewById(R.id.bacFriends);

        bac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cambiarAtividad(v);
            }
        });
    }

    public void cambiarAtividad(View v){
        Intent intentito = new Intent(this, MenuActivity.class);
        intentito.putExtra("nombresin", getIntent().getStringExtra("nombresin"));
        startActivity(intentito);
    }
}
