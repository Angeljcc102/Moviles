package com.itesm.activity3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class HobbyActivity extends AppCompatActivity {

    private ImageView imagenH;
    private Button botonBac;
    private EditText hobby;
    private TextView hobbyW;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hobby);

        imagenH = findViewById(R.id.imageView);
        botonBac = findViewById(R.id.button);
        hobby = findViewById(R.id.editText);
        hobbyW = findViewById(R.id.hobbyText);

        botonBac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cambiarActividad(v);
            }
        });

    }

    public void cambiarActividad(View V){
        Intent intentito = new Intent(this, MenuActivity.class);
        intentito.putExtra("editText", hobby.getText().toString());
        intentito.putExtra("nombresin", getIntent().getStringExtra("nombresin"));
        startActivity(intentito);
    }
}
