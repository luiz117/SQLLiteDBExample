package com.example.luizao.android.bancodedadossqllite;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try{
            //CRIAR BD
            SQLiteDatabase bancoDados = openOrCreateDatabase("app",MODE_PRIVATE,null);

            //CRIAR TABELA
            bancoDados.execSQL("CREATE TABLE IF NOT EXISTS pessoas(id INTEGER PRIMARY KEY AUTOINCREMENT, nome VARCHAR, idade INT(3))");
           //bancoDados.execSQL("DROP TABLE pessoas");
           //bancoDados.execSQL("DROP TABLE pessoas");


//            //INSERIR DADOS
//            bancoDados.execSQL("INSERT INTO pessoas(nome, idade) VALUES ('Mariana',18)");
//            bancoDados.execSQL("INSERT INTO pessoas(nome, idade)  VALUES ('Marcia',26)");
//            bancoDados.execSQL("INSERT INTO pessoas(nome, idade)  VALUES ('João',20)");
//            bancoDados.execSQL("INSERT INTO pessoas(nome, idade)  VALUES ('Luis',27)");
//            bancoDados.execSQL("INSERT INTO pessoas(nome, idade)  VALUES ('Adriana',15)");



            //bancoDados.execSQL("UPDATE pessoas SET idade = 19 where nome='Mariana'");
            //bancoDados.execSQL("UPDATE pessoas SET nome = 'Mariana Silva' where id=1 ");
            //bancoDados.execSQL("DELETE FROM pessoas WHERE id = 2 ");
            bancoDados.execSQL("DELETE FROM pessoas");



            // RECUPERAR PESSOAS
            //String consulta = "SELECT nome, idade FROM pessoas where nome = 'Jose' AND  idade = 30";
            //String consulta = "SELECT nome, idade FROM pessoas where nome = 'Jose' AND  idade = 30";
            //String consulta = "SELECT nome, idade FROM pessoas ";
            //String consulta = "SELECT nome, idade FROM pessoas " +
//           "where idade>=35 OR idade = 18";

//            String consulta = "SELECT nome, idade FROM pessoas " +
//                    "where idade IN(18,35) ";


//            String consulta = "SELECT nome, idade FROM pessoas " +
//                    "where nome IN('Maria Francisca','Mariana') ";
//            String consulta = "SELECT nome, idade FROM pessoas " +
//                    "where idade BETWEEN 18 AND 35 ";

//            String consulta = "SELECT nome, idade FROM pessoas " +
//                    "where NOME LIKE '%ar%' ";

//            String filtro = "ar";
//
//            String consulta = "SELECT nome, idade FROM pessoas " +
//                    "where NOME LIKE '%" + filtro + "%' ";


//                    String consulta = "SELECT nome, idade FROM pessoas " +
//                    "where nome='Mariana'";

//            String consulta = "SELECT id, nome, idade FROM pessoas" +
//                            " WHERE 1=1";

            String consulta = "SELECT *FROM pessoas";

            Cursor cursor = bancoDados.rawQuery(consulta,null);

            //INDICES DA TABELA
            int indiceId = cursor.getColumnIndex("id");
            int indiceNome = cursor.getColumnIndex("nome");
            int indiceidade = cursor.getColumnIndex("idade");


            cursor.moveToFirst();
            while(cursor != null){
                String nome =cursor.getString(indiceNome);
                String idade =cursor.getString(indiceidade);
                String id = cursor.getString(indiceId);

                Log.i("Resultado" + " ID "+ id + " - nome", nome  + "\t idade: " + idade);
                cursor.moveToNext();
            }
        }catch (Exception ex){
            ex.printStackTrace();


        }finally {

        }
    }
}