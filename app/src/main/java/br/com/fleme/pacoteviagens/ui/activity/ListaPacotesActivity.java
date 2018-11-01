package br.com.fleme.pacoteviagens.ui.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.List;

import br.com.fleme.pacoteviagens.R;
import br.com.fleme.pacoteviagens.dao.PacoteDAO;
import br.com.fleme.pacoteviagens.model.Pacote;
import br.com.fleme.pacoteviagens.ui.adapter.ListaPacotesAdapter;

public class ListaPacotesActivity extends AppCompatActivity {

    public static final String TITULO_APPBAR = "Pacotes";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_pacotes);
        
        setTitle(TITULO_APPBAR);
        
        //Ctrl+Alt+F >> extrai valor como variavel
        //Ctrl+Alt+C >> extrai valor como constante


        configuraLista();

        //Ctrl+Alt+M >> extrai método

        //Alt+Shift+F10 >> Run
        //Shift+F10 >> Run

        //Intent intent = new Intent(this, ResumoPacoteActivity.class);
        //startActivity(intent);

    }

    private void configuraLista() {
        ListView listaDePacotes = findViewById(R.id.lista_pacotes_listview);
        final List<Pacote> pacotes = new PacoteDAO().lista();
        listaDePacotes.setAdapter(new ListaPacotesAdapter(pacotes, this));

        listaDePacotes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Pacote pacoteClicado = pacotes.get(position);

                Intent intent = new Intent(ListaPacotesActivity.this, ResumoPacoteActivity.class);
                intent.putExtra("pacote",pacoteClicado);
                startActivity(intent);
            }
        });

    }

}
