package com.example.dailygym.ui.slideshow;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

//import com.example.dailygym.EjerciciosEspalda;
import com.example.dailygym.Ejercicios;
import com.example.dailygym.ListaEspalda;
import com.example.dailygym.R;

import java.util.ArrayList;

public class FirstFragment extends Fragment {
    private SlideshowViewModel slideshowViewModel;
    RecyclerView recyclerPartes;
    ArrayList<Ejercicios> listaPartes;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_fragmento_espalda, container, false);
        listaPartes = new ArrayList<>();
        recyclerPartes = (RecyclerView) root.findViewById(R.id.rv_ejs);
        recyclerPartes.setLayoutManager(new LinearLayoutManager(getContext()));


        llenarLista();

        ListaEspalda adaptador = new ListaEspalda(listaPartes);
        recyclerPartes.setAdapter(adaptador);
        return root;
    }

    private void llenarLista(){
        listaPartes.add(new Ejercicios("Dominadas",R.drawable.common_google_signin_btn_icon_dark));
        listaPartes.add(new Ejercicios("Remo bajo",R.drawable.common_google_signin_btn_icon_dark));
        listaPartes.add(new Ejercicios("Jalon",R.drawable.common_google_signin_btn_icon_dark));
        listaPartes.add(new Ejercicios("Tiradas",R.drawable.common_google_signin_btn_icon_dark));

    }
}
