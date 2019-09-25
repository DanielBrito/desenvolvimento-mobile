package br.ufc.crateus.socketapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class MainActivity extends AppCompatActivity {

    Button button;
    EditText text;
    String response;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button)findViewById(R.id.button);
        text = (EditText)findViewById(R.id.text);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Socket socket = new Socket("10.5.30.51", 50000); // ifconfig @ Console

                            DataInputStream dIn = new DataInputStream(socket.getInputStream());
                            DataInputStream dIn2 = new DataInputStream(socket.getInputStream());

                            DataOutputStream dOut = new DataOutputStream(socket.getOutputStream());

                            dOut.writeUTF(text.getText().toString());

                            String result = dIn.readUTF();
                            String result2 = dIn2.readUTF();

                            if(result.equals("OK 1")){

                                response = "Você mandou 1";
                            }
                            else if(result.equals("OK 2")){

                                response = "Você mandou 2";
                            }
                            else{

                                response = "Not found";
                            }

                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    text.setText(response);
                                }
                            });

                            System.out.println(result2);

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
}
