package com.adtracker.activity;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.adtracker.R;

public class CadastroLojaActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private FloatingActionButton fabGravar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_loja);

        this.configComponentes();
        this.configTela();

    }

    private void configComponentes() {
        this.toolbar = (Toolbar) findViewById(R.id.toolbar);
        this.fabGravar = (FloatingActionButton) findViewById(R.id.fab_gravar);
    }

    private void configTela() {
        setSupportActionBar(toolbar);
        setTitle("Cadastro de Loja");

        this.configAcoes();

    }

    private void configAcoes() {
        fabGravar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CadastroLojaActivity.this, MainActivity.class));
            }
        });
    }

}
