package br.ufc.crateus.pratica3;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class FirebaseActivity extends AppCompatActivity {

    SharedPreferences sharedPreferences;

    Button btnSend, btnView, btnNextFirebase;
    RecyclerView recyclerView;
    FirebaseAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firebase);

        btnSend = (Button)findViewById(R.id.btnSend);
        btnView = (Button)findViewById(R.id.btnView);
        btnNextFirebase = (Button)findViewById(R.id.btnNextFirebase);

        recyclerView = (RecyclerView) findViewById(R.id.rvUsers);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(layoutManager);

        mAdapter = new FirebaseAdapter(new ArrayList<>(0));

        recyclerView.setAdapter(mAdapter);

        sharedPreferences = getSharedPreferences("app", Context.MODE_PRIVATE);

        // Write a message to the database
        FirebaseDatabase database = FirebaseDatabase.getInstance("https://mobile-c1ce5.firebaseio.com/");
        final DatabaseReference myRef = database.getReference("users");

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                for(int i=0; i<5; i++){

                    String novoUsuario;
                    novoUsuario = readPreference(String.valueOf(i));

                    String[] usuarioEnviar = new String[2];

                    usuarioEnviar = novoUsuario.split("_");

                    myRef.push().setValue(new User(usuarioEnviar[0], usuarioEnviar[1]));
                }
            }
        });

        btnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                myRef.addListenerForSingleValueEvent(new ValueEventListener() {

                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                        Iterable<DataSnapshot> children = dataSnapshot.getChildren();

                        for(DataSnapshot data : children){

                            Log.i("RETURN: ", data.getKey() + " " + data.getValue());

                            insertItem(new Firebase("" + data.getValue()));
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });

                btnNextFirebase.setEnabled(true);
            }
        });


        btnNextFirebase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(FirebaseActivity.this, MapsActivity.class));
            }
        });
    }

    public void insertItem(Firebase user) {

        mAdapter.insertItem(user);
    }

    public String readPreference(String key) {

        return sharedPreferences.getString(key, "");
    }
}
