package br.com.private_codx.aprivate.models;

/**
 * Created by Felipe on 31/03/2017.
 */

public class Usuario {
    private long id_usuario;
    private String nome;
    private String sobrenome;
    private String email;
    private String senha;
    private int cont_perguntas;
    private int cont_respostas;


    public long getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(long id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getCont_perguntas() {
        return cont_perguntas;
    }

    public void setCont_perguntas(int cont_perguntas) {
        this.cont_perguntas = cont_perguntas;
    }

    public int getCont_respostas() {
        return cont_respostas;
    }

    public void setCont_respostas(int cont_respostas) {
        this.cont_respostas = cont_respostas;
    }
}
