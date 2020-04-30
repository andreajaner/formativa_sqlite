package com.example.formativa_2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TimePicker;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Actualizar extends AppCompatActivity {

    UserController c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actualizar);

        c = new UserController(getApplicationContext());


        Button btnActualizar = (Button)findViewById(R.id.btnActualizar);
        final Button btnDevolver = (Button)findViewById(R.id.btnAtras);
         final EditText edtNombre = findViewById(R.id.edtNombree);
         final EditText edtId = findViewById(R.id.edtIdd);
         final EditText edtApartamento = findViewById(R.id.edtApartamentoo);
         final EditText edtFecha = findViewById(R.id.edtFechaa);
         final EditText edtHora = findViewById(R.id.edtHoraa);
        //rd = view.findViewById(R.id.radioGroupp);
         final RadioButton radioButton1 = findViewById(R.id.radioButtonn1);
         final RadioButton radioButton2 = findViewById(R.id.radioButtonn2);
         final RadioButton radioButton3 = findViewById(R.id.radioButtonn3);

        edtFecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar calendario = Calendar.getInstance();

                DatePickerDialog datePickerDialog = new DatePickerDialog(Actualizar.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int mes, int dia) {
                        Calendar calendarResultado = Calendar.getInstance();
                        calendarResultado.set(Calendar.YEAR,year);
                        calendarResultado.set(Calendar.MONTH,mes);
                        calendarResultado.set(Calendar.DAY_OF_MONTH,dia);
                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
                        Date date = calendarResultado.getTime();
                        String fechaDeNacimientoTexto = simpleDateFormat.format(date).toString();
                        edtFecha.setText(fechaDeNacimientoTexto);
                    }
                },calendario.get(Calendar.YEAR),calendario.get(Calendar.MONTH),calendario.get(Calendar.DAY_OF_MONTH));
                datePickerDialog.show();

            }
        });

        edtHora.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar Calendario = Calendar.getInstance();

                TimePickerDialog timePickerDialog = new TimePickerDialog(Actualizar.this, new TimePickerDialog.OnTimeSetListener() {
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
        });

        btnActualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (radioButton1.isChecked()) {
                    boolean actualizar = c.actualizar(edtNombre.getText().toString(), edtId.getText().toString(),
                            edtApartamento.getText().toString(), radioButton1.getText().toString(), edtFecha.getText().toString(),
                            edtHora.getText().toString());
                    if (actualizar == true) {
                        Toast.makeText(Actualizar.this, "Se actualizo correctamente", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(Actualizar.this,Listado.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(Actualizar.this, "ha ocurrido un error, intentalo mas tarde", Toast.LENGTH_SHORT).show();

                    }
                } else if (radioButton2.isChecked()) {
                    boolean actualizar = c.actualizar(edtNombre.getText().toString(), edtId.getText().toString(),
                            edtApartamento.getText().toString(), radioButton2.getText().toString(), edtFecha.getText().toString(),
                            edtHora.getText().toString());
                    if (actualizar == true) {
                        Toast.makeText(Actualizar.this, "Se actualizo correctamente", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(Actualizar.this,Listado.class);
                        startActivity(intent);

                    } else {
                        Toast.makeText(Actualizar.this, "ha ocurrido un error, intentalo mas tarde", Toast.LENGTH_SHORT).show();


                    }
                } else if (radioButton3.isChecked()) {
                    boolean actualizar = c.actualizar(edtNombre.getText().toString(), edtId.getText().toString(),
                            edtApartamento.getText().toString(), radioButton3.getText().toString(), edtFecha.getText().toString(),
                            edtHora.getText().toString());
                    if (actualizar == true) {
                        Toast.makeText(Actualizar.this, "Se actualizo correctamente", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(Actualizar.this,Listado.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(Actualizar.this, "ha ocurrido un error, intentalo mas tarde", Toast.LENGTH_SHORT).show();

                    }
                }
            }
        });


        btnDevolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
