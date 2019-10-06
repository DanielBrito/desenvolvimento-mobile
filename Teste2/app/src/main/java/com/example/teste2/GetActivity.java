package com.example.teste2;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GetActivity extends AppCompatActivity {

    UserService service;

    Button btnGet;
    Button btnNextRest;

    RecyclerView recyclerViewGet;
    GetAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get);

        service = RetrofitClientInstance.getRetrofitInstance().create(UserService.class);

        btnGet = (Button)findViewById(R.id.btnGet);

        btnNextRest = (Button)findViewById(R.id.btnNextRest);
        btnNextRest.setEnabled(false);

        recyclerViewGet = (RecyclerView)findViewById(R.id.recyclerViewGet);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        recyclerViewGet.setLayoutManager(layoutManager);

        mAdapter = new GetAdapter(new ArrayList<>(0));

        recyclerViewGet.setAdapter(mAdapter);

        btnGet.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Call<List<User>> callGetAll = service.getUsers();

                callGetAll.enqueue(new Callback<List<User>>() {

                    @Override
                    public void onResponse(Call<List<User>> call, Response<List<User>> response) {

                        for (User user: response.body()){

                            Log.i("GET ALL", user.toString());

                            mAdapter.insertItem(user);
                        };

                        btnNextRest.setEnabled(true);
                    }

                    @Override
                    public void onFailure(Call<List<User>> call, Throwable t) {

                    }
                });
            }
        });

        btnNextRest.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Intent i = new Intent(GetActivity.this, PostActivity.class);
                startActivity(i);
            }
        });
    }

    public void insertItem(User user) {

        mAdapter.insertItem(user);

        // btnNextRest.setEnabled(true);
    }
}
