package com.example.dailygym;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class Registrar extends AppCompatActivity {
    private EditText correo;
    private EditText contraseña;
    private EditText usuario;
    private EditText altura;
    private EditText peso;

    private Button registrarse;

    //Variables
    private String email = "";
    private String password = "";
    private String name= "";
    private String height= "";
    private String weight= "";

    FirebaseAuth mAuth;

    DatabaseReference mDatabase;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registrar_usuario);

        mAuth = FirebaseAuth.getInstance();
        mDatabase= FirebaseDatabase.getInstance().getReference();
        correo=(EditText) findViewById(R.id.txtCorreo);
        contraseña=(EditText) findViewById(R.id.txtContraseña);
        usuario=(EditText) findViewById(R.id.txtUsuario);
        altura=(EditText) findViewById(R.id.txtAltura);
        peso=(EditText) findViewById(R.id.txtPeso);
        registrarse=(Button) findViewById(R.id.boton_registrarse);

        registrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                email=correo.getText().toString();
                password=contraseña.getText().toString();
                name=usuario.getText().toString();
                weight=altura.getText().toString();
                height=peso.getText().toString();
                if(!email.isEmpty() && !password.isEmpty()){
                    if(password.length()>=6){
                        registrarUsuario();
                    }
                    else {
                        Toast.makeText(Registrar.this, "La contraseña debe tener mas de 6 caracteres", Toast.LENGTH_LONG).show();
                    }
                }
                else {
                    Toast.makeText(Registrar.this, "Obligatorio rellenar los campos", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private void registrarUsuario(){
        mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Map<String, Object> map=new HashMap<>();
                    map.put("email",email);
                    map.put("password",password);
                    map.put("name",name);
                    map.put("height",height);
                    map.put("weight",weight);
                    String id=mAuth.getCurrentUser().getUid();
                    mDatabase.child("Users").child(id).setValue(map).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task2) {
                            if(task2.isSuccessful()){
                                startActivity(new Intent(Registrar.this, PantallaInicio.class));
                                finish();
                            }
                            else{
                                Toast.makeText(Registrar.this, "No se pudieron crear los datos correctamente", Toast.LENGTH_LONG).show();

                            }
                        }
                    });
                }
                else{
                    Toast.makeText(Registrar.this, "No se pudo registrar", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
