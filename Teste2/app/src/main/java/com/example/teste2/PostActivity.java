package com.example.teste2;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostActivity extends AppCompatActivity {

    EditText etName, etUsername, etProfissao, etData, etEmail;
    Button btnPost;
    UserService service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);

        service = RetrofitClientInstance.getRetrofitInstance().create(UserService.class);

        etName = (EditText)findViewById(R.id.etName);
        etUsername = (EditText)findViewById(R.id.etUsername);
        etProfissao = (EditText)findViewById(R.id.etProfissao);
        etData = (EditText)findViewById(R.id.etData);
        etEmail = (EditText)findViewById(R.id.etEmail);

        btnPost = (Button)findViewById(R.id.btnPost);

        btnPost.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

            final String name = etName.getText().toString();
            final String username = etUsername.getText().toString();
            final String profissao = etProfissao.getText().toString();
            final String data = etData.getText().toString();
            final String email = etEmail.getText().toString();

            User user = new User(0, name, username, email, profissao, data);

            Call<User> callPost = service.postUser(user);

            callPost.enqueue(new Callback<User>() {

                @Override
                public void onResponse(Call<User> call, Response<User> response) {

                    Log.i("Post", response.body().toString());
                }

                @Override
                public void onFailure(Call<User> call, Throwable t) {

                }
            });
            }
        });
    }
}
