package com.example.psiagenda.controllers;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.example.psiagenda.view.LoginUsuario;
import com.example.psiagenda.model.Usuario;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.example.psiagenda.R;
import com.google.firebase.auth.FirebaseUser;

public class LoginUsuarioController {

    private final LoginUsuario view;

    private Button bEntrar;

    private TextView tEsqueciSenha;

    private EditText inEmail;
    private EditText inSenha;

    private FirebaseAuth mAuth;
    
    private Usuario u;

    public LoginUsuarioController(LoginUsuario view) {
        this.view = view;
    }

    public void recebeDados() {
        inEmail = view.findViewById(R.id.inEmailLogin);
        inSenha = view.findViewById(R.id.inSenhaLogin);
        
        u = new Usuario();
        u.setEmail(inEmail.getText().toString());
        u.setSenha(inSenha.getText().toString());
    }

    public void realizarLogin() {
        mAuth = FirebaseAuth.getInstance();
        mAuth.signInWithEmailAndPassword(u.getEmail(), u.getSenha())
                .addOnCompleteListener(view, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            // sucesso ao logar, atualiza UI com os dados inseridos
                            FirebaseUser nUser = mAuth.getCurrentUser();
                            u.setId(mAuth.getUid());
                            //u.salvarDados();
                            Toast.makeText(view,
                                    "Sucesso ao acessar conta", Toast.LENGTH_LONG).show();
                            //startActivity(new Intent(LoginUsuario.this, MainActivity.class));
                        }
                        else{
                            // se o login falhar, mostra mensagem de erro
                            Toast.makeText(view,
                                    "Erro ao acessar conta : " + task.getException().getMessage(), Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }
}
