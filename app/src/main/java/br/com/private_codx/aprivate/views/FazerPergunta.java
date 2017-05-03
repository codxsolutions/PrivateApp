package br.com.private_codx.aprivate.views;
/**
 * Created by Felipe on 31/03/2017.
 */

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.view.View;
import android.widget.Toast;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import br.com.private_codx.aprivate.presenters.PerguntaPresenter;


import br.com.private_codx.aprivate.R;

public class FazerPergunta extends AppCompatActivity {
    //Variáveis
    private Toolbar aToolbar; //Declarando a Toolbar
    private PerguntaPresenter salvar = new PerguntaPresenter();
    private List<CheckBox> checkBoxes = new ArrayList<>();
    private List<String> tagSelecionadas = new ArrayList<>();
    private Button btnEnviar;
    private Button btnCancelar;
    private Switch chaveAnonimo;
    private TextView txtMensagem;
    private EditText edtPerguntaView;
    private int contCaracteres = 150;
    private int tamanho = 0;

    //checkboxes
    private CheckBox chkCinema;
    private CheckBox chkEsporte;
    private CheckBox chkMusica;
    private CheckBox chkHumor;
    private CheckBox chkCuriosidade;
    private CheckBox chkSaude;
    private CheckBox chk18;
    private CheckBox chkOutros;
    private String conteudo = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fazer_pergunta);
        //obtendo o tamanho da tela
        int widht = this.getResources().getDisplayMetrics().widthPixels;


        //Toolbar
        aToolbar = (Toolbar) findViewById(R.id.toolbar_perguntar);
        setSupportActionBar(aToolbar);

        edtPerguntaView = (EditText) findViewById(R.id.editPergunta);
        btnEnviar = (Button) findViewById(R.id.btnEnviarPergunta);
        btnCancelar = (Button) findViewById(R.id.btnCancelarPergunta);

        //Pegando o tamanho da tela para montar os botões
        tamanho = 25 * widht / 162; //regra de 3
        if (tamanho > 200) tamanho = 200;//Controle para o tamanho máximo
        btnEnviar.setWidth(tamanho);  //Tamanho
        btnCancelar.setWidth(tamanho);

        chaveAnonimo = (Switch) findViewById(R.id.chaveAnonimo);
        txtMensagem = (TextView) findViewById(R.id.txtMensagem);
        txtMensagem.setText("" + contCaracteres + " Caracteres disponíveis");

        //Macumba Satânica
        chkCinema = (CheckBox) findViewById(R.id.chkCinema);
        chkEsporte = (CheckBox) findViewById(R.id.chkEsporte);
        chkMusica = (CheckBox) findViewById(R.id.chkMusica);
        chkHumor = (CheckBox) findViewById(R.id.chkHumor);
        chkCuriosidade = (CheckBox) findViewById(R.id.chkCuriosidade);
        chkSaude = (CheckBox) findViewById(R.id.chkSaude);
        chk18 = (CheckBox) findViewById(R.id.chk18);
        chkOutros = (CheckBox) findViewById(R.id.chkOutros);
        checkBoxes.add(chkCinema);
        checkBoxes.add(chkEsporte);
        checkBoxes.add(chkMusica);
        checkBoxes.add(chkHumor);
        checkBoxes.add(chkCuriosidade);
        checkBoxes.add(chkSaude);
        checkBoxes.add(chk18);
        checkBoxes.add(chkOutros);
        // Fim macumba

        edtPerguntaView.addTextChangedListener(onSearchFieldTextChanged);
    }

    //listener de quantidade de caracteres
    TextWatcher onSearchFieldTextChanged = new TextWatcher() {
        public void afterTextChanged(Editable s) {

        }

        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        public void onTextChanged(CharSequence s, int start, int before, int count) {
            int quantidade = edtPerguntaView.getText().length();
            int atual = contCaracteres - quantidade;

            if (atual > 0) {
                String valor = String.valueOf(atual);
                txtMensagem.setText(valor + " Caracteres disponíveis");
                txtMensagem.setTextColor(Color.rgb(255, 255, 255));
            } else if (atual == 0) {
                txtMensagem.setText("Quantidade máxima de caracteres");
                txtMensagem.setTextColor(Color.rgb(255, 255, 255));
                conteudo = edtPerguntaView.getText().toString();
            } else {
                edtPerguntaView.setText(conteudo);
                txtMensagem.setTextColor(Color.rgb(255, 0, 0));
                txtMensagem.setText("Quantidade máxima de caracteres excedida!");
            }

        }
    };
    // fim do listener

    public void enviarPergunta(View view) {
        String edtPergunta = edtPerguntaView.getText().toString(); // valor editText
        boolean anonimo = chaveAnonimo.isChecked(); // valor da chave

        //implementando macumba

        //verificando quantos checkBoxes estão selecionados
        int contSelecao = 0;
        for (CheckBox chk : checkBoxes) {
            boolean selecionado = chk.isChecked();
            if (selecionado) {
                contSelecao++;
            }
        }

        if(contSelecao > 3) {
            Toast.makeText(getApplicationContext(), "Selecione somente 3 tags", Toast.LENGTH_SHORT).show();
            tagSelecionadas.clear();
        }

        // verificando se o conteudo da pergunta é igual a ""
        if ("".equals(edtPergunta)) {
            Toast.makeText(getApplicationContext(), "Escreva uma pergunta!", Toast.LENGTH_SHORT).show();
        } else {
            if (contSelecao > 0) { // verificando se existe checkBoxe selecionado
                if (contSelecao < 3) {
                    tagSelecionadas.clear();
                    for (CheckBox chk : checkBoxes) {
                        boolean selecionado = chk.isChecked();
                        if (selecionado) {
                            tagSelecionadas.add(chk.getText().toString()); //valor checkboxes
                        }
                    }

                    if ((edtPergunta != null && edtPergunta != "") && edtPergunta.length() < 150) {
                        salvar.inserirPerguntaNaDatabase(edtPergunta, tagSelecionadas, anonimo);

                        Intent it = new Intent(this, MinhasPerguntasActivity.class);
                        startActivity(it);
                    }
                }
            }else if (contSelecao == 0) {
                Toast.makeText(getApplicationContext(), "Selecione pelo menos 1 tag", Toast.LENGTH_SHORT).show();
                tagSelecionadas.clear();
            }
        }

        // fim da macumba


    }

    public void cancelar(View view) {

        Intent it = new Intent(this, ActivityPrincipal.class);
        startActivity(it);
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
