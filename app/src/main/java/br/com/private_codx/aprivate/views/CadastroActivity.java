package br.com.private_codx.aprivate.views;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import br.com.private_codx.aprivate.R;

public class CadastroActivity extends AppCompatActivity {
    Toolbar aToolbar; //Declarando a Toolbar
    EditText editEmail;
    EditText editSenha;
    EditText editConfirmar;
    CheckBox chkTermos;
    String TAG;
    EditText editNome;

    String email;
    String senha;
    String confirmarSenha;
    String nome;


    private FirebaseAuth mAuth; //Declarando a instância de Auth do FireBase

    private FirebaseAuth.AuthStateListener mAuthListener; //Configurando um AuthStateListener que
                                                          // responda a alterações no estado de login do usuário


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        //Toolbar
        aToolbar = (Toolbar)findViewById(R.id.toolbar_cadastro);
        setSupportActionBar(aToolbar);

        editNome = (EditText) findViewById(R.id.editNome);
        editEmail = (EditText) findViewById(R.id.editEmail);
        editSenha = (EditText) findViewById(R.id.editSenha);
        editConfirmar = (EditText) findViewById(R.id.editConfirmar);
        chkTermos = (CheckBox) findViewById(R.id.chkTermos);

        mAuth = FirebaseAuth.getInstance(); //Obtendo a instância de Auth do FireBase,


        //Inicio do rolê de mostrar no Log
        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    // User is signed in
                    Log.d(TAG, "onAuthStateChanged:signed_in:" + user.getUid());
                } else {
                    // User is signed out
                    Log.d(TAG, "onAuthStateChanged:signed_out");
                }
                // ...
            }
        };
        //fim do rolê de mostrar no log

    }


    @Override
    public void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }

    @Override
    public void onStop() {
        super.onStop();
        if (mAuthListener != null) {
            mAuth.removeAuthStateListener(mAuthListener);
        }
    }

    public void cadastrarUser (View v){
        nome=editNome.getText().toString();
        email=editEmail.getText().toString();
        senha=editSenha.getText().toString();
        confirmarSenha=editConfirmar.getText().toString();

        if(senha!=confirmarSenha){
            Toast.makeText(getApplicationContext(),"As senhas são diferentes!",Toast.LENGTH_LONG).show();
        }

    }

}
