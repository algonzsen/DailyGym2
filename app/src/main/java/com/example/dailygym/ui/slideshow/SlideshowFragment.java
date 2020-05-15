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

import com.example.dailygym.PartesModelo;
import com.example.dailygym.R;
import com.example.dailygym.RecyclerViewAdaptador;


import java.util.ArrayList;

public class SlideshowFragment extends Fragment {

    private SlideshowViewModel slideshowViewModel;
    RecyclerView recyclerPartes;
    ArrayList<PartesModelo> listaPartes;

    View root;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        root = inflater.inflate(R.layout.fragment_slideshow, container, false);
        listaPartes = new ArrayList<>();
        recyclerPartes = (RecyclerView) root.findViewById(R.id.rv_partesCuerpo);
        recyclerPartes.setLayoutManager(new LinearLayoutManager(getContext()));
        llenarLista();

        RecyclerViewAdaptador adaptador = new RecyclerViewAdaptador(listaPartes);
        recyclerPartes.setAdapter(adaptador);
        adaptador.setOnCLickListener(new View.OnClickListener(){
            public void onClick(View v){
                String nombre=listaPartes.get(recyclerPartes.getChildAdapterPosition(v)).getParte();
                Toast.makeText(getContext(),nombre,Toast.LENGTH_LONG).show();
                if (nombre=="Biceps"){
                Intent intent =new Intent(root.getContext(), ActividadBiceps.class);
                root.getContext().startActivity(intent);}
                if (nombre=="Pierna"){
                    Intent intent =new Intent(root.getContext(), ActividadPierna.class);
                    root.getContext().startActivity(intent);}
                if (nombre=="Espalda"){
                    Intent intent =new Intent(root.getContext(), ActividadEspalda.class);
                    root.getContext().startActivity(intent);}
                if (nombre=="Pecho"){
                    Intent intent =new Intent(root.getContext(), ActividadPecho.class);
                    root.getContext().startActivity(intent);}
                if (nombre=="Triceps"){
                    Intent intent =new Intent(root.getContext(), ActividadTriceps.class);
                    root.getContext().startActivity(intent);}
                if (nombre=="Hombro"){
                    Intent intent =new Intent(root.getContext(), ActividadHombro.class);
                    root.getContext().startActivity(intent);}
                //Fragment nuevoFragment= new FragmentoEspalda();
                // FragmentTransaction transaction = ((AppCompatActivity) getContext()).getSupportFragmentManager().beginTransaction();
               // transaction.replace(R.id.rv_ejs, new RutinaFragment());
               // transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
            }
        });
        return root;
    }

    private void llenarLista(){
        listaPartes.add(new PartesModelo("Biceps",R.mipmap.biceps));
        listaPartes.add(new PartesModelo("Triceps",R.mipmap.triceps));
        listaPartes.add(new PartesModelo("Pierna",R.mipmap.pierna));
        listaPartes.add(new PartesModelo("Pecho",R.mipmap.pecho));
        listaPartes.add(new PartesModelo("Espalda",R.mipmap.espalda));
        listaPartes.add(new PartesModelo("Hombro",R.mipmap.hombro));
    }
}
