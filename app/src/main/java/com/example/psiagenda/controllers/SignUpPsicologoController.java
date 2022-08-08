package com.example.psiagenda.controllers;

import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.example.psiagenda.view.CadastroPsicologo;
import com.example.psiagenda.R;
import com.example.psiagenda.config.ConfiguracaoFirebase;
import com.example.psiagenda.model.UsuarioPsicologo;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;

public class SignUpPsicologoController {

    private final CadastroPsicologo view;

    private EditText etNome;
    private EditText etCPF;
    private EditText etTelefone;
    private EditText etEmail;
    private EditText etCRP;
    private EditText etSenha;

    private FirebaseAuth mAuth;

    private UsuarioPsicologo a;
    public SignUpPsicologoController(CadastroPsicologo view) {
        this.view = view;
    }


    public void recuperarDadosPsicologo(){
        a = new UsuarioPsicologo();
        etNome = view.findViewById(R.id.editNomeCompletoPsi);
        etCPF = view.findViewById(R.id.editCPFPsi);
        etTelefone = view.findViewById(R.id.editTelefPsi);
        etEmail = view.findViewById(R.id.editEmailPsi);
        etCRP = view.findViewById(R.id.editCRPPsi);
        etSenha = view.findViewById(R.id.editSenhaPsi);

        if(etNome.getText().toString() == "" || etEmail.getText().toString() == ""||
                etSenha.getText().toString() == "" || etCPF.getText().toString() == "" ||
                etTelefone.getText().toString() == "" || etCRP.getText().toString() == "" ){
            Toast.makeText(this.view, "Os dados não estão preenchidos corretamente!", Toast.LENGTH_LONG).show();
        }
        else{
            a.setNome(etNome.getText().toString());
            a.setEmail(etEmail.getText().toString());
            a.setCpf(etCPF.getText().toString());
            a.setCrp(etCRP.getText().toString());
            a.setSenha(etSenha.getText().toString());
            a.setTelefone(etTelefone.getText().toString());
        }
    }

    public void criarContaPsicologo(){
        mAuth = FirebaseAuth.getInstance();

        mAuth.createUserWithEmailAndPassword(a.getEmail(), a.getSenha())
        .addOnCompleteListener(view, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    FirebaseUser nUser = mAuth.getCurrentUser();
                    a.setId(nUser.getUid());
                    //a.salvarDados();
                    DatabaseReference database = ConfiguracaoFirebase.getFirebaseDatabase();

                    database.child("Usuarios-psicologos").child(a.getId()).setValue(a);
                    Toast.makeText(view,
                            "Sucesso ao cadastrar conta", Toast.LENGTH_LONG).show();
                    view.telaLogin();
                }
                else{
                    Toast.makeText(view,
                            "Erro ao cadastrar conta : " + task.getException().getMessage(), Toast.LENGTH_LONG).show();
                    a.setId(null);
                }
            }
        });
    }

}
