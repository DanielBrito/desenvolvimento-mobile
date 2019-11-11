package br.ufc.crateus.pratica3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.location.Location;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText username, password;
    Button btnAdd, btnNext;
    RecyclerView recyclerView;
    LineAdapter mAdapter;
    int count, chave;

    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = (EditText)findViewById(R.id.etUsername);
        password = (EditText)findViewById(R.id.etPassword);

        btnAdd = (Button)findViewById(R.id.btnAdd);
        btnNext = (Button)findViewById(R.id.btnNext);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(layoutManager);

        mAdapter = new LineAdapter(new ArrayList<>(0));

        recyclerView.setAdapter(mAdapter);

        count = chave = 0;

        sharedPreferences = getSharedPreferences("app", Context.MODE_PRIVATE);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String user = username.getText().toString();
                String pass = password.getText().toString();

                User newUser = new User(user, pass);

                String fileName = "saved_users";
                String novoUser = user + "_" + pass;

                savePreference(String.valueOf(chave), novoUser);

                Log.i("Saved: ", readPreference(String.valueOf(chave)));

                ++chave;
                ++count;

                if(count==5){

                    btnNext.setEnabled(true);
                }

                insertItem(newUser);
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(MainActivity.this, FirebaseActivity.class));
            }
        });
    }

    public void insertItem(User user) {

        mAdapter.insertItem(user);
    }

    public void savePreference(String key, String value) {

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key, value);
        editor.apply();
    }

    public String readPreference(String key) {

        return sharedPreferences.getString(key, "");
    }
}
