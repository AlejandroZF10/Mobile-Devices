package com.example.fragment3;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class Grupo{
    private String de, asunto,texto;
    public Grupo(String de, String as, String te){
        this.de = de;
        this.asunto = as;
        this.texto = te;
    }
    public String getDe(){
        return de;
    }
    public String getAsunto(){
        return asunto;
    }
    public String getTexto(){
        return texto;
    }
}
