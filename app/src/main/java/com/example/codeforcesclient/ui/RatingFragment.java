package com.example.codeforcesclient.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.ViewModelProviders;

import com.example.codeforcesclient.R;
import com.example.codeforcesclient.data.local.model.User;
import com.example.codeforcesclient.di.Injectable;
import com.example.codeforcesclient.ui.adapters.RatingAdapter;
import com.example.codeforcesclient.ui.adapters.UserClickListener;
import com.example.codeforcesclient.viewmodel.UserListViewModel;

import java.util.Collections;
import java.util.List;

public class RatingFragment extends BaseRecycleViewFragment<RatingAdapter> implements Injectable {

    private final UserClickListener mUserClickListener = aUser -> {
        if (getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED)) {
            ((MainActivity) getActivity()).showUserInfo(aUser.getHandle());
        }
    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_rating, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        mRecyclerView = view.findViewById(R.id.recycle_view_rating);
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    protected RatingAdapter createAdapter() {
        return new RatingAdapter(Collections.emptyList(), mUserClickListener);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        observeViewModel();
    }

    private void observeViewModel() {
        UserListViewModel userViewModel = ViewModelProviders.of(this, mFactory).get(UserListViewModel.class);
        userViewModel.getRatedUsers().observe(this, this::updateRating);
    }

    private void updateRating(@NonNull List<User> aUsers) {
        mAdapter.setUsers(aUsers);
        mAdapter.notifyDataSetChanged();
    }
}
