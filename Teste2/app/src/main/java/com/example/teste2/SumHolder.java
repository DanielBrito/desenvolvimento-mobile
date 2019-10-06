package com.example.teste2;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class SumHolder extends RecyclerView.ViewHolder {

    public TextView tvN1;
    public TextView tvN2;
    public TextView tvN3;
    public TextView tvN4;

    public SumHolder(View itemView) {

        super(itemView);

        tvN1 = (TextView)itemView.findViewById(R.id.tvN1);
        tvN2 = (TextView)itemView.findViewById(R.id.tvN2);
        tvN3 = (TextView)itemView.findViewById(R.id.tvN3);
        tvN4 = (TextView)itemView.findViewById(R.id.tvN4);
    }
}
