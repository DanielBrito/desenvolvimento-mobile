package com.example.teste2;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    SumAdapter mAdapter;

    FloatingActionButton btnAdd;
    Button btnNext;
    int countAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAdd = (FloatingActionButton) findViewById(R.id.btnAdd);
        btnNext = (Button) findViewById(R.id.btnNextRest);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(layoutManager);

        mAdapter = new SumAdapter(new ArrayList<>(0));

        recyclerView.setAdapter(mAdapter);

        countAdd = 0;

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            new Thread(new Runnable() {

                @Override
                public void run() {

                    try {

                        Socket socket = new Socket("192.168.0.124", 60000); // host @ ifconfig

                        DataInputStream dIn1 = new DataInputStream(socket.getInputStream());
                        DataInputStream dIn2 = new DataInputStream(socket.getInputStream());
                        DataInputStream dIn3 = new DataInputStream(socket.getInputStream());

                        DataOutputStream dOut1 = new DataOutputStream(socket.getOutputStream());
                        DataOutputStream dOut2 = new DataOutputStream(socket.getOutputStream());
                        DataOutputStream dOut3 = new DataOutputStream(socket.getOutputStream());

                        dOut1.writeUTF("OK");
                        dOut1.flush();

                        dOut2.writeUTF("OK");
                        dOut2.flush();

                        dOut3.writeUTF("OK");
                        dOut3.flush();

                        final int num1 = dIn1.readInt();
                        final int num2 = dIn2.readInt();
                        final int num3 = dIn3.readInt();

                        runOnUiThread(new Runnable() {

                            @Override
                            public void run() {

                                insertItem(new Operation(num1, num2, num3, num1+num2+num3));

                                if(countAdd==5){

                                    btnNext.setEnabled(true);
                                }
                            }
                        });

                        dIn1.close();
                        dIn2.close();
                        dIn3.close();

                        dOut1.close();
                        dOut2.close();
                        dOut3.close();

                        socket.close();

                    } catch (UnknownHostException e) {

                        e.printStackTrace();

                    } catch (IOException e) {

                        e.printStackTrace();
                    }

                    ++countAdd;

                    Log.i("msg", "COUNT = " + countAdd);

                }

            }).start();
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Intent i = new Intent(MainActivity.this, GetActivity.class);
                startActivity(i);
            }
        });
    }

    public void insertItem(Operation operation) {

        mAdapter.insertItem(operation);
    }
}
