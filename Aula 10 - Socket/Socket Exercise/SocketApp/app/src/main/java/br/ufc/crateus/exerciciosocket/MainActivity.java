package br.ufc.crateus.exerciciosocket;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.security.Timestamp;
import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    private LineAdapter mAdapter;
    TextView data;
    Button button;
    Date date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button)findViewById(R.id.button);
        data = (TextView) findViewById(R.id.data);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        mAdapter = new LineAdapter(new ArrayList<>(0));
        recyclerView.setAdapter(mAdapter);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Socket socket = new Socket("10.5.30.51", 60000);

                            DataInputStream dIn = new DataInputStream(socket.getInputStream());
                            DataOutputStream dOut = new DataOutputStream(socket.getOutputStream());

                            long result = dIn.readLong();

                            date = new Date(result);

                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    insertItem(date);
                                }
                            });


                            System.out.println("RESULT: " + date);

                            dIn.close();
                            dOut.close();
                            socket.close();

                        } catch (UnknownHostException e) {

                            e.printStackTrace();

                        } catch (IOException e) {

                            e.printStackTrace();
                        }
                    }

                }).start();
            }
        });
    }

    public void insertItem(Date data) {

        mAdapter.insertItem(data);
    }
}
