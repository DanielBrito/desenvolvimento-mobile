package com.example.teste2;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class SumAdapter extends RecyclerView.Adapter<SumHolder> {

    private final List<Operation> mOperations;

    public SumAdapter(ArrayList operations) {
        mOperations = operations;
    }

    @Override
    public SumHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return new SumHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.sum_recycler, parent, false));
    }

    @Override
    public void onBindViewHolder(SumHolder holder, int position) {

        holder.tvN1.setText(String.format(Locale.getDefault(), "%d", mOperations.get(position).getN1()));
        holder.tvN2.setText(String.format(Locale.getDefault(), "%d", mOperations.get(position).getN2()));
        holder.tvN3.setText(String.format(Locale.getDefault(), "%d", mOperations.get(position).getN3()));
        holder.tvN4.setText(String.format(Locale.getDefault(), "%d", mOperations.get(position).getN4()));
    }

    @Override
    public int getItemCount() {
        return mOperations != null ? mOperations.size() : 0;
    }

    public void insertItem(Operation operation) {

        mOperations.add(operation);
        notifyItemInserted(getItemCount());
    }
}
