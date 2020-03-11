package com.itesm.activity3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MessageActivity extends AppCompatActivity {

    private Button enviar;
    private EditText mensajon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);

        enviar = findViewById(R.id.send);
        mensajon = findViewById(R.id.messageText);

        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cambiarActividad(v);
            }
        });
    }

    public void cambiarActividad(View v){
        Intent intentito = new Intent(this, MenuActivity.class);
        Toast.makeText(this, mensajon.getText().toString(), Toast.LENGTH_LONG).show();
        intentito.putExtra("nombresin", getIntent().getStringExtra("nombresin"));
        startActivity(intentito);
    }
}
