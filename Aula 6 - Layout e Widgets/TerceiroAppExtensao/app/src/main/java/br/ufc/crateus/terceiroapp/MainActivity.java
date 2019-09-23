package br.ufc.crateus.terceiroapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    CheckBox cbPizza;
    CheckBox cbRefri;
    CheckBox cbHambuguer;

    Button btCalcular;

    EditText etPizzaValor;
    EditText etPizzaQtd;

    EditText etRefriValor;
    EditText etRefriQtd;

    EditText etHambuguerValor;
    EditText etHambuguerQtd;

    Double total;
    double PizzaValor;
    double PizzaQtd;
    double RefriValor;
    double RefriQtd;
    double HambValor;
    double HambQtd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btCalcular = (Button) findViewById(R.id.btCalcular);

        cbPizza = (CheckBox) findViewById(R.id.cbPizza);
        etPizzaValor = (EditText) findViewById(R.id.etPizzaValor);
        etPizzaQtd = (EditText) findViewById(R.id.etPizzaQtd);

        cbRefri = (CheckBox) findViewById(R.id.cbRefri);
        etRefriValor = (EditText) findViewById(R.id.etRefriValor);
        etRefriQtd = (EditText) findViewById(R.id.etRefriQtd);

        cbHambuguer = (CheckBox) findViewById(R.id.cbHambuguer);
        etHambuguerValor = (EditText) findViewById(R.id.etHambuguerValor);
        etHambuguerQtd = (EditText) findViewById(R.id.etHambuguerQtd);

        btCalcular.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

            total = 0.0;

            if(cbPizza.isChecked()){

                PizzaValor   = Double.parseDouble(etPizzaValor.getText().toString());
                PizzaQtd   = Double.parseDouble(etPizzaQtd.getText().toString());
                total = total +(PizzaQtd*PizzaValor);
            }
            if(cbRefri.isChecked()){

                RefriValor   = Double.parseDouble(etRefriValor.getText().toString());
                RefriQtd   = Double.parseDouble(etRefriQtd.getText().toString());
                total = total +(RefriQtd*RefriValor);
            }
            if(cbHambuguer.isChecked()){

                HambValor   = Double.parseDouble(etHambuguerValor.getText().toString());
                HambQtd   = Double.parseDouble(etHambuguerQtd.getText().toString());
                total = total +(HambValor*HambQtd);
            }

                Toast.makeText(getApplicationContext(), "Total a pagar: R$ "+total, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
