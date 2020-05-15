package com.example.dailygym.ui.home;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.dailygym.MainActivity;
import com.example.dailygym.PantallaInicio;
import com.example.dailygym.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;


import android.content.Intent;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Map;

public class EditarPerfil extends AppCompatActivity {
    private EditText correo;
    private EditText contraseña;
    private EditText usuario;
    private EditText altura;
    private EditText peso;

    private String email = "";
    private String password = "";
    private String name= "";
    private String height= "";
    private String weight= "";

    Button guardar;
    Button cerrar;
    private FirebaseAuth mAuth;
    private DatabaseReference mDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.editar_perfil);
        correo=(EditText) findViewById(R.id.txtCorreo);
        contraseña=(EditText) findViewById(R.id.txtContraseña);
        usuario=(EditText) findViewById(R.id.txtUsuario);
        altura=(EditText) findViewById(R.id.txtAltura);
        peso=(EditText) findViewById(R.id.txtPeso);
        guardar=(Button) findViewById(R.id.botonGuardar) ;
        cerrar=(Button) findViewById(R.id.CerrarSesion);
        mAuth= FirebaseAuth.getInstance();
        mDatabase= FirebaseDatabase.getInstance().getReference();
        getUserInfo();
        cerrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAuth.signOut();
                startActivity(new Intent(EditarPerfil.this, MainActivity.class));
                finish();
            }
        });
        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                email=correo.getText().toString();
                password=contraseña.getText().toString();
                name=usuario.getText().toString();
                weight=peso.getText().toString();
                height=altura.getText().toString();
                if(!email.isEmpty() && !password.isEmpty() && !name.isEmpty()  && !height.isEmpty() && !weight.isEmpty()){
                    if(password.length()>=6){
                        modificarUsuario();
                    }
                    else {
                        Toast.makeText(EditarPerfil.this, "La contraseña debe tener mas de 6 caracteres", Toast.LENGTH_LONG).show();
                    }
                }
                else {
                    Toast.makeText(EditarPerfil.this, "Obligatorio rellenar los campos", Toast.LENGTH_LONG).show();
                }
            }
        });

    }
    private void getUserInfo(){
        String id=mAuth.getCurrentUser().getUid();
        mDatabase.child("Users").child(id).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()){
                    String correo2=dataSnapshot.child("email").getValue().toString();
                    String usuario2=dataSnapshot.child("name").getValue().toString();
                    String contraseña2=dataSnapshot.child("password").getValue().toString();
                    String altura2=dataSnapshot.child("height").getValue().toString();
                    String peso2=dataSnapshot.child("weight").getValue().toString();

                    correo.setText(correo2);
                    usuario.setText(usuario2);
                    contraseña.setText(contraseña2);
                    altura.setText(altura2);
                    peso.setText(peso2);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }
    private void registrarNuevoUsuario() {
        mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Map<String, Object> map = new HashMap<>();
                    map.put("email", email);
                    map.put("password", password);
                    map.put("name", name);
                    map.put("height", height);
                    map.put("weight", weight);
                    String id = mAuth.getCurrentUser().getUid();
                    mDatabase.child("Users").child(id).setValue(map).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task2) {
                            if (task2.isSuccessful()) {
                                startActivity(new Intent(EditarPerfil.this, PantallaInicio.class));
                                finish();
                            } else {
                                Toast.makeText(EditarPerfil.this, "No se pudieron crear los datos correctamente", Toast.LENGTH_LONG).show();

                            }
                        }
                    });
                } else {
                    Toast.makeText(EditarPerfil.this, "No se pudo registrar", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
    private void modificarUsuario(){
        mAuth.updateCurrentUser(mAuth.getCurrentUser()).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()) {
                    Map<String, Object> map = new HashMap<>();
                    map.put("email", email);
                    map.put("password", password);
                    map.put("name", name);
                    map.put("height", height);
                    map.put("weight", weight);
                    String id = mAuth.getCurrentUser().getUid();
                    mDatabase.child("Users").child(id).setValue(map).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task2) {
                            if (task2.isSuccessful()) {
                                startActivity(new Intent(EditarPerfil.this, PantallaInicio.class));
                                finish();
                            } else {
                                Toast.makeText(EditarPerfil.this, "No se pudieron crear los datos correctamente", Toast.LENGTH_LONG).show();

                            }
                        }
                    });
                } else {
                    Toast.makeText(EditarPerfil.this, "No se pudo registrar", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

}
