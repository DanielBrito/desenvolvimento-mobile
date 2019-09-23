package br.ufc.crateus.segundoprojeto;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        TextView tvResult = (TextView) findViewById(R.id.tvResult);

        String primeiro = "" + getIntent().getExtras().get("primeiro");
        String segundo = "" + getIntent().getExtras().get("segundo");

        if(!isNumeric(primeiro) && !isNumeric(segundo)){

            tvResult.setText(primeiro + segundo);

        }else if (isNumeric(primeiro) && isNumeric(segundo)){

           tvResult.setText("" + (Double.parseDouble(primeiro) + Double.parseDouble(segundo)));
        }
        else{

            Toast.makeText(this, "Erro!", Toast.LENGTH_SHORT).show();
        }

    }
    public static boolean isNumeric(String str) {

        try {

            Double.parseDouble(str);

            return true;

        } catch(NumberFormatException e){

            return false;
        }
    }
}
