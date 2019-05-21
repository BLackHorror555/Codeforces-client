package com.example.codeforcesclient.ui.adapters;

import android.text.format.DateUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.codeforcesclient.R;
import com.example.codeforcesclient.data.local.model.Contest;

import java.time.Instant;
import java.util.Date;
import java.util.List;

public class ContestsAdapter extends RecyclerView.Adapter<ContestsAdapter.ContestViewHolder> {

    private List<Contest> mContests;

    public ContestsAdapter(List<Contest> aContests) {
        mContests = aContests;
    }

    @NonNull
    @Override
    public ContestViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View contestItem = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.contest_view_holder, parent, false);
        return new ContestViewHolder(contestItem);
    }

    @Override
    public void onBindViewHolder(@NonNull ContestViewHolder holder, int position) {
        Contest contest = mContests.get(position);
        holder.mContestName.setText(contest.getName());
        holder.mPhase.setText(contest.getPhase());
        holder.mDuration.setText(DateUtils.formatElapsedTime(contest.getDurationSeconds()));
        holder.mStartTime.setText(new Date((long)contest.getStartTimeSeconds() * 1000).toString());
        holder.mArrow.setOnClickListener(v -> {
        });
    }



    @Override
    public int getItemCount() {
        return mContests.size();
    }

    static class ContestViewHolder extends RecyclerView.ViewHolder {

        public TextView mContestName;
        public TextView mDuration;
        public TextView mPhase;
        public TextView mStartTime;
        public ImageButton mArrow;

        public ContestViewHolder(@NonNull View itemView) {
            super(itemView);

            mContestName = itemView.findViewById(R.id.contest_name_tv);
            mPhase = itemView.findViewById(R.id.contest_phase_tv);
            mDuration = itemView.findViewById(R.id.contest_duration_tv);
            mStartTime = itemView.findViewById(R.id.starting_time_tv);
            mArrow = itemView.findViewById(R.id.arrow_image_btn);
        }
    }

    public void setContests(List<Contest> aContests) {
        mContests = aContests;
    }
}
