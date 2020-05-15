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
import com.example.dailygym.ListaTriceps;
import com.example.dailygym.R;

import java.util.ArrayList;

public class Triceps extends Fragment {

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

        ListaTriceps adaptador = new ListaTriceps(listaPartes);
        recyclerPartes.setAdapter(adaptador);
        adaptador.setOnCLickListener(new View.OnClickListener(){
            public void onClick(View v){
                String nombre=listaPartes.get(recyclerPartes.getChildAdapterPosition(v)).getParte();
                Toast.makeText(getContext(),nombre,Toast.LENGTH_LONG).show();

                if (nombre=="Fondos"){
                    Intent intent =new Intent(root.getContext(), com.example.dailygym.ejercicios.Fondos.class);
                    root.getContext().startActivity(intent);}
                if (nombre=="Press frances"){
                    Intent intent =new Intent(root.getContext(), com.example.dailygym.ejercicios.PressFrances.class);
                    root.getContext().startActivity(intent);}
                if (nombre=="Cuerda"){
                    Intent intent =new Intent(root.getContext(), com.example.dailygym.ejercicios.TricepsCuerda.class);
                    root.getContext().startActivity(intent);}
                if (nombre=="Polea una mano"){
                    Intent intent =new Intent(root.getContext(), com.example.dailygym.ejercicios.TricepsPolea.class);
                    root.getContext().startActivity(intent);}


            }
        });
        return root;
    }

    private void llenarLista(){
        listaPartes.add(new Ejercicios("Fondos",R.drawable.common_google_signin_btn_icon_dark));
        listaPartes.add(new Ejercicios("Press frances",R.drawable.common_google_signin_btn_icon_dark));
        listaPartes.add(new Ejercicios("Cuerda",R.drawable.common_google_signin_btn_icon_dark));
        listaPartes.add(new Ejercicios("Polea una mano",R.drawable.common_google_signin_btn_icon_dark));

    }
}