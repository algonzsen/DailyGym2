package com.example.dailygym.ui.rutina;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.dailygym.Ejercicios;
import com.example.dailygym.ListaBiceps;
import com.example.dailygym.R;

import java.util.ArrayList;

public class RutinaCreadaPorTi extends AppCompatActivity {

    private Spinner dia1;
    private Spinner dia2;
    private Spinner dia3;
    private Spinner dia4;
    private Spinner dia5;

    private EditText ejercicio;

    RecyclerView recyclerPartes;
    ArrayList<Rutinas> listaPartes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rut_creada);
        dia1=(Spinner) findViewById(R.id.spinner);
        dia2=(Spinner) findViewById(R.id.spinner2);
        dia3=(Spinner) findViewById(R.id.spinner3);
        dia4=(Spinner) findViewById(R.id.spinner4);
        dia5=(Spinner) findViewById(R.id.spinner5);

        //ConstraintLayout constraintLayout =(ConstraintLayout) findViewById(R.id.constraint);
        /*ejercicio =new EditText(this);
        ejercicio.setLayoutParams(new ActionBar.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT));
        ejercicio.setHint("Ingrese los ejercicios");
        constraintLayout.addView(ejercicio);
        ejercicio.setLeft(10);
        ejercicio.setTop(200);*/
        ArrayList<String> combo=new ArrayList<String>();
        for(int i=0;i<15;i++){
            combo.add("total: "+i);
        }

        ArrayAdapter<CharSequence> adapter=new ArrayAdapter(this,android.R.layout.simple_spinner_item,combo);
        dia1.setAdapter(adapter);
        dia2.setAdapter(adapter);
        dia3.setAdapter(adapter);
        dia4.setAdapter(adapter);
        dia5.setAdapter(adapter);

        dia1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(parent.getContext(),"Seleccionado: "+parent.getItemAtPosition(position).toString(),Toast.LENGTH_LONG).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        dia2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(parent.getContext(),"Seleccionado: "+parent.getItemAtPosition(position).toString(),Toast.LENGTH_LONG).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        dia3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(parent.getContext(),"Seleccionado: "+parent.getItemAtPosition(position).toString(),Toast.LENGTH_LONG).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        dia4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                Toast.makeText(parent.getContext(),"Seleccionado: "+parent.getItemAtPosition(position).toString(),Toast.LENGTH_LONG).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        dia5.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(parent.getContext(),"Seleccionado: "+parent.getItemAtPosition(position).toString(),Toast.LENGTH_LONG).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.overflow,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id=item.getItemId();
        if(id==R.id.itemGuardar){
            listaPartes = new ArrayList<>();
            recyclerPartes = (RecyclerView) findViewById(R.id.rv_rutinas);
            //recyclerPartes.setLayoutManager(new LinearLayoutManager(getContext()));
            llenarLista();
            startActivity(new Intent(RutinaCreadaPorTi.this,CreadasPorTi.class));
            //ListaBiceps adaptador = new ListaBiceps(listaPartes);
            //recyclerPartes.setAdapter(adaptador);

        }
        else if(id==R.id.itemEliminar){

        }
        return super.onOptionsItemSelected(item);

    }
    private void llenarLista(){

        listaPartes.add(new Rutinas("Rutina 1", R.drawable.common_google_signin_btn_icon_dark));

    }

    /*private String PREFS_KEY = "mispreferencias";

    public void saveValue(Context context, String text) {
        SharedPreferences settings = context.getSharedPreferences(PREFS_KEY, MODE_PRIVATE);
        SharedPreferences.Editor editor;
        editor = settings.edit();
        editor.putString("valorEditText", text);
        editor.commit();
    }



    public String getValue(Context context) {
        SharedPreferences preferences = context.getSharedPreferences(PREFS_KEY, MODE_PRIVATE);
        return preferences.getString("valorEditText", "");
    }*/
}
