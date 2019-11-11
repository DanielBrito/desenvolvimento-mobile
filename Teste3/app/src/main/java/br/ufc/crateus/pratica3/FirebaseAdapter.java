package br.ufc.crateus.pratica3;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class FirebaseAdapter extends RecyclerView.Adapter<FirebaseHolder> {

    private final List<Firebase> mUsers;

    public FirebaseAdapter(ArrayList operations) {
        mUsers = operations;
    }

    @Override
    public FirebaseHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return new FirebaseHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.firebase_recycler, parent, false));
    }

    @Override
    public void onBindViewHolder(FirebaseHolder holder, int position) {

        holder.tvUserPass.setText(String.format(Locale.getDefault(), "%s", mUsers.get(position).getUserPass()));
    }

    @Override
    public int getItemCount() {
        return mUsers != null ? mUsers.size() : 0;
    }

    public void insertItem(Firebase user) {

        mUsers.add(user);
        notifyItemInserted(getItemCount());
    }
}
