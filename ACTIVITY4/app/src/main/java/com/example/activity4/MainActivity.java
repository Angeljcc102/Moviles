package com.example.activity4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.ThemedSpinnerAdapter;

import android.content.Intent;
import android.os.Bundle;
import android.provider.SyncStateContract;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.File;
import java.util.Properties;

public class MainActivity extends AppCompatActivity {

    private DBHelper db;
    private EditText nombre;
    private Button save;

    private Properties properties;
    private static final String PROPERTIES_FILE = "properties.xml";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nombre = findViewById(R.id.nam);
        save = findViewById(R.id.sig);

        properties = new Properties();
        Log.wtf("ARCHIVOS", getFilesDir().toString());
        File file = new File(getFilesDir(), PROPERTIES_FILE);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cambiarActividad(v);
            }
        });

    }

    public void cambiarActividad(View v){
        Intent intentinto = new Intent(this, MenuActivity.class);
        startActivityForResult(intentinto, 0);
    }
}
