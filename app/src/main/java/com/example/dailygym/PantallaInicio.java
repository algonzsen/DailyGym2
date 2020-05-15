package com.example.dailygym;

import android.content.Intent;
import android.os.Bundle;
import android.text.format.Time;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.Date;

public class PantallaInicio extends AppCompatActivity {
    TextView fecha;
    TextView hora;
    TextView email;
    TextView name;
    TextView height;
    TextView weight;

    private Button botonCerrarSesion;
    private Button botonEmpezar;
    private FirebaseAuth mAuth;
    private DatabaseReference mDatabase;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pantalla_inicio);
        fecha=(TextView) findViewById(R.id.txtViewFecha);
        hora=(TextView) findViewById(R.id.txtViewHora);
        email=(TextView) findViewById(R.id.txtViewCorreo);
        name=(TextView) findViewById(R.id.txtViewUsuario);
        height=(TextView) findViewById(R.id.txtViewAltura);
        weight=(TextView) findViewById(R.id.txtViewPeso);
        botonCerrarSesion=(Button) findViewById(R.id.boton_CerrarSesion);
        botonEmpezar=(Button) findViewById(R.id.boton_Empezar);
        mAuth=FirebaseAuth.getInstance();
        mDatabase= FirebaseDatabase.getInstance().getReference();
        botonCerrarSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAuth.signOut();
                startActivity(new Intent(PantallaInicio.this, MainActivity.class));
                finish();
            }
        });

        botonEmpezar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(PantallaInicio.this, MenuDesp.class));

            }
        });
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(" HH:mm:ss");
        String currentDateandTime = simpleDateFormat.format(new Date());
        hora.setText(currentDateandTime);
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("dd-MM-yyyy ");
        String currentDateandTime2 = simpleDateFormat2.format(new Date());
        fecha.setText( currentDateandTime2);

        getUserInfo();
    }
    private void getUserInfo(){
        String id=mAuth.getCurrentUser().getUid();
        mDatabase.child("Users").child(id).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()){
                    String correo=dataSnapshot.child("email").getValue().toString();
                    String usuario=dataSnapshot.child("name").getValue().toString();
                    String altura=dataSnapshot.child("height").getValue().toString();
                    String peso=dataSnapshot.child("weight").getValue().toString();

                    email.setText(correo);
                    name.setText(usuario);
                    height.setText(altura);
                    weight.setText(peso);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
