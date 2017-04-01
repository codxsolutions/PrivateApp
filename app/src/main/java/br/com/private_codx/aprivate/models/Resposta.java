package br.com.private_codx.aprivate.models;

/**
 * Created by Felipe on 31/03/2017.
 */

public class Resposta {
    private long id_resposta;
    private long id_pergunta;
    private String conteudo_resposta;
    private Usuario usuario;

    public long getId_resposta() {
        return id_resposta;
    }

    public void setId_resposta(long id_resposta) {
        this.id_resposta = id_resposta;
    }

    public long getId_pergunta() {
        return id_pergunta;
    }

    public void setId_pergunta(long id_pergunta) {
        this.id_pergunta = id_pergunta;
    }

    public String getConteudo_resposta() {
        return conteudo_resposta;
    }

    public void setConteudo_resposta(String conteudo_resposta) {
        this.conteudo_resposta = conteudo_resposta;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
