package com.example.dailygym.ui.rutina;

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

public class RutinaFragment extends Fragment {

    private RutinaViewModel rutinaViewModel;
    RecyclerView recyclerPartes;
    ArrayList<PartesModelo> listaPartes;

    View root;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        root = inflater.inflate(R.layout.fragment_rutina, container, false);
        listaPartes = new ArrayList<>();
        recyclerPartes = (RecyclerView) root.findViewById(R.id.rv_rutinas);
        recyclerPartes.setLayoutManager(new LinearLayoutManager(getContext()));
        llenarLista();

        RecyclerViewAdaptador adaptador = new RecyclerViewAdaptador(listaPartes);
        recyclerPartes.setAdapter(adaptador);
        adaptador.setOnCLickListener(new View.OnClickListener(){
            public void onClick(View v){
                String nombre=listaPartes.get(recyclerPartes.getChildAdapterPosition(v)).getParte();
                Toast.makeText(getContext(),nombre,Toast.LENGTH_LONG).show();
                if (nombre=="Creadas por ti"){
                    Intent intent =new Intent(root.getContext(), CreadasPorTi.class);
                    root.getContext().startActivity(intent);}
                if (nombre=="Hipertrofia"){
                    Intent intent =new Intent(root.getContext(), Hipertrofia.class);
                    root.getContext().startActivity(intent);}
                if (nombre=="Fuerza"){
                    Intent intent =new Intent(root.getContext(), Fuerza.class);
                    root.getContext().startActivity(intent);}
                if (nombre=="Full Body"){
                    Intent intent =new Intent(root.getContext(), FullBody.class);
                    root.getContext().startActivity(intent);}
                if (nombre=="Cardio"){
                    Intent intent =new Intent(root.getContext(), Cardio.class);
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
        listaPartes.add(new PartesModelo("Fuerza",R.mipmap.fuerza));
        listaPartes.add(new PartesModelo("Hipertrofia",R.mipmap.hipertrofia));
        listaPartes.add(new PartesModelo("Full Body",R.mipmap.body));
        listaPartes.add(new PartesModelo("Cardio",R.mipmap.cardio));
        listaPartes.add(new PartesModelo("Creadas por ti",R.mipmap.creada));
    }
}
