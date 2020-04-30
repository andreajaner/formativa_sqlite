package com.example.formativa_2;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

public class UsuarioCursorAdapter extends CursorAdapter {
    public UsuarioCursorAdapter(Context context, Cursor c, int flags) {
        super(context, c, flags);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.dato_user, parent, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView usuarios = (TextView) view.findViewById(R.id.txtusuarios);
        TextView identificaciones = (TextView) view.findViewById(R.id.txtident);
        TextView aptos = (TextView) view.findViewById(R.id.txtapto);
        TextView tipos = (TextView) view.findViewById(R.id.txtipo);
        TextView txtfecha = (TextView) view.findViewById(R.id.txtFecha);
        TextView txthora = (TextView) view.findViewById(R.id.txtHora);

        String nombre = cursor.getString(cursor.getColumnIndexOrThrow("_id"));
        String ide= cursor.getString(cursor.getColumnIndexOrThrow("identificacion"));
        String apto = cursor.getString(cursor.getColumnIndexOrThrow("apto"));
        String tipo = cursor.getString(cursor.getColumnIndexOrThrow("tipo"));
        String fecha = cursor.getString(cursor.getColumnIndexOrThrow("fecha"));
        String hora = cursor.getString(cursor.getColumnIndexOrThrow("hora"));
        usuarios.setText(nombre);
        identificaciones.setText(ide);
        aptos.setText(apto);
        tipos.setText(tipo);
        txtfecha.setText(fecha);
        txthora.setText(hora);

    }
}
