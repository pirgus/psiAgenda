package com.example.psiagenda.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.psiagenda.R;
import com.example.psiagenda.controllers.SignUpPacienteController;

public class CadastroPaciente extends AppCompatActivity {

    private Button btCadastro;
    private TextView btJaConta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_paciente);

        btCadastro = findViewById(R.id.btCadastroPac);
        btJaConta = findViewById(R.id.jaContaPac);

        btCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SignUpPacienteController control = new SignUpPacienteController(CadastroPaciente.this);
                control.recuperarDadosPaciente();
                control.criarContaPaciente();
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