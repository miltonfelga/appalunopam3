package com.example.appaluno;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;


public class Conexao extends SQLiteOpenHelper {

    //criação das variáveis globais e constantes

    public static final String NOME_DO_BANCO = "dbAlunoCriar.db";
    public static final int VERSAO_DO_BANCO = 1;

    //Criação do banco de dados
    public Conexao(@Nullable Context context) {
        super(context, NOME_DO_BANCO, null, VERSAO_DO_BANCO);
    }

    //Criação da tabela
    @Override
    public void onCreate(SQLiteDatabase db) {

        String cria_tabela = "CREATE TABLE tbAluno(codigo INTEGER PRIMARY KEY, nome VARCHAR, email VARCHAR, telefone VARCHAR)";

        db.execSQL(cria_tabela);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //Apaga os registros do banco e o banco se mudar de versão.
        db.execSQL("drop table if exists tbAluno");
    }

    //Criar os métodos de insert, delete, update e select para o meu banco...

}
