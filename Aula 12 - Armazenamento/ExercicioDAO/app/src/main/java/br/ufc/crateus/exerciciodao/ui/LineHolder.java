package br.ufc.crateus.exerciciodao.ui;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import br.ufc.crateus.exerciciodao.R;

public class LineHolder extends RecyclerView.ViewHolder {

    public TextView tvId;
    public TextView tvMarca;
    public TextView tvModelo;
    public TextView tvAno;

    public LineHolder(View itemView){

        super(itemView);

        tvId = (TextView)itemView.findViewById(R.id.tvId);
        tvMarca = (TextView)itemView.findViewById(R.id.tvMarca);
        tvModelo = (TextView)itemView.findViewById(R.id.tvModelo);
        tvAno = (TextView)itemView.findViewById(R.id.tvAno);
    }
}