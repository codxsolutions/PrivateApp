package br.com.private_codx.aprivate.views;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import br.com.private_codx.aprivate.R;

public class ActivityPrincipal extends AppCompatActivity {
    Toolbar aToolbar; //Declarando a Toolbar

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);


        //Toolbar
        aToolbar = (Toolbar)findViewById(R.id.toolbar_principal);
        setSupportActionBar(aToolbar);

        //Botões
        Button btnPerguntas = (Button) findViewById(R.id.btnPerfil);
        btnPerguntas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(getApplicationContext(), PerfilActivity.class);
                startActivity(it);
            }
        });

        Button btnPesquisa = (Button) findViewById(R.id.btnPesquisa);
        btnPesquisa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(getApplicationContext(), ActivityPesquisa.class);
                startActivity(it);
            }
        });

        Button btnPerguntar = (Button) findViewById(R.id.btnPerguntar);
        btnPerguntar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(getApplicationContext(), FazerPergunta.class);
                startActivity(it);
            }
        });

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
