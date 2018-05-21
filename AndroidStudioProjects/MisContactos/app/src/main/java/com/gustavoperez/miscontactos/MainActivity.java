package com.gustavoperez.miscontactos;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;
import android.app.Dialog;
import android.app.DatePickerDialog;

import java.util.Calendar;


public class MainActivity extends AppCompatActivity {

    Calendar cal;
    EditText mDisplayFNac, mDisplayNombre, mDisplayTlf, mDisplayMail, mDisplayDescrip;
    Button mBtAñadir;
    Integer cyear, cmonth, cday;
    DatePickerDialog datePD;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Relaciona las variables java - xml
        relacionarVariables();

        //Ponemos los listeners
        //fijarEscuchas();

        //Preparar Dialog
        //prepareDatePickerDialog();

        mDisplayFNac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Conseguir fecha actual.
                Calendar cal = Calendar.getInstance();
                cyear = cal.get(Calendar.YEAR);
                cmonth = cal.get(Calendar.MONTH);
                cday = cal.get(Calendar.DAY_OF_MONTH);
                //mDisplayFNac.setText(cyear, (cmonth + 1), cday);
                //showDate(year, month+1, day);

                datePD = new DatePickerDialog(MainActivity.this, android.R.style.Theme_Holo_Light_Dialog, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int day_of_month) {
                        mDisplayFNac.setText(day_of_month + "/" + (month + 1) + "/" + year);
                        datePD.dismiss();
                    }
                }, cday, cmonth, cyear);
                datePD.show();
            }
        });

        mBtAñadir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v2) {
                cargarActivity2();
            }
        });
    }

        private void relacionarVariables(){
            mDisplayFNac = (EditText) findViewById(R.id.etFNacAlta);
            mDisplayNombre = (EditText) findViewById(R.id.etNombreAlta);
            mDisplayTlf = (EditText) findViewById(R.id.etTlfAlta);
            mDisplayMail = (EditText) findViewById(R.id.etMailAlta);
            mDisplayDescrip = (EditText) findViewById(R.id.etDescripAlta);
            mBtAñadir = (Button) findViewById(R.id.btAñadir);
        }


        public void cargarActivity2() {
            Intent i = new Intent (MainActivity.this, DetalleContacto.class);
            i.putExtra("datonombre", mDisplayNombre.getText().toString());
            i.putExtra("datotlf", mDisplayTlf.getText().toString());
            i.putExtra("datomail", mDisplayMail.getText().toString());
            i.putExtra("datodescrip", mDisplayDescrip.getText().toString());
            i.putExtra("datofNac", mDisplayFNac.getText().toString());
            startActivity(i);
        }
}
