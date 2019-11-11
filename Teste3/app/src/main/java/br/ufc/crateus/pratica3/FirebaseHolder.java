package br.ufc.crateus.pratica3;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class FirebaseHolder extends RecyclerView.ViewHolder{

    public TextView tvUserPass;

    public FirebaseHolder(View itemView){

        super(itemView);

        tvUserPass = (TextView)itemView.findViewById(R.id.tvUserPass);
    }
}
