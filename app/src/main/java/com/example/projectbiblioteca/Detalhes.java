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

        titulo = getIntent().getStringExtra("title");
        sub = getIntent().getStringExtra("subtitle");
        distrib = getIntent().getStringExtra("publisher");
        dataDist = getIntent().getStringExtra("publishedDate");
        descricao = getIntent().getStringExtra("description");
        qntPages = getIntent().getIntExtra("pageCount", 0);
        thumb = getIntent().getStringExtra("thumbnail");
        preLink = getIntent().getStringExtra("previewLink");
        infoLink = getIntent().getStringExtra("infoLink");
        compraLink = getIntent().getStringExtra("buyLink");

        tituloLivro.setText(titulo);
        subLivro.setText(sub);
        distribuidoraLivro.setText(distrib);
        dataPubLivro.setText("Publicado em: " + dataDist);
        descricaoLivro.setText(descricao);
        qntPagesLivro.setText("P??ginas: " + qntPages);
        Picasso.get().load(thumb).into(imgLivro);

        preButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (preLink.isEmpty()) {
                    Toast.makeText(Detalhes.this, "Pr?? visualiza????o n??o dispon??vel!", Toast.LENGTH_SHORT).show();
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
                    Toast.makeText(Detalhes.this, "P??gina de compra indispon??vel!!!", Toast.LENGTH_SHORT).show();
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