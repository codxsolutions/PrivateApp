package br.com.private_codx.aprivate.presenters;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.private_codx.aprivate.models.Pergunta;
import br.com.private_codx.aprivate.models.Usuario;

/**
 * Created by Felipe on 05/04/2017.
 */

public class PerguntaPresenter {

    private final String perguntasRef = "Perguntas";

    private FirebaseDatabase database = FirebaseDatabase.getInstance(); // obtem a dataBase do firebase
    private DatabaseReference minhaReferencia = database.getReference(perguntasRef); // obtem a referência 'Perguntas' da dataBase

    public void inserirPerguntaNaDatabase(String conteudo_pergunta, List<String> tags, boolean valorChave){
        // metodo que recebe como parametro os valores da tela
        minhaReferencia.goOnline();

        String idFirebase = minhaReferencia.child("perguntasRef").push().getKey(); // obtem um id randon do firebase

        // instância um objeto do tipo pergunta e passa no construtor os valores
        Pergunta pergunta = new Pergunta(tags, valorChave, conteudo_pergunta);

        // cria um mapa com chave(String) e valor (object) e atribui o mapa definido na classe Pergunta
        Map<String, Object> valoresPergunta = pergunta.toMapAdicionarPergunta();

        // cria um Hash que vai ser responsável por cruzar chave e valor
        Map<String, Object> salvarValoresDaPerguntaNova = new HashMap<>();

        /* usa o metodo put() para passar pro Hash o id obtido do firebase

        */
        salvarValoresDaPerguntaNova.put(idFirebase, valoresPergunta);

        minhaReferencia.updateChildren(salvarValoresDaPerguntaNova);
    }
}
