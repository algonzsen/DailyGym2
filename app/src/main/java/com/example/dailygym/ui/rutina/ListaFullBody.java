package com.example.dailygym.ui.rutina;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dailygym.Ejercicios;
import com.example.dailygym.R;

import java.util.List;

public class ListaFullBody extends RecyclerView.Adapter<ListaFullBody.ViewHolder> implements View.OnClickListener {

    public void setOnCLickListener(View.OnClickListener listener ){
        this.listener=listener;
    }
    @Override
    public void onClick(View v) {
        if(listener!=null){
            listener.onClick(v);
        }
    }
    public static class ViewHolder extends RecyclerView.ViewHolder{
        private TextView nombre;
        ImageView fotoParte;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nombre = (TextView)itemView.findViewById(R.id.text_ejEspalda);
            fotoParte = (ImageView)itemView.findViewById(R.id.iv_ejEspalda);
        }
    }

    public List<Rutinas> partesLista;
    private View.OnClickListener listener;
    public ListaFullBody(List<Rutinas> partesLista) {
        this.partesLista = partesLista;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_espalda,parent,false);
        view.setOnClickListener(this);
        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.nombre.setText(partesLista.get(position).getParte());
        holder.fotoParte.setImageResource(partesLista.get(position).getFotoRutina());
    }

    @Override
    public int getItemCount() {
        return partesLista.size();
    }
}
