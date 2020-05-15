package com.example.dailygym.ui.COVID19;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.dailygym.R;
import com.example.dailygym.ui.cardio.CardioViewModel;
import com.example.dailygym.ui.cardio.CrearRuta;


public class COVID19Fragment extends Fragment {
    private Button ejercicios;
    private COVID19ViewModel covvm;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        covvm =
                ViewModelProviders.of(this).get(COVID19ViewModel.class);

        final View root = inflater.inflate(R.layout.fragment_covid, container, false);
        ejercicios = (Button) root.findViewById(R.id.button);

        ejercicios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(root.getContext(), EjerciciosCovid.class);
                root.getContext().startActivity(intent);
            }
        });
        return root;
    }
}
