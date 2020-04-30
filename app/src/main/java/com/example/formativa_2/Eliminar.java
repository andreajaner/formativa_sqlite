package com.example.formativa_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Eliminar extends AppCompatActivity {

    UserController c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_eliminar);

        c = new UserController(getApplicationContext());

        final EditText edtIdEliminar = findViewById(R.id.edtIdEliminar);
        Button btnEliminar = (Button)findViewById(R.id.btnEliminar);
        final Button btnDevolver = (Button)findViewById(R.id.btnAtras);

        btnEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer eliminar = c.eliminar(edtIdEliminar.getText().toString());
                if(eliminar > 0){
                    Toast.makeText(Eliminar.this, "Se elimino correctamente", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(Eliminar.this,Listado.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(Eliminar.this, "No se pudo eliminar, intentalo mas tarde", Toast.LENGTH_SHORT).show();
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
