package com.example.projectbiblioteca;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ProgressBar;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RequestQueue requestQueue;
    private ArrayList<Livros> listaLivros;
    private ProgressBar progressBar;
    private EditText editPesquisa;
    private ImageButton botaoSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar = findViewById(R.id.idProgressBar);
        editPesquisa = findViewById(R.id.idEditPesquisa);
        botaoSearch = findViewById(R.id.idBotaoSearch);

        botaoSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBar.setVisibility(View.VISIBLE);

                if (editPesquisa.getText().toString().isEmpty()) {
                    editPesquisa.setError("Por favor, preencha este campo!");
                    return;
                }else{
                    informacoes(searchEdt.getText().toString());
                }
            }
        });
    }

    private void informacoes(String URL){
        listaLivros = new ArrayList<>();

        requestQueue = Volley.newRequestQueue(MainActivity.this);
        requestQueue.getCache().clear();

        String url = "https://www.googleapis.com/books/v1/volumes?q=" + URL;
        RequestQueue queue = Volley.newRequestQueue(MainActivity.this);

        JsonObjectRequest objectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                progressBar.setVisibility(View.GONE);

                try {
                    JSONArray itemsArray = response.getJSONArray("items");
                    for (int i = 0; i < itemsArray.length(); i++) {
                        JSONObject itemsObj = itemsArray.getJSONObject(i);
                        JSONObject volumeObj = itemsObj.getJSONObject("volumeInfo");
                        String titulo = volumeObj.optString("Titulo");
                        String sub = volumeObj.optString("Sub-Titulo");
                        JSONArray authorsArray = volumeObj.getJSONArray("Autores");
                        String distribuidora = volumeObj.optString("Distribuidora");
                        String dataPub = volumeObj.optString("Data Publicada");
                        String descricao = volumeObj.optString("Descricao");
                        int paginas = volumeObj.optInt("Paginas");
                        JSONObject imageLinks = volumeObj.optJSONObject("imageLinks");
                        String thumb = imageLinks.optString("Capa");
                        String linkPre = volumeObj.optString("Pre Visualizar");
                        String linkInfo = volumeObj.optString("Informacoes");
                        JSONObject saleInfoObj = itemsObj.optJSONObject("saleInfo");
                        String linkCompra = saleInfoObj.optString("Comprar");
                        ArrayList<String> listaAutores = new ArrayList<>();
                        if (authorsArray.length() != 0) {
                            for (int j = 0; j < authorsArray.length(); j++) {
                                listaAutores.add(authorsArray.optString(i));
                            }
                        }
                        Livros livros = new Livros(titulo, sub, listaAutores, distribuidora, dataPub, descricao, paginas, thumb, linkPre, linkInfo, linkCompra);
                        listaLivros.add(livros);

                        AdapterLivros adapter = new AdapterLivros(listaLivros, MainActivity.this);

                        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MainActivity.this, RecyclerView.VERTICAL, false);
                        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.idRecycleView);



            }
        });



    }
}