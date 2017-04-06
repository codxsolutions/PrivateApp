package br.com.private_codx.aprivate.models;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Felipe on 31/03/2017.
 */

public class Pergunta {

    private String id_pergunta;
    private String conteudo_pergunta;
    private int pontuação;
    private Usuario usuario = new Usuario();

    public Pergunta(){

    }

    public Pergunta(String id_pergunta, String conteudo_pergunta, int pontuação, Usuario usuario){
        this.id_pergunta = id_pergunta;
        this.conteudo_pergunta = conteudo_pergunta;
        this.pontuação = pontuação;
        this.usuario = usuario;
    }

    public Pergunta(String id_pergunta, String conteudo_pergunta, Usuario usuario){
        this.id_pergunta = id_pergunta;
        this.conteudo_pergunta = conteudo_pergunta;
        this.usuario = usuario;
    }

    public Pergunta(String conteudo_pergunta, Usuario usuario){
        this.conteudo_pergunta = conteudo_pergunta;
        this.usuario = usuario;
    }

    public Pergunta(String conteudo_pergunta){
        this.conteudo_pergunta = conteudo_pergunta;
    }

    public Map<String, Object> toMapAdicionarPergunta(){
        HashMap<String, Object> resultado = new HashMap<>();

        resultado.put("conteudo_pergunta", conteudo_pergunta);
        resultado.put("usuario", usuario.getId_usuario());

        return resultado;
    }

    public Map<String, Object> toMapAdicionarPerguntaSemUsuario(){
        HashMap<String, Object> resultado = new HashMap<>();

        resultado.put("conteudo_pergunta", conteudo_pergunta);

        return resultado;
    }

    public Map<String, Object> toMapAdicionarPerguntaComPontuacao(){
        HashMap<String, Object> resultado = new HashMap<>();

        resultado.put("id_pergunta", id_pergunta);
        resultado.put("conteudo_pergunta", conteudo_pergunta);
        resultado.put("usuario", usuario.getId_usuario());
        resultado.put("pontucao", pontuação);

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

    public Usuario getUsuario() {
        return usuario;
    }
}
