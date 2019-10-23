package br.ufc.crateus.exerciciodao.ui;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import br.ufc.crateus.exerciciodao.R;
import br.ufc.crateus.exerciciodao.model.Carro;

public class LineAdapter extends RecyclerView.Adapter<LineHolder> {

    private final List<Carro> mCarros;

    public LineAdapter(ArrayList carros){

        mCarros = carros;
    }

    @Override
    public LineHolder onCreateViewHolder(ViewGroup parent, int viewType){

        return new LineHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.custom_recycler, parent, false));
    }

    @Override
    public void onBindViewHolder(LineHolder holder, int position){

        holder.tvId.setText(String.format(Locale.getDefault(), "%d", mCarros.get(position).getId()));
        holder.tvMarca.setText(String.format(Locale.getDefault(), "%s", mCarros.get(position).getMarca()));
        holder.tvModelo.setText(String.format(Locale.getDefault(), "%s", mCarros.get(position).getModelo()));
        holder.tvAno.setText(String.format(Locale.getDefault(), "%d", mCarros.get(position).getAno()));
    }

    @Override
    public int getItemCount() {

        return mCarros != null ? mCarros.size() : 0;
    }

    public void insertItem(Carro carro) {

        mCarros.add(carro);
        notifyItemInserted(getItemCount());
    }

    public void deleteItem(int id){

        mCarros.remove(id);
        notifyItemRemoved(getItemCount());
    }

    public void updateItem(Carro carro) {

        // Implementar
    }
}