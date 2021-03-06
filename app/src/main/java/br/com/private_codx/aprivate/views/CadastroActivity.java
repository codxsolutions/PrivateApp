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

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import br.com.private_codx.aprivate.R;

import static android.R.attr.password;

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
        email=editEmail.getText().toString();
        senha=editSenha.getText().toString();
        confirmarSenha=editConfirmar.getText().toString();

        //FAZER A VALIDÇÃO (NÃO ESQUECER MONGOLZINHO)
            mAuth.createUserWithEmailAndPassword(email, senha).addOnCompleteListener(this, new OnCompleteListener<AuthResult>(){
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    Log.d(TAG, "createUserWithEmail:onComplete:" + task.isSuccessful());
                    //Em caso de erro.
                    if (!task.isSuccessful()) {
                        Toast.makeText(getApplicationContext(),"Falha ao cadastrar",Toast.LENGTH_SHORT).show();
                    }
                    else{
                        Toast.makeText(getApplicationContext(),"Cadastro realizado com sucesso!",Toast.LENGTH_SHORT).show();
                    }
                }
            });
    }
}
