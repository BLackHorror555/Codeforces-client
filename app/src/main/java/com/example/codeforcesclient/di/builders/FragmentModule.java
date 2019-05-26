package com.example.codeforcesclient.di.builders;

import com.example.codeforcesclient.ui.ContestFragment;
import com.example.codeforcesclient.ui.RatingFragment;
import com.example.codeforcesclient.ui.UserInfoFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class FragmentModule {

    @SuppressWarnings("unused")
    @ContributesAndroidInjector
    abstract ContestFragment contributeContestFragment();

    @SuppressWarnings("unused")
    @ContributesAndroidInjector
    abstract RatingFragment contributeRatingFragment();

    @SuppressWarnings("unused")
    @ContributesAndroidInjector
    abstract UserInfoFragment contributeUserInfoFragment();
}
