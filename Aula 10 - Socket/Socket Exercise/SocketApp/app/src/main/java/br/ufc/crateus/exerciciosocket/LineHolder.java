package br.ufc.crateus.exerciciosocket;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class LineHolder extends RecyclerView.ViewHolder {

    public TextView data;

    public LineHolder(View itemView) {
        super(itemView);
        data = (TextView) itemView.findViewById(R.id.data);
    }
}