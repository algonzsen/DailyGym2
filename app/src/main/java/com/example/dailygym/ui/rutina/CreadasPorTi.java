package com.example.dailygym.ui.rutina;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.dailygym.MainActivity;
import com.example.dailygym.PantallaInicio;
import com.example.dailygym.R;

public class CreadasPorTi extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rut_probar);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.crear_rutina,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id=item.getItemId();
        if(id==R.id.itemCrear){
            startActivity(new Intent(CreadasPorTi.this, RutinaCreadaPorTi.class));

        }

        return super.onOptionsItemSelected(item);

    }
}
