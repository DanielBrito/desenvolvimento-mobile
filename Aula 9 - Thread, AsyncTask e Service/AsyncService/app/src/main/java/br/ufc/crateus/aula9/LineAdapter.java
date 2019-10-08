package br.ufc.crateus.aula9;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class LineAdapter extends RecyclerView.Adapter<LineHolder> {

    private final List<User> mUsers;

    public LineAdapter(ArrayList users) {
        mUsers = users;
    }

    @Override
    public LineHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new LineHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.customrecycler, parent, false));
    }

    @Override
    public void onBindViewHolder(LineHolder holder, int position) {
        holder.name.setText(mUsers.get(position).getNome());
        holder.email.setText(mUsers.get(position).getEmail());
    }
    public void insertItem(String nome, String email) {
        mUsers.add(new User(nome, email));
        notifyItemInserted(getItemCount());
    }
    @Override
    public int getItemCount() {
        return mUsers != null ? mUsers.size() : 0;
    }


}
