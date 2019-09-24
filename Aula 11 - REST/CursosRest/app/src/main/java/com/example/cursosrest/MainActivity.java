package com.example.cursosrest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    CursoService service;

    EditText etNome;
    EditText etDuracao;
    EditText etId;

    Button btnPost;
    Button btnGet;
    Button btnPut;
    Button btnDelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNome = (EditText) findViewById(R.id.etNome);
        etDuracao = (EditText) findViewById(R.id.etDuracao);
        etId = (EditText) findViewById(R.id.etId);

        btnPost = (Button) findViewById(R.id.btnPost);
        btnGet = (Button) findViewById(R.id.btnGet);
        btnPut = (Button) findViewById(R.id.btnPut);
        btnDelete = (Button) findViewById(R.id.btnDelete);

        service = RetrofitClientInstance.getRetrofitInstance().create(CursoService.class);

        btnPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int id = Integer.parseInt(etId.getText().toString());
                String nome = etNome.getText().toString();
                String duracao = etDuracao.getText().toString();

                Curso curso = new Curso(id,nome,duracao);

                Call<Curso> postCurso = service.postCurso(curso);

                postCurso.enqueue(new Callback<Curso>() {

                    @Override
                    public void onResponse(Call<Curso> call, Response<Curso> response) {

                        Toast.makeText(MainActivity.this, response.body().toString(), Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call<Curso> call, Throwable t) {

                    }
                });

            }
        });

        btnGet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int id = Integer.parseInt(etId.getText().toString());

                Call<Curso> getCurso = service.getCurso(id);

                getCurso.enqueue(new Callback<Curso>() {

                    @Override
                    public void onResponse(Call<Curso> call, Response<Curso> response) {

                        Toast.makeText(MainActivity.this, response.body().toString(), Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call<Curso> call, Throwable t) {

                    }
                });
            }
        });

        btnPut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int id = Integer.parseInt(etId.getText().toString());
                String nome = etNome.getText().toString();
                String duracao = etDuracao.getText().toString();

                Curso curso = new Curso(id,nome,duracao);

                Call<Curso> putCurso = service.putCurso(curso, id);

                putCurso.enqueue(new Callback<Curso>() {

                    @Override
                    public void onResponse(Call<Curso> call, Response<Curso> response) {

                        Toast.makeText(MainActivity.this, response.body().toString(), Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call<Curso> call, Throwable t) {

                    }
                });
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int id = Integer.parseInt(etId.getText().toString());

                Call<Curso> deleteCurso = service.deleteCurso(id);

                deleteCurso.enqueue(new Callback<Curso>() {

                    @Override
                    public void onResponse(Call<Curso> call, Response<Curso> response) {

                        if(response.isSuccessful()) {

                            Toast.makeText(MainActivity.this, "OK", Toast.LENGTH_SHORT).show();

                        }else {

                            Toast.makeText(MainActivity.this, "FAIL", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<Curso> call, Throwable t) {

                    }
                });
            }
        });

    }
}
