package com.example.formativa_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class modificar extends AppCompatActivity {

    EditText nombre, identificacion,apto, tipo, edtHora,fecha;
    Button modificar;
    RadioGroup radioGroup;
    RadioButton radioButton;

    Usuario user;
    UserController uc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modificar);

        edtHora = findViewById(R.id.edtHora);
        fecha = findViewById(R.id.edtFecha);
        nombre = findViewById(R.id.txt_name);
        identificacion = findViewById(R.id.txt_id);
        apto = findViewById(R.id.txt_apto);
        modificar = findViewById(R.id.btn_modificar);
        radioGroup = findViewById(R.id.radioGroup);

        uc = new UserController(getApplicationContext());

        modificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                user = new Usuario(nombre.getText().toString(),identificacion.getText().toString(), apto.getText().toString(), radioButton.getText().toString(),fecha.getText().toString(),edtHora.getText().toString());
                Toast.makeText(getApplicationContext(), user.identificacion, Toast.LENGTH_SHORT).show();
                if(!uc.buscarUser(user.identificacion)) {
                    Log.d("Buscar", "No encontrado");
                    long id = uc.agregarUsuario(user);
                    Toast.makeText(getApplicationContext(), "Usuario registrado", Toast.LENGTH_SHORT).show();
                }
                else{
                    Log.d("Buscar", "encontrado");
                    Toast.makeText(getApplicationContext(),"Usuario ya esta registrado",Toast.LENGTH_SHORT).show();
                }
            }
        });


    }


    public void checkButton(View v) {
        int radioId = radioGroup.getCheckedRadioButtonId();
        radioButton = findViewById(radioId);

        Toast.makeText(this, "Grupo: " + radioButton.getText(), Toast.LENGTH_SHORT).show();
    }
}
