package br.com.fleme.pacoteviagens.ui.activity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import br.com.fleme.pacoteviagens.R;
import br.com.fleme.pacoteviagens.model.Pacote;
import br.com.fleme.pacoteviagens.util.DataUtil;
import br.com.fleme.pacoteviagens.util.DiasUtil;
import br.com.fleme.pacoteviagens.util.MoedaUtil;
import br.com.fleme.pacoteviagens.util.ResourceUtil;

public class ResumoPacoteActivity extends AppCompatActivity {

    public static final String TITULO_APPBAR = "Resumo do pacote";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumo_pacote);

        setTitle(TITULO_APPBAR);

        //utilizado para exemplo
        //Pacote pacoteSaoPaulo = new Pacote("São Paulo", "sao_paulo_sp", 2, new BigDecimal("243.99"));

        Intent intent = getIntent();

        if(intent.hasExtra("pacote")) {

            final Pacote pacote = (Pacote) intent.getSerializableExtra("pacote");

            //processo de bind
            mostraImagem(pacote);
            mostraLocal(pacote);
            mostraDias(pacote);
            mostraPreco(pacote);
            mostraData(pacote);

            //Intent intent = new Intent(this, PagamentoActivity.class);
            //startActivity(intent);

            Button botaoRealizaPagamento = findViewById(R.id.resumo_pacote_btn_pagamento);
            botaoRealizaPagamento.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(ResumoPacoteActivity.this, PagamentoActivity.class);
                    intent.putExtra("pacote", pacote);
                    startActivity(intent);
                }
            });
        }

    }

    private void mostraData(Pacote pacote) {
        TextView data = findViewById(R.id.resumo_pacote_data);

        String dataFormatadaViagem = DataUtil.periodoEmTexto(pacote.getDias());

        data.setText(dataFormatadaViagem);
    }

    private void mostraPreco(Pacote pacote) {
        TextView preco = findViewById(R.id.resumo_pacote_preco);
        String moedaBrasileira = MoedaUtil.formataMoedaParaPtBr(pacote.getPreco());
        preco.setText(moedaBrasileira);
    }

    private void mostraDias(Pacote pacote) {
        TextView dias = findViewById(R.id.resumo_pacote_dias);
        String diasEmTexto = DiasUtil.formataEmTexto(pacote.getDias());
        dias.setText(diasEmTexto);
    }

    private void mostraImagem(Pacote pacote) {
        ImageView imagem = findViewById(R.id.resumo_pacote_imagem);
        Drawable drawable = ResourceUtil.retornaDrawable(this, pacote.getImagem());
        imagem.setImageDrawable(drawable);
    }

    private void mostraLocal(Pacote pacote) {
        TextView local = findViewById(R.id.resumo_pacote_local);
        local.setText(pacote.getLocal());
    }

}
