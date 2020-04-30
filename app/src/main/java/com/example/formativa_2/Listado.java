package com.example.formativa_2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TimePicker;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Listado extends AppCompatActivity {

    UserController c;
    ListView listado;
    RadioButton radioButton;
    RadioGroup rd;
    UsuarioCursorAdapter uca;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado);

        listado = findViewById(R.id.listado);
        c = new UserController(getApplicationContext());

        Cursor cur = c.allUsers();

        uca = new UsuarioCursorAdapter(this,cur,0);
        listado.setAdapter(uca);





        if(getSupportActionBar()!= null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        }


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.actualizar){

            Intent intent = new Intent(Listado.this, Actualizar.class);
            startActivity(intent);

        }
        else if(id == R.id.eliminar){

            Intent intent = new Intent(Listado.this, Eliminar.class);
            startActivity(intent);

        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    protected void onResume() {
        super.onResume();
        uca.notifyDataSetChanged();
    }
}
