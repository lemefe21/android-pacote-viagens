package br.com.fleme.pacoteviagens.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import java.util.List;

import br.com.fleme.pacoteviagens.R;
import br.com.fleme.pacoteviagens.dao.PacoteDAO;
import br.com.fleme.pacoteviagens.model.Pacote;
import br.com.fleme.pacoteviagens.ui.adapter.ListaPacotesAdapter;

public class ListaPacotesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_pacotes);

        setTitle("Pacotes");

        ListView listaDePacotes = findViewById(R.id.lista_pacotes_listview);

        List<Pacote> pacotes = new PacoteDAO().lista();

        listaDePacotes.setAdapter(new ListaPacotesAdapter(pacotes, this));

    }
}
