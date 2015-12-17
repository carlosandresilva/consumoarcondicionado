package br.senac.pi.consumoarcondicionado;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Arcondicionado extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arcondicionado);


        findViewById(R.id.btncalcular).setOnClickListener(calculo());
        findViewById(R.id.btnsalvar).setOnClickListener(salvar());
    }
    private View.OnClickListener calculo (){
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText txtHorasdia = (EditText)findViewById(R.id.txtHorasdia);
                EditText txtDias = (EditText)findViewById(R.id.txtDias);
                EditText txtConsumoKwh = (EditText)findViewById(R.id.txtConsumokwh);
                EditText txtPrecoenergia = (EditText)findViewById(R.id.txtPrecoenergia);
                TextView texto = (TextView)findViewById(R.id.txt);
                double horasdia = Double.parseDouble(txtHorasdia.getText().toString());
                double dias = Double.parseDouble(txtDias.getText().toString());
                double consumo = Double.parseDouble(txtConsumoKwh.getText().toString());
                double precoenergia = Double.parseDouble(txtPrecoenergia.getText().toString());
              double resultado = (((horasdia*dias)/30)*consumo)*precoenergia;
              texto.setText(String.valueOf(resultado));

            }
        };


    }

    private View.OnClickListener salvar (){
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                TextView texto = (TextView)findViewById(R.id.txt);
               Calculo calculo = new Calculo();
                ConsumoBD BD = new ConsumoBD(Arcondicionado.this);

                calculo.setNome("arcondicionado");
                calculo.setResultado(Double.parseDouble(texto.getText().toString()));

                BD.save(calculo);
                Toast.makeText(Arcondicionado.this, "resultado salvo com sucesso", Toast.LENGTH_SHORT).show();
            }
        };


    }
}
