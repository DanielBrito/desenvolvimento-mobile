package br.ufc.crateus.teste1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class TelaPrincipalActivity extends AppCompatActivity {


    Button btCadastrar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_principal);

        btCadastrar = (Button) findViewById(R.id.btCadastrar);

        String login = "" + getIntent().getExtras().get("login");

        String senha = "" + getIntent().getExtras().get("senha");

        if(login.equals("admin") && senha.equals("1234")){
            btCadastrar.setVisibility(View.VISIBLE);
        } else{
            btCadastrar.setVisibility(View.GONE);

        }

        btCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(TelaPrincipalActivity.this, TelaCadastroActivity.class);
                startActivity(i);
            }
        });

    }
}
