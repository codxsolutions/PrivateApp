package br.com.private_codx.aprivate;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ActivityPrincipal extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        Button btnPerguntas = (Button) findViewById(R.id.btnPerguntas);
        btnPerguntas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(getApplicationContext(), PerguntasActivity.class);
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


    }
}
