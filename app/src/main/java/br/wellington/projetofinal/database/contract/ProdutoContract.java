package br.wellington.projetofinal.database.contract;

import br.wellington.projetofinal.database.entity.ProdutoEntity;

public class ProdutoContract {

    private ProdutoContract() {}

    public static final String criarTabela(){
        return "CREATE TABLE " + ProdutoEntity.TABLE_NAME + " (" +
                ProdutoEntity._ID + " INTEGER PRIMARY KEY," +
                ProdutoEntity.COLUMN_NAME_NOME + " TEXT," +
                ProdutoEntity.COLUMN_NAME_VALOR + " REAL)";
    }

    public static final String removerTabela(){
        return "DROP TABLE IF EXISTS " + ProdutoEntity.TABLE_NAME;
    }
}
