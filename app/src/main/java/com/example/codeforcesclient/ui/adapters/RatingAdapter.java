package com.example.codeforcesclient.ui.adapters;

import android.annotation.SuppressLint;
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
    private UserClickListener mUserClickListener;

    public RatingAdapter(List<User> aUsers, UserClickListener aListener) {
        mUserClickListener = aListener;
        mUsers = aUsers;
    }

    public class UserViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView name;
        TextView value;
        private UserClickListener mUserClickListener;

        UserViewHolder(@NonNull View itemView, UserClickListener aUserClickListener) {
            super(itemView);
            name = itemView.findViewById(R.id.user_name_rated_list_tv);
            value = itemView.findViewById(R.id.rating_user_value_tv);
            mUserClickListener = aUserClickListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            mUserClickListener.onUserSelected(mUsers.get(getAdapterPosition()));
        }
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View userView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.user_rated_view_holder, parent, false);
        return new UserViewHolder(userView, mUserClickListener);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        User user = mUsers.get(position);
        holder.name.setText(user.getHandle());
        holder.value.setText(Integer.toString(user.getRating()));
    }

    @Override
    public int getItemCount() {
        return mUsers.size();
    }

    public void setUsers(List<User> aUsers) {
        mUsers = aUsers;
    }
}
