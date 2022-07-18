package com.example.projectbiblioteca;

import java.util.ArrayList;

public class Livros {
    private String titulo;
    private String sub;
    private ArrayList<String> autores;
    private String distribuidora;
    private String dataDistrib;
    private String descricao;
    private int qntPages;
    private String thumb;
    private String linkPre;
    private String infoLink;
    private String linkCompra;

    public Livros(String titulo, String sub, ArrayList<String> autores, String distribuidora, String dataDistrib, String descricao, int qntPages, String thumb, String linkPre, String infoLink, String linkCompra) {
        this.titulo = titulo;
        this.sub = sub;
        this.autores = autores;
        this.distribuidora = distribuidora;
        this.dataDistrib = dataDistrib;
        this.descricao = descricao;
        this.qntPages = qntPages;
        this.thumb = thumb;
        this.linkPre = linkPre;
        this.infoLink = infoLink;
        this.linkCompra = linkCompra;
    }

    public Livros(String titulo, String sub, ArrayList<String> autores, String distribuidora, String dataDistrib, String descricao, int qntPages, String linkPre, String infoLink, String linkCompra) {
        this.titulo = titulo;
        this.sub = sub;
        this.autores = autores;
        this.distribuidora = distribuidora;
        this.dataDistrib = dataDistrib;
        this.descricao = descricao;
        this.qntPages = qntPages;
        this.linkPre = linkPre;
        this.infoLink = infoLink;
        this.linkCompra = linkCompra;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getSub() {
        return sub;
    }

    public void setSub(String sub) {
        this.sub = sub;
    }

    public ArrayList<String> getAutores() {
        return autores;
    }

    public void setAutores(ArrayList<String> autores) {
        this.autores = autores;
    }

    public String getDistribuidora() {
        return distribuidora;
    }

    public void setDistribuidora(String distribuidora) {
        this.distribuidora = distribuidora;
    }

    public String getDataDistrib() {
        return dataDistrib;
    }

    public void setDataDistrib(String dataDistrib) {
        this.dataDistrib = dataDistrib;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getQntPages() {
        return qntPages;
    }

    public void setQntPages(int qntPages) {
        this.qntPages = qntPages;
    }

    public String getThumb() {
        return thumb;
    }

    public void setThumb(String thumb) {
        this.thumb = thumb;
    }

    public String getLinkPre() {
        return linkPre;
    }

    public void setLinkPre(String linkPre) {
        this.linkPre = linkPre;
    }

    public String getInfoLink() {
        return infoLink;
    }

    public void setInfoLink(String infoLink) {
        this.infoLink = infoLink;
    }

    public String getLinkCompra() {
        return linkCompra;
    }

    public void setLinkCompra(String linkCompra) {
        this.linkCompra = linkCompra;
    }
}
