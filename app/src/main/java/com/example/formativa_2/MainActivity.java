package com.example.formativa_2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TimePicker;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText nombre, identificacion,apto, tipo, edtHora, fecha;
    Button guardar, listar;
    RadioGroup radioGroup;
    RadioButton radioButton;
    private long fechaAgenda;
    Usuario user;
    UserController uc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        edtHora = findViewById(R.id.edtHora);
        fecha = findViewById(R.id.edtFecha);
        nombre = findViewById(R.id.txt_name);
        identificacion = findViewById(R.id.txt_id);
        apto = findViewById(R.id.txt_apto);
        guardar = findViewById(R.id.btn_guardar);
        listar = findViewById(R.id.btn_lista);
        radioGroup = findViewById(R.id.radioGroup);

        uc = new UserController(getApplicationContext());

        fecha.setOnClickListener(this);
        edtHora.setOnClickListener(this);
        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                user = new Usuario(nombre.getText().toString(),identificacion.getText().toString(), apto.getText().toString(), radioButton.getText().toString(), fecha.getText().toString(),edtHora.getText().toString());
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

        listar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),Listado.class);
                startActivity(i);
            }
        });


    }

    public void checkButton(View v) {
        int radioId = radioGroup.getCheckedRadioButtonId();

        radioButton = findViewById(radioId);

        Toast.makeText(this, "Grupo: " + radioButton.getText(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View view) {
        if (view == fecha){
            final Calendar calendario = Calendar.getInstance();

            DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker datePicker, int year, int mes, int dia) {
                    Calendar calendarResultado = Calendar.getInstance();
                    calendarResultado.set(Calendar.YEAR,year);
                    calendarResultado.set(Calendar.MONTH,mes);
                    calendarResultado.set(Calendar.DAY_OF_MONTH,dia);
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
                    Date date = calendarResultado.getTime();
                    String fechaDeNacimientoTexto = simpleDateFormat.format(date).toString();
                    fechaAgenda = date.getTime();
                    fecha.setText(fechaDeNacimientoTexto);
                }
            },calendario.get(Calendar.YEAR),calendario.get(Calendar.MONTH),calendario.get(Calendar.DAY_OF_MONTH));
            datePickerDialog.show();


        }
        if (view == edtHora){
            final Calendar Calendario = Calendar.getInstance();

            TimePickerDialog timePickerDialog = new TimePickerDialog(MainActivity.this, new TimePickerDialog.OnTimeSetListener() {
                @Override
                public void onTimeSet(TimePicker timePicker, int i, int i1) {
                    final Calendar calendario = Calendar.getInstance();
                    calendario.set(Calendar.HOUR,i);
                    calendario.set(Calendar.MINUTE,i1);
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("h:mm", Locale.getDefault());
                    Date date = calendario.getTime();
                    String hora = simpleDateFormat.format(date);

                    edtHora.setText(hora);
                }
            },Calendario.get(Calendar.HOUR),Calendario.get(Calendar.MINUTE),false);
            timePickerDialog.show();
        }
    }
}
