package br.ufc.crateus.primeiroapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText inputLink;
    Button buttonOpen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        inputLink = (EditText) findViewById(R.id.inputLink);
        buttonOpen = (Button) findViewById(R.id.buttonOpen);

        buttonOpen.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Intent intent=new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://" + inputLink.getText().toString()));
                startActivity(intent);
            }
        });
    }
}

