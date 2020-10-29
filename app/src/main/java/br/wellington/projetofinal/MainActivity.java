package br.wellington.projetofinal;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


import br.wellington.projetofinal.database.ProdutoDAO;
import br.wellington.projetofinal.database.entity.ProdutoEntity;
import br.wellington.projetofinal.modelo.Produto;

public class MainActivity extends AppCompatActivity {

    private ListView listViewProdutos;
    private ArrayAdapter<Produto> adapterProdutos;
    private int id = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Produtos");
        listViewProdutos = findViewById(R.id.listView_produtos);
        ArrayList<Produto> produtos = new ArrayList<Produto>();

        definirOnClickListenerListView();
        definirOnLongClickListener();

    }

    @Override
    protected void onResume() {
        super.onResume();
        ProdutoDAO produtoDao = new ProdutoDAO(getBaseContext());
        adapterProdutos = new ArrayAdapter<Produto>(MainActivity.this, android.R.layout.simple_list_item_1, produtoDao.listar());
        listViewProdutos.setAdapter(adapterProdutos);
    }

    private void definirOnLongClickListener(){
        listViewProdutos.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, final long id) {
                final Produto produtoClicado = adapterProdutos.getItem(position);


                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setIcon((android.R.drawable.ic_delete));
                builder.setTitle("Excluir ?");
                builder.setMessage("Deseja excluir?");
                builder.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //DELETE
                        ProdutoDAO produtoDao = new ProdutoDAO(getBaseContext());
                        produtoDao.delete(produtoClicado.getId());

                        //
                        adapterProdutos.remove(produtoClicado);
                        adapterProdutos.notifyDataSetChanged();
                        Toast.makeText(MainActivity.this, "Produto Deletado", Toast.LENGTH_LONG).show();
                    }
                });
                builder.setNegativeButton("Não", null);
                builder.show();
                return true;
            }
        });
    }

    private void definirOnClickListenerListView(){
        listViewProdutos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Produto produtoClicado = adapterProdutos.getItem(position);
                Intent intent = new Intent(MainActivity.this, CadastroProdutoActivity.class);
                intent.putExtra("produtoEdicao", produtoClicado);
                startActivity(intent);
            }
        });
    }

    public void onClickNovoProduto(View view){
        Intent intent = new Intent(MainActivity.this, CadastroProdutoActivity.class);
        startActivity(intent);

    }

}