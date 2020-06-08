package com.example.appaluno;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            //Criando o esquema de banco de dados. Criando o banco de dados
            SQLiteDatabase bd = openOrCreateDatabase("dbAlunoCriar", MODE_PRIVATE, null);


            //Criar a tabela do banco de dados
            bd.execSQL("CREATE TABLE IF NOT EXISTS tbAluno (nome VARCHAR,email VARCHAR,telefone VARCHAR)");

            //Inserindo dados na tabela
            bd.execSQL("INSERT INTO tbAluno(nome,email,telefone)VALUES('Maria','maria@gmail.com','1156628989')");
            bd.execSQL("INSERT INTO tbAluno(nome,email,telefone)VALUES('João','joao@gmail.com','1156638787')");
            bd.execSQL("INSERT INTO tbAluno(nome,email,telefone)VALUES('Fernando','fernando@gmail.com','1156615656')");
            bd.execSQL("INSERT INTO tbAluno(nome,email,telefone)VALUES('Igor','igor@gmail.com','1156645454')");
            bd.execSQL("INSERT INTO tbAluno(nome,email,telefone)VALUES('Milton','milton@gmail.com','1156687474')");
            bd.execSQL("INSERT INTO tbAluno(nome,email,telefone)VALUES('Rafael','rafael@gmail.com','1156622525')");
            bd.execSQL("INSERT INTO tbAluno(nome,email,telefone)VALUES('Tiago','tiago@gmail.com','1156666363')");
            bd.execSQL("INSERT INTO tbAluno(nome,email,telefone)VALUES('Luciana','luciana@gmail.com','1156697878')");
            bd.execSQL("INSERT INTO tbAluno(nome,email,telefone)VALUES('Carolina','carolina@gmail.com','1156625454')");
            bd.execSQL("INSERT INTO tbAluno(nome,email,telefone)VALUES('Beatriz','beatriz@gmail.com','1156635452')");
            bd.execSQL("INSERT INTO tbAluno(nome,email,telefone)VALUES('Laura','laura@gmail.com','1156634585')");


            //Buscando os dados na tabela
            Cursor cursor = bd.rawQuery("SELECT nome, email , telefone FROM tbAluno", null);

            //Qual a coluna que estou pegando os valores
            int indiceNome = cursor.getColumnIndex("nome");
            int indiceEmail = cursor.getColumnIndex("email");
            int indiceTelefone = cursor.getColumnIndex("email");

            //Vai guiar o cursor para frente da tabela inteira
            cursor.moveToFirst();

            while (cursor != null) {
                Log.i("Resultado - nome", cursor.getString(indiceNome));
                Log.i("Resultado - email", cursor.getString(indiceEmail));
                Log.i("Resultado - telefone", cursor.getString(indiceTelefone));
                //Guiar o cursor para frente de cada registro
                cursor.moveToNext();
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}