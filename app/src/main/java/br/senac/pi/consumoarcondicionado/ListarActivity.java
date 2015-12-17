package br.senac.pi.consumoarcondicionado;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

public class ListarActivity extends AppCompatActivity {
    private CursorAdapter dataSource;
    private SQLiteDatabase database;
    private static final String campos[] = {"nome","resultado","_id"};
    ListView listView;
    ConsumoBD calculobd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar);
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
    }


    @Override
    protected void onResume() {
        super.onResume();


        listView = (ListView) findViewById(R.id.listar);
        calculobd = new ConsumoBD(this);
        database = calculobd.getWritableDatabase();

        Cursor carros = database.query("calculo", campos, null, null, null, null, null);
        if (carros.getCount() > 0) {
            dataSource = new SimpleCursorAdapter(ListarActivity.this, R.layout.row, carros, campos, new int[]{R.id.txtNome, R.id.txtresultado});
            listView.setAdapter(dataSource);
        } else {
            Toast.makeText(ListarActivity.this, "nenhum registro encontrado", Toast.LENGTH_LONG).show();
        }


    }
}
