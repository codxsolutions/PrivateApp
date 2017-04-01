package br.com.private_codx.aprivate.models;

/**
 * Created by Felipe on 31/03/2017.
 */

public class Categoria {

    private long id_categoria;
    private String  nome_categoria;


    public long getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(long id_categoria) {
        this.id_categoria = id_categoria;
    }

    public String getNome_categoria() {
        return nome_categoria;
    }

    public void setNome_categoria(String nome_categoria) {
        this.nome_categoria = nome_categoria;
    }
}

