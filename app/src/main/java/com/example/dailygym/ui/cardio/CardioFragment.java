package com.example.dailygym.ui.cardio;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.dailygym.R;
import com.example.dailygym.ui.slideshow.ActividadPierna;


public class CardioFragment extends Fragment {
    private CardioViewModel cardioViewModel;
    private Button iniciarCardio;
    private Button pararCardio;
    private Button finalizarCardio;
    private Button verMapa;
    private ImageButton actual;
    private TextView te;
    private TextView kcal;
    private Chronometer chronometro;
    Boolean correr=false;
    long detenerse;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        cardioViewModel =
                ViewModelProviders.of(this).get(CardioViewModel.class);
        final View root = inflater.inflate(R.layout.activity_actividad_cardio, container, false);
        iniciarCardio= (Button) root.findViewById(R.id.btn_iniciarcardio);
        te=(TextView)root.findViewById(R.id.textView4);
        kcal=(TextView)root.findViewById(R.id.textView10);
        chronometro=root.findViewById(R.id.crono);
        actual= root.findViewById(R.id.boton_ubActual);

        iniciarCardio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startChronometro();
                te.setText("CARDIO INICIADO");
               /* Intent intent = new Intent(root.getContext(), ActividadCardio.class);
                root.getContext().startActivity(intent);*/
            }
        });
        pararCardio= root.findViewById(R.id.btn_pararcardio);
        pararCardio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopChronometro();
                te.setText("EL CARDIO ESTA EN PAUSA");
            }
        });

        finalizarCardio= root.findViewById(R.id.btn_finalizarcardio);
        finalizarCardio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               /* Intent intent = new Intent(root.getContext(), MapsActivity.class);
                root.getContext().startActivity(intent);*/
                te.setText("EL CARDIO HA FINALIZADO");
                kcal.setText("KCAL GASTADAS: "+ chronometro.getText().toString() + " segundos * " + 0.0033333*60*1.036 + "kcal");
                stopChronometro();
                resetChronometro();
            }
        });

        verMapa= root.findViewById(R.id.btn_vermapa);
        verMapa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(root.getContext(), CrearRuta.class);
                root.getContext().startActivity(intent);
            }
        });
        actual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(root.getContext(), Ubicacion.class);
                root.getContext().startActivity(intent);
            }
        });
        return root;
    }

    private void resetChronometro() {
        chronometro.setBase(SystemClock.elapsedRealtime());
        detenerse=0;
    }

    private void stopChronometro() {
        if (correr){
            chronometro.stop();
            detenerse = SystemClock.elapsedRealtime() - chronometro.getBase();
            correr=false;
        }
    }

    private void startChronometro() {
        if(!correr){
            chronometro.setBase(SystemClock.elapsedRealtime() - detenerse);
            chronometro.start();
            correr=true;
        }
    }
}
