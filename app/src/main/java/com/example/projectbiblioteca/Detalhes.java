package com.example.projectbiblioteca;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

public class Detalhes extends AppCompatActivity {

    String titulo;
    String sub;
    String distrib;
    String dataDist;
    String descricao;
    String thumb;
    String preLink;
    String infoLink;
    String compraLink;
    int qntPages;

    TextView tituloLivro;
    TextView subLivro;
    TextView distribuidoraLivro;
    TextView descricaoLivro;
    TextView qntPagesLivro;
    TextView dataPubLivro;

    Button preButton, comprarButton;
    private ImageView imgLivro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes);

        tituloLivro = findViewById(R.id.idTituloLivro);
        subLivro = findViewById(R.id.idSubLivro);
        distribuidoraLivro = findViewById(R.id.idDistLivro);
        descricaoLivro = findViewById(R.id.idDescricaoLivro);
        qntPagesLivro = findViewById(R.id.id_PagesLivro);
        dataPubLivro = findViewById(R.id.id_DataPubLivro);
        preButton = findViewById(R.id.idPreButton);
        comprarButton = findViewById(R.id.idComprarButton);
        imgLivro = findViewById(R.id.idImgLivro);

        titulo = getIntent().getStringExtra("Titulo");
        sub = getIntent().getStringExtra("Sub-Titulo");
        distrib = getIntent().getStringExtra("Distribuidora");
        dataDist = getIntent().getStringExtra("Data Publicada");
        descricao = getIntent().getStringExtra("Descricao");
        qntPages = getIntent().getIntExtra("Paginas", 0);
        thumb = getIntent().getStringExtra("Capa");
        preLink = getIntent().getStringExtra("Pre Visualizar");
        infoLink = getIntent().getStringExtra("Informacoes");
        compraLink = getIntent().getStringExtra("Comprar");

        tituloLivro.setText(titulo);
        subLivro.setText(sub);
        distribuidoraLivro.setText(distrib);
        dataPubLivro.setText("Published On : " + dataDist);
        descricaoLivro.setText(descricao);
        qntPagesLivro.setText("No Of Pages : " + qntPages);
        Picasso.get().load(thumb).into(imgLivro);

        preButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (preLink.isEmpty()) {
                    Toast.makeText(Detalhes.this, "Pré visualização não disponível!", Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    Uri uri = Uri.parse(preLink);
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }
            }
        });

        comprarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (compraLink.isEmpty()) {
                    Toast.makeText(Detalhes.this, "Página de compra indisponível!!!", Toast.LENGTH_SHORT).show();
                    return;
                }else{
                    Uri uri = Uri.parse(compraLink);
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }
            }
        });
    }
}