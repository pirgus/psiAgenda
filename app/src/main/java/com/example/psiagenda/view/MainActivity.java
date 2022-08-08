package com.example.psiagenda.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.psiagenda.R;
import com.example.psiagenda.view.CadastroPaciente;
import com.example.psiagenda.view.CadastroPsicologo;

public class MainActivity extends AppCompatActivity {

    private Button entrarPsi;
    private Button entrarPac;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        entrarPsi = findViewById(R.id.botaoSouPsi);
        entrarPac = findViewById(R.id.botaoSouPac);

        entrarPsi.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                telaPsi();
            }
        });

        entrarPac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                telaPac();
            }
        });
    }

    private void telaPac() {
        startActivity(new Intent(this, CadastroPaciente.class));
    }

    private void telaPsi() {
        startActivity(new Intent(this, CadastroPsicologo.class));
    }
}