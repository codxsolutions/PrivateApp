package br.com.private_codx.aprivate.models;

/**
 * Created by Felipe on 31/03/2017.
 */

public class Pergunta {

    private long id_pergunta;
    private String conteudo_pergunta;
    private int pontuação;
    private Usuario usuario;

    public long getId_pergunta() {
        return id_pergunta;
    }

    public void setId_pergunta(long id_pergunta) {
        this.id_pergunta = id_pergunta;
    }

    public String getConteudo_pergunta() {
        return conteudo_pergunta;
    }

    public void setConteudo_pergunta(String conteudo_pergunta) {
        this.conteudo_pergunta = conteudo_pergunta;
    }

    public int getPontuação() {
        return pontuação;
    }

    public void setPontuação(int pontuação) {
        this.pontuação = pontuação;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
