package br.ufc.crateus.recyclerviewapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    FloatingActionButton fab;
    private LineAdapter mAdapter;
    TextView nomeInput, idadeInput, cidadeInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        fab = (FloatingActionButton) findViewById(R.id.floatingActionButton);
        LinearLayoutManager layoutManager = new LinearLayoutManager( this);
        recyclerView.setLayoutManager(layoutManager);
        mAdapter = new LineAdapter( new ArrayList<>( 0));
        recyclerView.setAdapter( mAdapter);

        fab.setOnClickListener(view -> insertItem());
    }

    public void insertItem() {
        UserModel model = new UserModel();

        nomeInput = (TextView) findViewById(R.id.nomeInput);
        idadeInput = (TextView) findViewById(R.id.idadeInput);
        cidadeInput = (TextView) findViewById(R.id.cidadeInput);

        model.setName(nomeInput.getText().toString());
        model.setAge(Integer.parseInt(idadeInput.getText().toString()));
        model.setCity(cidadeInput.getText().toString());

        mAdapter.insertItem(model);
    }
}
