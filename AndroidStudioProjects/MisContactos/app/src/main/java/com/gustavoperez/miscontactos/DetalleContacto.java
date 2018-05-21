package com.gustavoperez.miscontactos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;

import java.util.EmptyStackException;

public class DetalleContacto extends AppCompatActivity {

    EditText etNombreAlta, etTlfAlta, etMailAlta, etDescripcAlta, etFNacAlta;
    Button btVolver, btEditar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_contacto);

        btVolver = (Button) findViewById(R.id.btVolver);
        btEditar = (Button) findViewById(R.id.btEditar);

        recibirDatos();

        btVolver.setOnClickListener (new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent toPrincipal = new Intent(DetalleContacto.this, MainActivity.class);
                startActivity(toPrincipal);
            }
        });

        btEditar.setOnClickListener (new View.OnClickListener(){
            @Override
            public void onClick(View v2) {
                finish();
            }
        });
    }

    private void recibirDatos() {
        Bundle extras = getIntent().getExtras();
        String dnombre = extras.getString("datonombre");
        String dtlf = extras.getString("datotlf");
        String dmail = extras.getString("datomail");
        String ddescrip = extras.getString("datodescrip");
        String dfnac = extras.getString("datofNac");

        etNombreAlta = (EditText) findViewById(R.id.etNombreAlta2);
        etNombreAlta.setText(dnombre);
        etTlfAlta = (EditText) findViewById(R.id.etTlfAlta2);
        etTlfAlta.setText(dtlf);
        etMailAlta = (EditText)  findViewById(R.id.etMailAlta2);
        etMailAlta.setText(dmail);
        etDescripcAlta = (EditText) findViewById(R.id.etDescripAlta2);
        etDescripcAlta.setText(ddescrip);
        etFNacAlta = (EditText)findViewById(R.id.etFNacAlta2);
        etFNacAlta.setText(dfnac);
    }
}
