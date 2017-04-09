package br.com.private_codx.aprivate.views;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import br.com.private_codx.aprivate.R;

public class CadastroActivity extends AppCompatActivity {
    Toolbar aToolbar; //Declarando a Toolbar

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        //Toolbar
        aToolbar = (Toolbar)findViewById(R.id.toolbar_cadastro);
        setSupportActionBar(aToolbar);
    }
}
