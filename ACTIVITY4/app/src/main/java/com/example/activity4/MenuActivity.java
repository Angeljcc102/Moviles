package com.example.activity4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

public class MenuActivity extends AppCompatActivity {

    private DBHelper db;
    private EditText name, hobby;

    private Properties properties;
    private static final String PROPERTIES_FILE = "properties.xml";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        name = findViewById(R.id.nameT);
        hobby = findViewById(R.id.hobby);

        db = new DBHelper(this);

        properties = new Properties();
        Log.wtf("ARCHIVOS", getFilesDir().toString());
        File file = new File(getFilesDir(), PROPERTIES_FILE);

        if(file.exists()){

            Toast.makeText(this, "EXISTE ARCHIVO", Toast.LENGTH_SHORT).show();

            try {
                // cargar a objeto
                FileInputStream fis = openFileInput(PROPERTIES_FILE);
                properties.loadFromXML(fis);
                fis.close();
            } catch(Exception e){
                e.printStackTrace();
            }
        } else {

            Toast.makeText(this, "NO EXISTE ARCHIVO", Toast.LENGTH_SHORT).show();
            saveProperties();
        }
    }

    private void saveProperties() {

        try{
            FileOutputStream fos = openFileOutput(PROPERTIES_FILE, Context.MODE_PRIVATE);
            properties.storeToXML(fos, null);
            fos.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void guardar(View v){
        db.save(name.getText().toString(), hobby.getText().toString());
        name.setText("");
        hobby.setText("");
        Toast.makeText(this, "GUARDADO, SUPUESTAMENTE", Toast.LENGTH_SHORT).show();
    }

    public void buscar(View v){
        int rows = db.delete(name.getText().toString());
        Toast.makeText(this, "filas afectadas: " + rows, Toast.LENGTH_SHORT).show();
    }

    public void borrar(View v){
        String hoby = db.find(name.getText().toString())+"";
        hobby.setText(hoby + "");
    }
}
