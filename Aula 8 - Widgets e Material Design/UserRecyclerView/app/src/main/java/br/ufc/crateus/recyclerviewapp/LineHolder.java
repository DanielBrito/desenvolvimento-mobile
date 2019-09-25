package br.ufc.crateus.recyclerviewapp;

import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class LineHolder extends RecyclerView.ViewHolder {

    public TextView recycler_nome;
    public TextView recycler_idade;
    public TextView recycler_cidade;
    public ImageButton deleteButton;

    public LineHolder(View itemView) {
        super(itemView);
        recycler_nome = (TextView) itemView.findViewById(R.id.recycler_nome);
        recycler_idade = (TextView) itemView.findViewById(R.id.recycler_idade);
        recycler_cidade = (TextView) itemView.findViewById(R.id.recycler_cidade);
        deleteButton = (ImageButton) itemView.findViewById(R.id.recycler_delete);
    }
}