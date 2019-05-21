package com.example.codeforcesclient.ui.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.codeforcesclient.R;
import com.example.codeforcesclient.data.local.model.User;

import java.util.List;

public class RatingAdapter extends RecyclerView.Adapter<RatingAdapter.UserViewHolder> {

    private List<User> mUsers;

    public RatingAdapter(List<User> aUsers) {
        mUsers = aUsers;
    }

    public static class UserViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        TextView value;
        TextView contribution;

        UserViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.user_name_rated_list_tv);
            value = itemView.findViewById(R.id.rating_user_value_tv);
            contribution = itemView.findViewById(R.id.contribution_value_tv);
        }
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View userView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.user_rated_view_holder, parent, false);
        return new UserViewHolder(userView);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        User user = mUsers.get(position);
        holder.name.setText(user.getUserHandle());
        holder.contribution.setText(user.getContribution());
    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
