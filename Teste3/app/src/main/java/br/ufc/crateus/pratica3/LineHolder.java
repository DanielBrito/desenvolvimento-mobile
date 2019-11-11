package br.ufc.crateus.pratica3;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class LineHolder extends RecyclerView.ViewHolder {

    public TextView tvUsername;
    public TextView tvPassword;

    public LineHolder(View itemView){

        super(itemView);

        tvUsername = (TextView)itemView.findViewById(R.id.tvUsername);
        tvPassword = (TextView)itemView.findViewById(R.id.tvPassword);
    }
}
