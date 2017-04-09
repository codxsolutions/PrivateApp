package br.com.private_codx.aprivate.views;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import br.com.private_codx.aprivate.R;

public class MinhasPerguntasActivity extends AppCompatActivity {
    Toolbar aToolbar; //Declarando a Toolbar

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_minhas_perguntas);

        //Toolbar
        aToolbar = (Toolbar)findViewById(R.id.toolbar_minhasPerguntas);
        setSupportActionBar(aToolbar);
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
