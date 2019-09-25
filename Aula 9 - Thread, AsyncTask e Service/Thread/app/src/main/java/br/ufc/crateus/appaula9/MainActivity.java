package br.ufc.crateus.appaula9;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView tvResult;
    int i=0;

    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvResult = (TextView) findViewById(R.id.tvResult);

        new Thread(new Runnable() {
            @Override
            public void run() {
                while(true) {
                    runOnUiThread( new Runnable() {
                        @Override
                        public void run() {
                            tvResult.setText("" + i);
                        }
                    });

                    i++;
                    try {
                        Thread. sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        handler.postDelayed( new Runnable() {
            @Override
            public void run() {
                Toast. makeText(MainActivity.this, "StackOverflow", Toast.LENGTH_SHORT).show();
                handler.postDelayed( this, 5000);
            }
        }, 2000);


    }
}
