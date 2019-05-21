package com.example.codeforcesclient.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.codeforcesclient.R;
import com.example.codeforcesclient.data.local.model.User;
import com.example.codeforcesclient.di.Injectable;
import com.example.codeforcesclient.ui.adapters.RatingAdapter;

import java.util.ArrayList;

public class RatingFragment extends Fragment implements Injectable {
    private RecyclerView mRatingRecycleView;
    private RatingAdapter mRatingAdapter;
    RecyclerView.LayoutManager mLayoutManager;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_rating, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mRatingRecycleView = view.findViewById(R.id.recycle_view_rating);
        setupRatingView();
    }

    private void setupRatingView() {
        mRatingAdapter = new RatingAdapter(new ArrayList<User>());
        mRatingRecycleView.setAdapter(mRatingAdapter);
        mLayoutManager = new LinearLayoutManager(getContext());
        mRatingRecycleView.setLayoutManager(mLayoutManager);
        mRatingRecycleView.setHasFixedSize(true);
        mRatingRecycleView.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL));
    }
}
