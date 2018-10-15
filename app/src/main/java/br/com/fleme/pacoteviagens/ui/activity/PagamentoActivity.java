package br.com.fleme.pacoteviagens.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.math.BigDecimal;

import br.com.fleme.pacoteviagens.R;
import br.com.fleme.pacoteviagens.model.Pacote;
import br.com.fleme.pacoteviagens.util.MoedaUtil;

public class PagamentoActivity extends AppCompatActivity {

    public static final String PAGAMENTO = "Pagamento";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagamento);

        setTitle(PAGAMENTO);

        //utilizado para exemplo
        Pacote pacoteSaoPaulo = new Pacote("São Paulo", "sao_paulo_sp", 2, new BigDecimal("243.99"));

        mostraPreco(pacoteSaoPaulo);

    }

    private void mostraPreco(Pacote pacote) {
        TextView preco = findViewById(R.id.pagamento_preco_pacote);
        String moedaBrasileira = MoedaUtil.formataMoedaParaPtBr(pacote.getPreco());
        preco.setText(moedaBrasileira);
    }
}
