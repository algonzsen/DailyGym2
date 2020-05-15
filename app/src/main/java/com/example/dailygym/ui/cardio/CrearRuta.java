package com.example.dailygym.ui.cardio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.dailygym.R;

public class CrearRuta extends AppCompatActivity {
    private Button mapa;
    private EditText txtLongInicio;
    private EditText txtLongFin;
    private EditText txtLatInicio;
    private EditText txtLatFin;

    private static Double latitudInicial;
    private static Double longitudInicial;
    private static Double latitudFinal;
    private static Double longitudFinal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_ruta);
        txtLongInicio=(EditText) findViewById(R.id.txtLongIni);
        txtLatInicio=(EditText) findViewById(R.id.txtLatIni);
        txtLatFin=(EditText) findViewById(R.id.txtLatFin);
        txtLongFin=(EditText) findViewById(R.id.txtLongFin);
        mapa= (Button)findViewById(R.id.btnObtenerCoordenadas);
        mapa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              /* txtLatInicio.setText("42.2214700"); txtLongInicio.setText("-2.0928400"); //Arnedo
                txtLatFin.setText("42.3050600"); txtLongFin.setText("-1.9652100");//Calahorra*/

                CrearRuta.setLatitudInicial(Double.valueOf(txtLatInicio.getText().toString()));
                CrearRuta.setLongitudInicial(Double.valueOf(txtLongInicio.getText().toString()));
                CrearRuta.setLatitudFinal(Double.valueOf(txtLatFin.getText().toString()));
                CrearRuta.setLongitudFinal(Double.valueOf(txtLongFin.getText().toString()));

                CrearRuta.getLatitudInicial();
                CrearRuta.getLatitudFinal();
                Intent intent = new Intent(getBaseContext(), MapsActivity.class);
                getBaseContext().startActivity(intent);

            }
        });
    }

    public static Double getLatitudInicial() {
        return latitudInicial;
    }
    public static void setLatitudInicial(Double latitudInicia) {
       latitudInicial = latitudInicia;
    }
    public static Double getLongitudInicial() {
        return longitudInicial;
    }
    public static void setLongitudInicial(Double longitudInicia) {
        longitudInicial = longitudInicia;
    }
    public static Double getLatitudFinal() {
        return latitudFinal;
    }
    public static void setLatitudFinal(Double latitudFina) {
        latitudFinal = latitudFina;
    }
    public static Double getLongitudFinal() {
        return longitudFinal;
    }
    public static void setLongitudFinal(Double longitudFina) {
        longitudFinal = longitudFina;
    }

}
