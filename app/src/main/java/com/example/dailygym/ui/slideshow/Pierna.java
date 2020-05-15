package com.example.dailygym.ui.slideshow;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dailygym.Ejercicios;
import com.example.dailygym.ListaPierna;
import com.example.dailygym.R;

import java.util.ArrayList;

public class Pierna extends Fragment {

    private SlideshowViewModel slideshowViewModel;
    RecyclerView recyclerPartes;
    ArrayList<Ejercicios> listaPartes;

    View root;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        root = inflater.inflate(R.layout.fragment_slideshow, container, false);
        listaPartes = new ArrayList<>();
        recyclerPartes = (RecyclerView) root.findViewById(R.id.rv_partesCuerpo);
        recyclerPartes.setLayoutManager(new LinearLayoutManager(getContext()));
        llenarLista();

        ListaPierna adaptador = new ListaPierna(listaPartes);
        recyclerPartes.setAdapter(adaptador);
        adaptador.setOnCLickListener(new View.OnClickListener(){
            public void onClick(View v){
                String nombre=listaPartes.get(recyclerPartes.getChildAdapterPosition(v)).getParte();
                Toast.makeText(getContext(),nombre,Toast.LENGTH_LONG).show();

                if (nombre=="Sentadillas"){
                    Intent intent =new Intent(root.getContext(), com.example.dailygym.ejercicios.Sentadillas.class);
                    root.getContext().startActivity(intent);}
                if (nombre=="Peso muerto"){
                    Intent intent =new Intent(root.getContext(), com.example.dailygym.ejercicios.pesoMuerto.class);
                    root.getContext().startActivity(intent);}
                if (nombre=="Cuadriceps en maquina"){
                    Intent intent =new Intent(root.getContext(), com.example.dailygym.ejercicios.cuadricepsMaquina.class);
                    root.getContext().startActivity(intent);}
                if (nombre=="Isquio en maquina"){
                    Intent intent =new Intent(root.getContext(), com.example.dailygym.ejercicios.isquioMaquina.class);
                    root.getContext().startActivity(intent);}

            }
        });
        return root;
    }
    private void llenarLista(){
        listaPartes.add(new Ejercicios("Sentadillas",R.drawable.common_google_signin_btn_icon_dark));
        listaPartes.add(new Ejercicios("Peso muerto",R.drawable.common_google_signin_btn_icon_dark));
        listaPartes.add(new Ejercicios("Cuadriceps en maquina",R.drawable.common_google_signin_btn_icon_dark));
        listaPartes.add(new Ejercicios("Isquio en maquina",R.drawable.common_google_signin_btn_icon_dark));

    }
}
