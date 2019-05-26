package com.example.codeforcesclient.ui;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import javax.inject.Inject;

public abstract class BaseRecycleViewFragment<A extends RecyclerView.Adapter> extends Fragment {
    protected A mAdapter;
    protected RecyclerView mRecyclerView;
    protected RecyclerView.LayoutManager mLayoutManager;

    @Inject
    protected ViewModelProvider.Factory mFactory;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setupContestRecycleView();
    }

    protected abstract A createAdapter();

    protected void setupContestRecycleView() {
        mAdapter = createAdapter();
        mRecyclerView.setAdapter(mAdapter);
        mLayoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL));
    }
}
