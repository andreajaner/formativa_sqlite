package com.example.formativa_2;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class BaseDatos extends SQLiteOpenHelper {


    public BaseDatos(Context context) {
        super(context, DefBD.nameDb, null, 4);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DefBD.create_tabla_user);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int x, int y) {
        onCreate(db);

    }


}