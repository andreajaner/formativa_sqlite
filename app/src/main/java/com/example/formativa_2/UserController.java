package com.example.formativa_2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.security.spec.ECField;

import static com.example.formativa_2.DefBD.tabla_user;

public class UserController {
    private BaseDatos db;

    public UserController(Context context) {
        this.db = new BaseDatos(context);
    }

    public long agregarUsuario (Usuario u) {
        try {
            SQLiteDatabase database = db.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put(DefBD.col_id, u.identificacion);
            values.put(DefBD.col_name, u.nombre);
            values.put(DefBD.col_apto, u.apto);
            values.put(DefBD.col_tipo, u.tipo);
            values.put(DefBD.col_fecha, u.fecha);
            values.put(DefBD.col_hora, u.hora);

            long idd= database.insert(tabla_user, null, values);
            return idd;
        } catch (Exception e) {
            System.out.println("Error al insertar");
            return 0;
        }
    }

    public  boolean buscarUser(String cod){
        String[] args = new String[]{cod};
        SQLiteDatabase database = db.getReadableDatabase();
        Cursor c = database.query(tabla_user, null, "identificacion=?", args,null, null, null);
        if (c.getCount()>0){
            database.close();
            return true;
        }else{
            database.close();
            return false;
        }
    }

    public Cursor allUsers(){
        try {
            SQLiteDatabase database = db.getWritableDatabase();
            Cursor cur = database.rawQuery("select nombre as _id , identificacion, apto, tipo, fecha, hora from usuario",null);
            return cur;
        }catch (Exception e){
            System.out.println("Error de consulta");
            return null;
        }

    }

    public boolean actualizar(String nombre,String identificacion, String apto, String rd, String fecha, String hora){
        SQLiteDatabase database = db.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(DefBD.col_id, identificacion);
        values.put(DefBD.col_name, nombre);
        values.put(DefBD.col_apto, apto);
        values.put(DefBD.col_tipo, rd);
        values.put(DefBD.col_fecha, fecha);
        values.put(DefBD.col_hora, hora);
        database.update(tabla_user,values,"identificacion = ?", new String[]{identificacion});
        return true;
    }

    public Integer eliminar(String id){
        SQLiteDatabase database = db.getWritableDatabase();
        return database.delete(tabla_user, "identificacion = ?", new String[]{id});
    }


}

