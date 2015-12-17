package br.senac.pi.consumoarcondicionado;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class Calculo_De_AparelhosActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculo__de__aparelhos);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
           findViewById(R.id.btnchamaarcondicionado).setOnClickListener(chamaarcondicionado());
            findViewById(R.id.btnchamaferroeletrico).setOnClickListener(ferroeletrico());
           findViewById(R.id.btnchamageladeira).setOnClickListener(geladeira());
          findViewById(R.id.btnchamamaquinadelavar).setOnClickListener(maquinadelavar());
        findViewById(R.id.btnlistaraparelho).setOnClickListener(listar());
           findViewById(R.id.bntsair).setOnClickListener(sai());


    }
    private View.OnClickListener listar(){
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Calculo_De_AparelhosActivity.this,ListarActivity.class);
                startActivity(intent);
            }
        };
    }
     private View.OnClickListener chamaarcondicionado(){
         return new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 Intent intent = new Intent(Calculo_De_AparelhosActivity.this,Arcondicionado.class);
                 startActivity(intent);
             }
         };
     }
    private View.OnClickListener ferroeletrico(){
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Calculo_De_AparelhosActivity.this,Ferro_de_PassarActivity.class);
                startActivity(intent);
            }
        };
    }
    private View.OnClickListener geladeira(){
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Calculo_De_AparelhosActivity.this,GeladeiraActivity.class);
                startActivity(intent);
            }
        };
    }
    private View.OnClickListener maquinadelavar(){
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Calculo_De_AparelhosActivity.this,Maquina_de_Lavar_RoupaActivity.class);
                startActivity(intent);
            }
        };
    }
    private View.OnClickListener sai(){
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                finish();
            }
        };
    }

}
