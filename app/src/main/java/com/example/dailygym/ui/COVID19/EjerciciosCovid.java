package com.example.dailygym.ui.COVID19;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.dailygym.R;
import com.example.dailygym.ui.cardio.CrearRuta;
import com.example.dailygym.ui.cardio.MapsActivity;

public class EjerciciosCovid extends AppCompatActivity {
    private Button pectoral;
    private Button hombro;
    private Button espalda;
    private Button biceps;
    private Button triceps;
    private Button pierna;
    private Button abdominal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicios_covid);
        pectoral= (Button)findViewById(R.id.btn_pectoral);
        pectoral.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              Intent intent = new Intent(getBaseContext(), Pectoral.class);
                getBaseContext().startActivity(intent);

            }
        });
        hombro= (Button)findViewById(R.id.btn_hombro);
        hombro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), Hombro.class);
                getBaseContext().startActivity(intent);

            }
        });
        pierna= (Button)findViewById(R.id.btn_pierna);
        pierna.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), Pierna.class);
                getBaseContext().startActivity(intent);

            }
        });
        biceps= (Button)findViewById(R.id.btn_biceps);
        biceps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), Biceps.class);
                getBaseContext().startActivity(intent);

            }
        });
        triceps= (Button)findViewById(R.id.btn_triceps);
        triceps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), Triceps.class);
                getBaseContext().startActivity(intent);

            }
        });
        abdominal= (Button)findViewById(R.id.btn_abdominales);
        abdominal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), Abdominales.class);
                getBaseContext().startActivity(intent);

            }
        });
        espalda= (Button)findViewById(R.id.btn_espalda);
        espalda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), Espalda.class);
                getBaseContext().startActivity(intent);

            }
        });

    }
}
