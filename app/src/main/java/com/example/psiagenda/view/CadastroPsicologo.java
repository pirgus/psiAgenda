package com.example.psiagenda.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.psiagenda.R;
import com.example.psiagenda.controllers.SignUpPsicologoController;
import com.example.psiagenda.model.UsuarioPsicologo;
import com.google.firebase.auth.FirebaseAuth;

public class CadastroPsicologo extends AppCompatActivity {

    private Button btCadastro;
    private TextView btJaConta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_psicologo);

        btCadastro = findViewById(R.id.botaoCadastro);
        btJaConta = findViewById(R.id.textJaConta);

        btCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SignUpPsicologoController control = new SignUpPsicologoController(CadastroPsicologo.this);
                control.recuperarDadosPsicologo();
                control.criarContaPsicologo();
            }
        });

        btJaConta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                telaLogin();
            }
        });
    }

    public void telaLogin() {
        startActivity(new Intent(this, LoginUsuario.class));
    }

}