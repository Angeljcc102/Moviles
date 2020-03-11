package com.example.activity4;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

class DBHelper  extends SQLiteOpenHelper {

    private static final String DB_FILE = "Database.db";

    private static final String TABLE = "Hobbies";
    private static final String HOBBIE_NAME = "name";
    private static final String FRIENDS_NAME = "friend";

    public DBHelper(Context context) {
        super(context, DB_FILE, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE + "(" +
                HOBBIE_NAME + " TEXT, " +
                FRIENDS_NAME + " TEXT)";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String query = "DROP TABLE IF EXISTS ?";
        String[] params = {TABLE};
        db.execSQL(query, params);

    }

    public void save(String nombreH, String nombreF){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues valores = new ContentValues();

        valores.put(HOBBIE_NAME, nombreH);
        valores.put(FRIENDS_NAME, nombreF);

        db.insert(TABLE, null, valores);
    }

    public int delete(String nombreF){
        SQLiteDatabase dbb = getWritableDatabase();
        String clause = FRIENDS_NAME + " = ?";
        String[] args = {nombreF};
        return dbb.delete(TABLE, clause, args);
    }

    public int find(String nombreH){
        SQLiteDatabase db = getReadableDatabase();
        String filtro = HOBBIE_NAME + " = ?";
        String[] args = {nombreH};

        Cursor c = db.query(TABLE, null, filtro, args, null, null, null);
        int result = -1;

        if(c.moveToFirst()){

            result = c.getInt(2);
        }

        return result;

    }
}
