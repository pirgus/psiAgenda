package com.example.psiagenda.model;

import com.example.psiagenda.config.ConfiguracaoFirebase;
import com.google.firebase.database.DatabaseReference;

public class UsuarioPsicologo extends Usuario{

    private String crp;

    public String getCrp() {
        return crp;
    }

    public void setCrp(String crp) {
        this.crp = crp;
    }

}
