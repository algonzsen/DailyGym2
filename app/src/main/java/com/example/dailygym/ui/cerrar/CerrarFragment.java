package com.example.dailygym.ui.cerrar;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.dailygym.MainActivity;
import com.example.dailygym.R;
import com.example.dailygym.ui.cardio.CardioViewModel;
import com.example.dailygym.ui.home.EditarPerfil;
import com.google.firebase.auth.FirebaseAuth;


public class CerrarFragment extends Fragment {
    private CerrarViewModel cerrarViewModel;
    private FirebaseAuth mAuth;
    private Button cerrar;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        cerrarViewModel =
                ViewModelProviders.of(this).get(CerrarViewModel.class);
        final View root = inflater.inflate(R.layout.fragment_cerrar, container, false);
        cerrar = root.findViewById(R.id.boton_cerrar);
        mAuth= FirebaseAuth.getInstance();

        cerrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAuth.signOut();
                Intent intent =new Intent(root.getContext(), MainActivity.class);
                root.getContext().startActivity(intent);
            }
        });
        return root;
    }
}
