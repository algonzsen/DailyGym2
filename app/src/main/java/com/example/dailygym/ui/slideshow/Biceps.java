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
import com.example.dailygym.ListaBiceps;
import com.example.dailygym.R;

import java.util.ArrayList;

public class Biceps extends Fragment {

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

        ListaBiceps adaptador = new ListaBiceps(listaPartes);
        recyclerPartes.setAdapter(adaptador);
        adaptador.setOnCLickListener(new View.OnClickListener(){
            public void onClick(View v){
                String nombre=listaPartes.get(recyclerPartes.getChildAdapterPosition(v)).getParte();
                Toast.makeText(getContext(),nombre,Toast.LENGTH_LONG).show();
                if (nombre=="Martillo"){
                    Intent intent =new Intent(root.getContext(), com.example.dailygym.ejercicios.Main10Activity.class);
                    root.getContext().startActivity(intent);}
                if (nombre=="Barra Z"){
                    Intent intent =new Intent(root.getContext(), com.example.dailygym.ejercicios.Z.class);
                    root.getContext().startActivity(intent);}
                if (nombre=="Biceps polea"){
                    Intent intent =new Intent(root.getContext(), com.example.dailygym.ejercicios.bicepsPolea.class);
                    root.getContext().startActivity(intent);}
                if (nombre=="Mancuernas concentrado"){
                    Intent intent =new Intent(root.getContext(), com.example.dailygym.ejercicios.Mancuernas.class);
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
        listaPartes.add(new Ejercicios("Martillo",R.drawable.common_google_signin_btn_icon_dark));
        listaPartes.add(new Ejercicios("Barra Z",R.drawable.common_google_signin_btn_icon_dark));
        listaPartes.add(new Ejercicios("Biceps polea",R.drawable.common_google_signin_btn_icon_dark));
        listaPartes.add(new Ejercicios("Mancuernas concentrado",R.drawable.common_google_signin_btn_icon_dark));

    }
}

