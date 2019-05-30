package com.example.codeforcesclient.ui.adapters;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.codeforcesclient.R;
import com.example.codeforcesclient.data.local.model.Problem;

import java.util.List;

public class ProblemAdapter extends RecyclerView.Adapter<ProblemAdapter.ProblemViewHolder> {

    private List<Problem> mProblems;
    private ProblemClickListener mProblemClickListener;

    public ProblemAdapter(List<Problem> aProblems, ProblemClickListener aProblemClickListener) {
        mProblemClickListener = aProblemClickListener;
        mProblems = aProblems;
    }

    @NonNull
    @Override
    public ProblemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View problemItem = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.problem_view_holder, parent, false);

        return new ProblemViewHolder(problemItem);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull ProblemViewHolder holder, int position) {
        Problem problem = mProblems.get(position);
        holder.mNameTextView.setText(problem.getName());
        holder.mParticipantsTextView.setText(Integer.toString(problem.getSolvedCount()));

        holder.bind(mProblems.get(position), mProblemClickListener);
    }

    @Override
    public int getItemCount() {
        return mProblems.size();
    }

    static class ProblemViewHolder extends RecyclerView.ViewHolder{
        TextView mNameTextView;
        TextView mParticipantsTextView;

        public ProblemViewHolder(@NonNull View itemView) {
            super(itemView);
            mNameTextView = itemView.findViewById(R.id.problem_title_problem_view_holder);
            mParticipantsTextView = itemView.findViewById(R.id.participation_count_problem_view_holder);
        }

        void bind(Problem aProblem, ProblemClickListener aProblemClickListener) {
            itemView.setOnClickListener(v -> aProblemClickListener.onClick(aProblem));
        }
    }

    public void setProblems(List<Problem> aProblems) {
        mProblems = aProblems;
    }
}
