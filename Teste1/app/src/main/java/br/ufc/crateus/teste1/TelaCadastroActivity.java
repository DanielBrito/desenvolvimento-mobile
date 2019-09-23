package br.ufc.crateus.teste1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class TelaCadastroActivity extends AppCompatActivity {
    EditText etNome;
    EditText etIdade;
    EditText etGenero;
    EditText etEmail;
    CheckBox cbAviso;
    Spinner sProfissao;
    Button btCadastro;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_cadastro);

        etNome = (EditText) findViewById(R.id.etNome);
        etIdade = (EditText) findViewById(R.id.etIdade);
        etGenero = (EditText) findViewById(R.id.etGenero);
        etEmail = (EditText) findViewById(R.id.etEmail);
        cbAviso = (CheckBox) findViewById(R.id.cbAviso);
        sProfissao = (Spinner) findViewById(R.id.sProfissao);
        btCadastro = (Button) findViewById(R.id.btCadastro);

        final String[] country = { "Estudante", "Professor", "Other"};

        ArrayAdapter aa = new ArrayAdapter(this, android.R.layout.simple_spinner_item, country);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sProfissao.setAdapter(aa);

        btCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://almada-mobile.herokuapp.com/api/users/add?nome="+etNome.getText().toString()+"&genero="+etGenero.getText().toString()+"&idade="+etIdade.getText().toString()+"&email="+etEmail.getText().toString()+"&aviso="+cbAviso.isChecked()+"&profissao="+sProfissao.getSelectedItem()));
                startActivity(intent);
            }
        });

    }
}
