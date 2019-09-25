package br.ufc.crateus.recyclerviewapp;

import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class LineHolder extends RecyclerView.ViewHolder {

    public TextView title;
    public ImageButton moreButton;
    public ImageButton deleteButton;

    public LineHolder(View itemView) {

        super(itemView);
        title = (TextView) itemView.findViewById(R.id.recycler_text);
        moreButton = (ImageButton) itemView.findViewById(R.id.recycler_more);
        deleteButton = (ImageButton) itemView.findViewById(R.id.recycler_delete);
    }
}