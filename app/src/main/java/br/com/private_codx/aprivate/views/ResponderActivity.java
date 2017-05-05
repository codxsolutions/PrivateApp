package br.com.private_codx.aprivate.views;
/**
 * Created by Thiago on 03/05/2017.
 */
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import br.com.private_codx.aprivate.R;

public class ResponderActivity extends AppCompatActivity {
    //Variáveis
    private Toolbar aToolbar; //Declarando a Toolbar
    //Contador de caracteres limite
    private TextView txtMensagem;
    private int contCaracteres = 150;
    private EditText editResposta;
    private Button btnEnviar;
    private String conteudo = "";
    private int tamanho = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_responder);

        //Toolbar
        aToolbar = (Toolbar) findViewById(R.id.toolbar_responder);
        setSupportActionBar(aToolbar);

        //CExibindo quantidade de caracteres
        txtMensagem = (TextView) findViewById(R.id.txtMensagem);
        txtMensagem.setText("" + contCaracteres + " Caracteres disponíveis");
        editResposta = (EditText) findViewById(R.id.editResposta);
        btnEnviar = (Button) findViewById(R.id.btnEnviarResposta);
    }

    //listener de quantidade de caracteres
    TextWatcher onSearchFieldTextChanged = new TextWatcher() {
        public void afterTextChanged(Editable s) {

        }

        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        public void onTextChanged(CharSequence s, int start, int before, int count) {
            int quantidade = editResposta.getText().length();
            int atual = contCaracteres - quantidade;

            if (atual > 0) {
                String valor = String.valueOf(atual);
                txtMensagem.setText(valor + " Caracteres disponíveis");
                txtMensagem.setTextColor(Color.rgb(255, 255, 255));
            } else if (atual == 0) {
                txtMensagem.setText("Quantidade máxima de caracteres");
                txtMensagem.setTextColor(Color.rgb(255, 255, 255));
                conteudo = editResposta.getText().toString();
            } else {
                editResposta.setText(conteudo);
                txtMensagem.setTextColor(Color.rgb(255, 0, 0));
                txtMensagem.setText("Quantidade máxima de caracteres excedida!");
            }

        }
    };
    // fim do listener





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
