package br.com.private_codx.aprivate.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Felipe on 31/03/2017.
 */

public class Pergunta {

    private String id_pergunta;
    private String conteudo_pergunta;
    private int pontuação;
    private boolean anonimo;
    private List<String> tags = new ArrayList<>();
    private Usuario usuario = new Usuario();

    public Pergunta(){

    }

    public Pergunta(List<String> tags, boolean anonimo, String conteudo_pergunta) {
        this.tags = tags;
        this.anonimo = anonimo;
        this.conteudo_pergunta = conteudo_pergunta;
    }

    public Map<String, Object> toMapAdicionarPergunta(){
        HashMap<String, Object> resultado = new HashMap<>();

        resultado.put("conteudo_pergunta", conteudo_pergunta);
        resultado.put("anonimo", anonimo);
        resultado.put("tags", tags);

        return resultado;
    }

    public String getId_pergunta() {
        return id_pergunta;
    }

    public String getConteudo_pergunta() {
        return conteudo_pergunta;
    }

    public int getPontuação() {
        return pontuação;
    }

    public boolean isAnonimo() {
        return anonimo;
    }

    public List<String> getTags() {
        return tags;
    }

    public Usuario getUsuario() {
        return usuario;
    }
}
