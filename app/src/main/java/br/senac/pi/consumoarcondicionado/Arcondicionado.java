package br.senac.pi.consumoarcondicionado;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Arcondicionado extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arcondicionado);


        findViewById(R.id.btncalcular).setOnClickListener(calculo());
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
              texto.setText("o consumo do ar condicionado é: "+""+resultado);

            }
        };

    }
}
