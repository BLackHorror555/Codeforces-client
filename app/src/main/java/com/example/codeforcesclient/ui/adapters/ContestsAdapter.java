package com.example.codeforcesclient.ui.adapters;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.codeforcesclient.data.local.model.Contest;

import java.util.List;

public class ContestsAdapter extends RecyclerView.Adapter<ContestsAdapter.ContestViewHolder> {

    List<Contest> mContests;

    public ContestsAdapter(List<Contest> aContests) {
        mContests = aContests;
    }

    @NonNull
    @Override
    public ContestViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ContestViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return mContests.size();
    }

    static class ContestViewHolder extends RecyclerView.ViewHolder {
        public ContestViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
