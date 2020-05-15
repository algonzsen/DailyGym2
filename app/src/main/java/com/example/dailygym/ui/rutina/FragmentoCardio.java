package com.example.dailygym.ui.rutina;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dailygym.R;
import com.example.dailygym.ui.slideshow.SlideshowViewModel;

import java.util.ArrayList;

public class FragmentoCardio extends Fragment {

    private SlideshowViewModel slideshowViewModel;
    RecyclerView recyclerPartes;
    ArrayList<Rutinas> listaPartes;

    View root;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        root = inflater.inflate(R.layout.fragment_slideshow, container, false);
        listaPartes = new ArrayList<>();
        recyclerPartes = (RecyclerView) root.findViewById(R.id.rv_partesCuerpo);
        recyclerPartes.setLayoutManager(new LinearLayoutManager(getContext()));
        llenarLista();

        ListaCardio adaptador = new ListaCardio(listaPartes);
        recyclerPartes.setAdapter(adaptador);
        adaptador.setOnCLickListener(new View.OnClickListener(){
            public void onClick(View v){
                String nombre=listaPartes.get(recyclerPartes.getChildAdapterPosition(v)).getParte();
                Toast.makeText(getContext(),nombre,Toast.LENGTH_LONG).show();
                if (nombre=="Rutina Cardio"){
                    Intent intent =new Intent(root.getContext(), RutinaCardio.class);
                    root.getContext().startActivity(intent);}
            }
        });
        return root;
    }

    private void llenarLista(){
        listaPartes.add(new Rutinas("Rutina Cardio",R.drawable.common_google_signin_btn_icon_dark));

    }
}
