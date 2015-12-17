package br.senac.pi.consumoarcondicionado;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aluno on 16/12/2015.
 */
public class ConsumoBD extends SQLiteOpenHelper {
    private static final String TAG = "sql";
    //Nome do banco
    private static final String NOME_BANCO = "cursoandroid.sqlite";
    private static final int VERSAO_BANCO = 1;

    public ConsumoBD(Context context){
        //context, nome do banco, factory, versão
        super(context, NOME_BANCO, null, VERSAO_BANCO);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        Log.d(TAG, "salvando");
        db.execSQL("CREATE TABLE IF NOT EXISTS calculo(_id integer primary key autoincrement, nome text, resultado double);");
        Log.d(TAG, "salvo com sucesso!");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        //Caso mude a versão do banco de dados sql de atualização deve ser executado aqui.

    }


    public long save(Calculo calculo){
        long id = calculo.getId();
        SQLiteDatabase db = getWritableDatabase();
        try{
            ContentValues values = new ContentValues();
            values.put("nome",calculo.getNome());
            values.put("resultado",calculo.getResultado());
            if (id != 0){
                String _id = String.valueOf(calculo.getId());
                String[] whereargs = new String[]{_id};
                //update calculo set values = ... where _id = ?
                int count = db.update("calculo",values, "_id=?", whereargs);
                return count;
            }else{
                //insert into carro values..
                id = db.insert("calculo","",values);
                return id;
            }
        }finally {
            db.close();
        }
    }
    //Consulta a lista com todos os carros
    public List<Calculo> findAll(){
        SQLiteDatabase db = getWritableDatabase();
        try{
            //SELECT * FROM carro
            Cursor cursor = db.query("calculo", null, null, null, null, null, null, null);
            return toList(cursor);
        }finally {
            db.close();
        }
    }

    public List<Calculo> toList(Cursor cursor){
        List<Calculo> carros = new ArrayList<Calculo>();
        if (cursor.moveToFirst()){
            do {
                Calculo calculo = new Calculo();
                carros.add(calculo);
                //recupera os atributos de carro
                calculo.setId(cursor.getLong(cursor.getColumnIndex("_id")));
                calculo.setNome(cursor.getString(cursor.getColumnIndex("nome")));
                calculo.setResultado(cursor.getDouble(cursor.getColumnIndex("resultado")));

            }while (cursor.moveToNext());
        }
        return carros;
    }
}
