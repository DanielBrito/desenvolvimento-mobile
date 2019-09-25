package br.ufc.crateus.exerciciosocket;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LineAdapter extends RecyclerView.Adapter<LineHolder> {

    private final List<Date> mDates;

    public LineAdapter(ArrayList dates) {
        mDates = dates;
    }

    @Override
    public LineHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new LineHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.customrecycler, parent, false));
    }

    @Override
    public void onBindViewHolder(LineHolder holder, int position) {
        holder.data.setText(mDates.get(position).toString());
    }

    @Override
    public int getItemCount() {
        return mDates != null ? mDates.size() : 0;
    }

    public void updateList(Date date) {
        insertItem(date);
    }

    public void insertItem(Date date) {
        mDates.add(date);
        notifyItemInserted(getItemCount());
    }
}