package com.example.codeforcesclient.ui;

import android.annotation.SuppressLint;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import com.example.codeforcesclient.R;
import com.example.codeforcesclient.data.local.model.User;
import com.example.codeforcesclient.di.Injectable;
import com.example.codeforcesclient.utils.Util;
import com.example.codeforcesclient.viewmodel.UserViewModel;
import com.squareup.picasso.Picasso;

import java.net.URL;

import javax.inject.Inject;

public class UserInfoFragment extends Fragment implements Injectable {

    private static final String KEY_USER_HANDLE = "project_id";

    private TextView mHandleTextView;
    private TextView mContributionTextView;
    private TextView mRatingTextView;
    private TextView mFriendsTextView;
    private ImageView mUserImageView;

    @Inject
    ViewModelProvider.Factory mFactory;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_user_info, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mHandleTextView = view.findViewById(R.id.user_info_handle_tv);
        mContributionTextView = view.findViewById(R.id.user_info_contribution_tv);
        mRatingTextView = view.findViewById(R.id.user_info_rating_tv);
        mFriendsTextView = view.findViewById(R.id.user_info_friejnds_tv);
        mUserImageView = view.findViewById(R.id.user_info_image);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        observeViewModel();
    }

    private void observeViewModel() {
        UserViewModel userViewModel = ViewModelProviders.of(this, mFactory).get(UserViewModel.class);
        userViewModel.setUserHandle(getArguments().getString(KEY_USER_HANDLE));
        userViewModel.getUser().observe(this, this::updateInfo);
    }

    @SuppressLint("SetTextI18n")
    private void updateInfo(User aUser) {
        mHandleTextView.setText(aUser.getHandle());
        mContributionTextView.setText(Integer.toString(aUser.getContribution()));
        mRatingTextView.setText(Integer.toString(aUser.getRating()));
        mFriendsTextView.setText(Integer.toString(aUser.getFriendOfCount()));
        Picasso.get().load(Util.HTTP_PREFIX + aUser.getTitlePhoto())
                .error(R.drawable.ic_error_loading)
                .into(mUserImageView);
    }

    static UserInfoFragment newInstance(String aUserHandle) {
        UserInfoFragment userInfoFragment = new UserInfoFragment();
        Bundle bundle = new Bundle();
        bundle.putString(KEY_USER_HANDLE, aUserHandle);
        userInfoFragment.setArguments(bundle);

        return userInfoFragment;
    }

}
