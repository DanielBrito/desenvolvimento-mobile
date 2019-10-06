package com.example.teste2;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class GetAdapter extends RecyclerView.Adapter<GetHolder> {

    private final List<User> mUsers;

    public GetAdapter(ArrayList users) {
        mUsers = users;
    }

    @Override
    public GetHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return new GetHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.get_recycler, parent, false));
    }

    @Override
    public void onBindViewHolder(GetHolder holder, int position) {

        holder.tvName.setText(String.format(Locale.getDefault(), "%s", mUsers.get(position).getName()));
        holder.tvEmail.setText(String.format(Locale.getDefault(), "%s", mUsers.get(position).getEmail()));
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
