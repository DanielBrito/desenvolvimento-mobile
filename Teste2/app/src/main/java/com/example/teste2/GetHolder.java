package com.example.teste2;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class GetHolder extends RecyclerView.ViewHolder {

    public TextView tvName;
    public TextView tvEmail;

    public GetHolder(View itemView) {

        super(itemView);

        tvName = (TextView) itemView.findViewById(R.id.tvName);
        tvEmail = (TextView) itemView.findViewById(R.id.tvEmail);
    }
}
