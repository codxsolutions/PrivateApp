package br.com.private_codx.aprivate.presenters;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

import br.com.private_codx.aprivate.models.Pergunta;
import br.com.private_codx.aprivate.models.Usuario;

/**
 * Created by Felipe on 05/04/2017.
 */

public class PerguntaPresenter {

    private final String perguntasRef = "Perguntas";

    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference minhaReferencia = database.getReference(perguntasRef);

    public void inserirPerguntaNaDatabase(String conteudo_pergunta){
        minhaReferencia.goOnline();

        String chave = minhaReferencia.child("perguntasRef").push().getKey();

        Pergunta pergunta = new Pergunta(conteudo_pergunta);

        Map<String, Object> valoresPergunta = pergunta.toMapAdicionarPerguntaSemUsuario();

        Map<String, Object> atualizarValoresDaPerguntaNova = new HashMap<>();

        atualizarValoresDaPerguntaNova.put(chave, valoresPergunta);

        minhaReferencia.updateChildren(atualizarValoresDaPerguntaNova);
    }
}
