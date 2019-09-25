package br.ufc.crateus.recyclerviewapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    FloatingActionButton fab;
    private LineAdapter mAdapter;

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
        model.setName("Daniel");
        model.setAge(26);
        model.setCity("São Paulo");
        mAdapter.insertItem(model);
    }
}
