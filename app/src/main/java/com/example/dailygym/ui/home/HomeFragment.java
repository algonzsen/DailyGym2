package com.example.dailygym.ui.home;

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

import com.example.dailygym.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class HomeFragment extends Fragment {
    TextView email;
    TextView name;
    TextView height;
    TextView weight;
    Button editarPerfil;
    private FirebaseAuth mAuth;
    private DatabaseReference mDatabase;
    private HomeViewModel perfilViewModel;

    OnHeadlineSelectedListener callback;
    public void setOnHeadlineSelectedListener(OnHeadlineSelectedListener callback) {
        this.callback = callback;
    }

    // This interface can be implemented by the Activity, parent Fragment,
    // or a separate test implementation.
    public interface OnHeadlineSelectedListener {
        public void onArticleSelected(int position);
    }
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        perfilViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        final View root = inflater.inflate(R.layout.fragment_home, container, false);

        email=(TextView) root.findViewById(R.id.txtViewCorreo);
        name=(TextView) root.findViewById(R.id.txtViewUsuario);
        height=(TextView) root.findViewById(R.id.txtViewAltura);
        weight=(TextView) root.findViewById(R.id.txtViewPeso);
        editarPerfil=(Button) root.findViewById(R.id.boton_editarPerfil2);
        mAuth=FirebaseAuth.getInstance();
        mDatabase= FirebaseDatabase.getInstance().getReference();

        getUserInfo();
        editarPerfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent =new Intent(root.getContext(), EditarPerfil.class);
                root.getContext().startActivity(intent);
            }
        });
        return root;
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
