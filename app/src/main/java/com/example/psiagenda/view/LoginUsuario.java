package com.example.psiagenda.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.psiagenda.R;
import com.example.psiagenda.controllers.LoginUsuarioController;
import com.example.psiagenda.model.UsuarioPsicologo;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginUsuario extends AppCompatActivity {

    private Button bEntrar;

    private TextView tEsqueciSenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_usuario);

        bEntrar = findViewById(R.id.botaoEntrar);

        tEsqueciSenha = findViewById(R.id.textEsqueciSenha);

        bEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LoginUsuarioController control = new LoginUsuarioController(LoginUsuario.this);
                control.recebeDados();
                control.realizarLogin();
            }
        });

        tEsqueciSenha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}