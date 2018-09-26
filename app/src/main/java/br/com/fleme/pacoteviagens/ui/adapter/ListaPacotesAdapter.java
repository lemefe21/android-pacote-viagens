package br.com.fleme.pacoteviagens.ui.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

import br.com.fleme.pacoteviagens.R;
import br.com.fleme.pacoteviagens.model.Pacote;

public class ListaPacotesAdapter extends BaseAdapter {

    private final List<Pacote> pacotes;
    private Context context;

    public ListaPacotesAdapter(List<Pacote> pacotes, Context context) {
        this.pacotes = pacotes;
        this.context = context;
    }

    @Override
    public int getCount() {
        return pacotes.size();
    }

    @Override
    public Pacote getItem(int posicao) {
        return pacotes.get(posicao);
    }

    @Override
    public long getItemId(int id) {
        return 0;
    }

    @Override
    public View getView(int posicao, View view, ViewGroup parent) {

        View viewCriada = LayoutInflater.from(context).inflate(R.layout.item_pacote, parent, false);

        Pacote pacote = pacotes.get(posicao);

        TextView local = viewCriada.findViewById(R.id.item_pacote_local);
        local.setText(pacote.getLocal());

        ImageView imagem = viewCriada.findViewById(R.id.item_pacote_imagem);
        Resources resources = context.getResources();
        int idDrawable = resources.getIdentifier(pacote.getImagem(), "drawable", context.getPackageName());
        Drawable drawable = resources.getDrawable(idDrawable);
        imagem.setImageDrawable(drawable);

        TextView dias = viewCriada.findViewById(R.id.item_pacote_dias);
        dias.setText(pacote.getDias() + " dias");

        TextView preco = viewCriada.findViewById(R.id.item_pacote_preco);
        preco.setText("R$ " + pacote.getPreco().toString());

        return viewCriada;
    }

}
