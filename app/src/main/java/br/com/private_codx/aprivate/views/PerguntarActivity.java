package br.com.private_codx.aprivate.views;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.view.View;
import br.com.private_codx.aprivate.presenters.PerguntaPresenter;


import br.com.private_codx.aprivate.R;

public class PerguntarActivity extends AppCompatActivity {

    PerguntaPresenter salvar = new PerguntaPresenter();
    private String edtPergunta;
    private Button btnEnviar;
    private Button btnCancelar;
    private Switch switchPrivado;
    private TextView txtxMensagem;
    private EditText edtPerguntaView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pergunta);
        edtPerguntaView = (EditText) findViewById(R.id.edtPerguntar);
        btnEnviar = (Button) findViewById(R.id.btnEnviarPergunta);
        btnCancelar = (Button) findViewById(R.id.btnCancelarPergunta);
        switchPrivado = (Switch) findViewById(R.id.switchPrivado);
        txtxMensagem = (TextView) findViewById(R.id.txtvMensagem);


    }

    public void enviarPergunta(View view){
        edtPergunta = edtPerguntaView.getText().toString();


        if(edtPergunta != null && edtPergunta.length() < 150){
            salvar.inserirPerguntaNaDatabase(edtPergunta);
        }
    }
}
