package br.ufc.crateus.pratica3;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class LineAdapter extends RecyclerView.Adapter<LineHolder>  {

    private final List<User> mUsers;

    public LineAdapter(ArrayList operations) {
        mUsers = operations;
    }

    @Override
    public LineHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return new LineHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.user_recycler, parent, false));
    }

    @Override
    public void onBindViewHolder(LineHolder holder, int position) {

        holder.tvUsername.setText(String.format(Locale.getDefault(), "%s", mUsers.get(position).getUsername()));
        holder.tvPassword.setText(String.format(Locale.getDefault(), "%s", mUsers.get(position).getPassword()));
    }

    @Override
    public int getItemCount() {
        return mUsers != null ? mUsers.size() : 0;
    }

    public void insertItem(User user) {

        mUsers.add(user);
        notifyItemInserted(getItemCount());
    }
}
