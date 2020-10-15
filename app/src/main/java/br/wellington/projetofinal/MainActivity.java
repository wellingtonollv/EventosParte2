package br.wellington.projetofinal;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import br.wellington.projetofinal.modelo.Produto;

public class MainActivity extends AppCompatActivity {

    private final int REQUEST_CODE_NOVO_PRODUTO=1 ;
    private final int RESULT_CODE_NOVO_PRODUTO=10;

    private ListView listViewProdutos;
    private ArrayAdapter<Produto> adapterProdutos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Produtos");

        listViewProdutos = findViewById(R.id.listView_produtos);
        ArrayList<Produto> produtos =this.criarListaProdutos();

        adapterProdutos = new ArrayAdapter<Produto>(MainActivity.this, android.R.layout.simple_list_item_1, produtos);

        listViewProdutos.setAdapter(adapterProdutos);



    }
    private ArrayList<Produto> criarListaProdutos(){
        ArrayList<Produto> produtos = new ArrayList<Produto>();
        produtos.add(new Produto("Notebook",3500f));
        produtos.add(new Produto("Mouse",50f));
        produtos.add(new Produto("Roteador",120f));
        return produtos;
    }

    public void onClickNovoProduto(View view){
        Intent intent = new Intent(MainActivity.this, CadastroProdutoActivity.class);
        startActivityForResult(intent, REQUEST_CODE_NOVO_PRODUTO);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode==REQUEST_CODE_NOVO_PRODUTO && resultCode==RESULT_CODE_NOVO_PRODUTO){
            Produto produto = (Produto) data.getExtras().getSerializable("novoProduto");
            this.adapterProdutos.add(produto);
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}