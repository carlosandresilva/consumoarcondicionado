package br.senac.pi.consumoarcondicionado;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Maquina_de_Lavar_RoupaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maquina_de__lavar__roupa);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        findViewById(R.id.btnmaquinadelavar).setOnClickListener(calculo());
        findViewById(R.id.btnsalvarmaquinalavar).setOnClickListener(salvar());

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
    private View.OnClickListener calculo (){
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText txtHorasdia = (EditText)findViewById(R.id.txtHorasdiamaquinalavar);
                EditText txtDias = (EditText)findViewById(R.id.txtDiasmaquinalavar);

                TextView texto = (TextView)findViewById(R.id.txtmaquinadelavar);

                double horasdia = Double.parseDouble(txtHorasdia.getText().toString());
                double dias = Double.parseDouble(txtDias.getText().toString());

                double resultado = (1000*horasdia*dias)/1000;
                texto.setText(String.valueOf(resultado));

            }
        };


    }

    private View.OnClickListener salvar (){
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                TextView texto = (TextView)findViewById(R.id.txtmaquinadelavar);
                Calculo calculo = new Calculo();
                ConsumoBD BD = new ConsumoBD(Maquina_de_Lavar_RoupaActivity.this);

                calculo.setNome("maquina de lavar");
                calculo.setResultado(Double.parseDouble(texto.getText().toString()));

                BD.save(calculo);
                Toast.makeText(Maquina_de_Lavar_RoupaActivity.this, "resultado salvo com sucesso", Toast.LENGTH_SHORT).show();

            }
        };


    }}

