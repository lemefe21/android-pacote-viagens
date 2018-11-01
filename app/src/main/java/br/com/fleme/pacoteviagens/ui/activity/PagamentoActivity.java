package br.com.fleme.pacoteviagens.ui.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

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
        //Pacote pacoteSaoPaulo = new Pacote("São Paulo", "sao_paulo_sp", 2, new BigDecimal("243.99"));

        Intent intent = getIntent();
        if(intent.hasExtra("pacote")) {

            final Pacote pacote = (Pacote) intent.getSerializableExtra("pacote");

            mostraPreco(pacote);

            //Intent intent = new Intent(this, ResumoCompraActivity.class);
            //startActivity(intent);

            Button botaoFinalizaCompra = findViewById(R.id.pagamento_btn_finaliza_compra);
            botaoFinalizaCompra.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(PagamentoActivity.this, ResumoCompraActivity.class);
                    intent.putExtra("pacote", pacote);
                    startActivity(intent);
                }
            });
        }

    }

    private void mostraPreco(Pacote pacote) {
        TextView preco = findViewById(R.id.pagamento_preco_pacote);
        String moedaBrasileira = MoedaUtil.formataMoedaParaPtBr(pacote.getPreco());
        preco.setText(moedaBrasileira);
    }
}
