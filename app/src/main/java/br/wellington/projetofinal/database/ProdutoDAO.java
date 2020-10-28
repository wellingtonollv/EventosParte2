package br.wellington.projetofinal.database;

import android.content.ContentValues;
import android.content.Context;

import br.wellington.projetofinal.database.entity.ProdutoEntity;
import br.wellington.projetofinal.modelo.Produto;

public class ProdutoDAO {

    private DBGateway dbGateway;

    public ProdutoDAO (Context context){
        dbGateway = DBGateway.getInstance(context);
    }

    public boolean salvar(Produto produto){
        ContentValues contentValues = new ContentValues();
        contentValues.put(ProdutoEntity.COLUMN_NAME_NOME, produto.getNome());
        contentValues.put(ProdutoEntity.COLUMN_NAME_VALOR, produto.getValor());
        long id = dbGateway.getDataBase().insert(ProdutoEntity.TABLE_NAME,
                null, contentValues);
        return id > 0;
    }

}
