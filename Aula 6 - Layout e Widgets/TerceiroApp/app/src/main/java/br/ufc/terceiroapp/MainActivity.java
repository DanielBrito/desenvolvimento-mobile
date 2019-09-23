package br.ufc.terceiroapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    CheckBox checkPizza;
    CheckBox checkRefri;
    CheckBox checkHamburger;
    Button btnCalcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCalcular = (Button)findViewById(R.id.btnCalcular);

        checkPizza = (CheckBox)findViewById(R.id.checkPizza);
        checkRefri = (CheckBox)findViewById(R.id.checkRefri);
        checkHamburger = (CheckBox)findViewById(R.id.checkHamburger);

        btnCalcular.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                double pizzaPrice = 10.00;
                double refriPrice = 5.90;
                double hamburgerPrice = 3.60;
                double total = 0.0;

                String message = "Itens Selecionados\n";

                if(checkPizza.isChecked()){

                    total += pizzaPrice;

                    message += "Pizza: R$ " + pizzaPrice + "\n";

                }

                if(checkRefri.isChecked()){

                    total += refriPrice;

                    message += "Refri: R$ " + refriPrice + "\n";
                }

                if(checkHamburger.isChecked()){

                    total += hamburgerPrice;

                    message += "Hamburger: R$ " + hamburgerPrice + "\n";
                }

                message += "Total: R$ " + total;

                Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
