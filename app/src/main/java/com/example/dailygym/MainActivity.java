package com.example.dailygym;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    private EditText correo;
    private EditText contraseña;
    private Button entrar;
    private TextView olvidoContraseña;
    private Button registrar;

    private String email="";
    private String password="";

    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAuth=FirebaseAuth.getInstance();

        correo=(EditText) findViewById(R.id.txtCorreo);
        contraseña=(EditText) findViewById(R.id.txtPassword);
        entrar=(Button) findViewById(R.id.boton_entrar);
       // olvidoContraseña=(TextView) findViewById(R.id.txtViewOlvido);
        registrar=(Button) findViewById(R.id.boton_registrar);

        entrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                email=correo.getText().toString();
                password=contraseña.getText().toString();
                if(!email.isEmpty() && !password.isEmpty()){
                    loginUser();
                }
                else{
                    Toast.makeText(MainActivity.this,"Completa los campos",Toast.LENGTH_SHORT).show();
                }

            }
        });
        /*olvidoContraseña.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });*/
        registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Registrar.class);
                startActivity(intent);

            }
        });
    }

    private void loginUser(){
        mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    startActivity(new Intent(MainActivity.this, PantallaInicio.class));
                    finish();
                }
                else{
                    Toast.makeText(MainActivity.this,"No se pudo iniciar sesion, comprueba los datos",Toast.LENGTH_SHORT).show();

                }
            }
        });
    }
//este metodo lo que hace es que si estabas registrado de antes ya te lleve directamente a la pantalla de inicio, tipo instagram, te guarda la contraseña
    @Override
    protected void onStart() {
        super.onStart();
        if(mAuth.getCurrentUser()!=null){
            startActivity(new Intent(MainActivity.this,PantallaInicio.class));
            finish();
        }
    }
}
