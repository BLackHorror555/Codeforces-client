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

import java.util.Date;
import java.util.List;

public class ContestsAdapter extends RecyclerView.Adapter<ContestsAdapter.ContestViewHolder> {

    private List<Contest> mContests;
    private ContestClickListener mContestClickListener;

    public ContestsAdapter(List<Contest> aContests, ContestClickListener aContestClickListener) {
        mContests = aContests;
        mContestClickListener = aContestClickListener;
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

        if (!contest.getPhase().equals(Contest.ContestPhase.FINISHED)) {
            holder.mArrow.setVisibility(View.INVISIBLE);
        } else {
            holder.mArrow.setVisibility(View.VISIBLE);
        }
        holder.bind(mContests.get(position), mContestClickListener);
    }


    @Override
    public int getItemCount() {
        return mContests.size();
    }

    class ContestViewHolder extends RecyclerView.ViewHolder {

        TextView mContestName;
        TextView mDuration;
        TextView mPhase;
        TextView mStartTime;
        ImageButton mArrow;

        ContestViewHolder(@NonNull View itemView) {
            super(itemView);

            mContestName = itemView.findViewById(R.id.contest_name_tv);
            mPhase = itemView.findViewById(R.id.contest_phase_tv);
            mDuration = itemView.findViewById(R.id.contest_duration_tv);
            mStartTime = itemView.findViewById(R.id.starting_time_tv);
            mArrow = itemView.findViewById(R.id.arrow_image_btn);
        }

        void bind(Contest aContest, ContestClickListener aContestClickListener) {
            itemView.setOnClickListener(v -> aContestClickListener.onClick(aContest));
        }
    }

    public void setContests(List<Contest> aContests) {
        mContests = aContests;
    }
}
