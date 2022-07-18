package com.example.projectbiblioteca;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class AdapterLivros extends RecyclerView.Adapter<AdapterLivros.ViewHolder> {

    private ArrayList<Livros> listaLivros;
    private Context context;

    public AdapterLivros(ArrayList<Livros> livrosLista, Context context) {
        this.listaLivros = livrosLista;
        this.context = context;
    }

    @NonNull
    @Override
    public AdapterLivros.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view =layoutInflater.inflate(R.layout.livro_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int posicao) {
        Livros livros = listaLivros.get(posicao);
        holder.titulo.setText(livros.getTitulo());
        holder.distribuidora.setText(livros.getDistribuidora());
        holder.qntPag.setText("Páginas : " + livros.getQntPages());
        holder.data.setText(livros.getDataDistrib());
//        Log.d("livros", livros.getThumb());

//        Picasso.get().load(livros.getThumb())
//                .error(R.drawable.image_error)
//                .placeholder(R.drawable.placeholder_image)
//                .into(holder.imagem);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, Detalhes.class);
                i.putExtra("title", livros.getTitulo());
                i.putExtra("subtitle", livros.getSub());
                i.putExtra("authors", livros.getAutores());
                i.putExtra("publisher", livros.getDistribuidora());
                i.putExtra("publishedDate", livros.getDataDistrib());
                i.putExtra("description", livros.getDescricao());
                i.putExtra("pageCount", livros.getQntPages());
                i.putExtra("thumbnail", livros.getThumb());
                i.putExtra("previewLink", livros.getLinkPre());
                i.putExtra("infoLink",livros.getInfoLink());
                i.putExtra("buyLink", livros.getLinkCompra());

                context.startActivity(i);
            }
        });

    }


    @Override
    public int getItemCount() {
        return listaLivros.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
            TextView titulo, distribuidora, qntPag, data;
            ImageView imagem;

        public ViewHolder(View itemView) {
                super(itemView);
                titulo = itemView.findViewById(R.id.idTitulo);
                distribuidora = itemView.findViewById(R.id.idDist);
                qntPag = itemView.findViewById(R.id.idPaginas);
                data = itemView.findViewById(R.id.idData);
                imagem = itemView.findViewById(R.id.idImg);
        }
    }
}
