package br.ufc.crateus.exerciciodao;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import br.ufc.crateus.exerciciodao.dao.CarroDAO;
import br.ufc.crateus.exerciciodao.database.DatabaseCarro;
import br.ufc.crateus.exerciciodao.model.Carro;
import br.ufc.crateus.exerciciodao.ui.LineAdapter;
import br.ufc.crateus.exerciciodao.ui.LineHolder;

public class MainActivity extends AppCompatActivity {

    CarroDAO carros;

    EditText etId, etMarca, etModelo, etAno;

    Button btnInsert, btnDelete, btnUpdate, btnGet, btnGetAll;

    RecyclerView recyclerView;
    LineAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        carros = DatabaseCarro.getInstance(getApplicationContext()).carroDAO();

        etId = (EditText)findViewById(R.id.etId);
        etMarca = (EditText)findViewById(R.id.etMarca);
        etModelo = (EditText)findViewById(R.id.etModelo);
        etAno = (EditText)findViewById(R.id.etAno);

        btnInsert = (Button)findViewById(R.id.btnInsert);
        btnDelete = (Button)findViewById(R.id.btnDelete);
        btnUpdate = (Button)findViewById(R.id.btnUpdate);
        btnGet = (Button)findViewById(R.id.btnGet);
        btnGetAll = (Button)findViewById(R.id.btnGetAll);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        recyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(layoutManager);
        mAdapter = new LineAdapter(new ArrayList<>(0));
        recyclerView.setAdapter(mAdapter);

        btnInsert.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                String marca = etMarca.getText().toString();
                String modelo = etModelo.getText().toString();
                int ano = Integer.parseInt(etAno.getText().toString());

                Carro carro = new Carro(marca, modelo, ano);

                carros.insert(carro); // Insere no banco de dados

                mAdapter.insertItem(carro); // Insere no RecyclerView
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                int id = Integer.parseInt(etId.getText().toString());

                Carro carro = carros.getById(id);

                if(carro==null){

                    Toast.makeText(MainActivity.this, "Id não existe!" , Toast.LENGTH_LONG).show();
                }
                else{

                    carros.delete(carro); // Remove do banco

                    mAdapter.deleteItem(id); // Remove do RecyclerView
                }
            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                int id = Integer.parseInt(etId.getText().toString());

                Carro carro = carros.getById(id);

                if(carro==null){

                    Toast.makeText(MainActivity.this, "Id não existe!" , Toast.LENGTH_LONG).show();
                }
                else{

                    carro.setMarca(etMarca.getText().toString());
                    carro.setModelo(etModelo.getText().toString());
                    carro.setAno(Integer.parseInt(etAno.getText().toString()));

                    carros.update(carro);
                }
            }
        });

        btnGet.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                int id = Integer.parseInt(etId.getText().toString());

                Carro carro = carros.getById(id);

                if(carro==null){

                    Toast.makeText(MainActivity.this, "Id não existe!" , Toast.LENGTH_LONG).show();
                }
                else{

                    mAdapter.insertItem(carro);
                }
            }
        });

        btnGetAll.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                List<Carro> carroList = carros.getAll();

                for(Carro carro : carroList){

                    mAdapter.insertItem(carro);
                }
            }
        });
    }

    public void insertItem(Carro carro) {

        mAdapter.insertItem(carro);
    }

    public void deleteItem(int id){

        mAdapter.deleteItem(id);
    }

    public void updateItem(Carro carro){

        mAdapter.updateItem(carro);
    }
}
