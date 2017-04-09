package br.com.private_codx.aprivate.views;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.view.View;
import br.com.private_codx.aprivate.presenters.PerguntaPresenter;


import br.com.private_codx.aprivate.R;

public class FazerPergunta extends AppCompatActivity {
    Toolbar aToolbar; //Declarando a Toolbar
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
        setContentView(R.layout.fazer_pergunta);

        //Toolbar
        aToolbar = (Toolbar)findViewById(R.id.toolbar_perguntar);
        setSupportActionBar(aToolbar);

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



    //MENU
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.act_config) {
            //ação
            return true;
        }
        if (id == R.id.act_sobre) {
            //ação
            return true;
        }
        if (id == R.id.act_sair) {
            //ação
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
