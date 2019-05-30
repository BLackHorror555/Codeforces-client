package com.example.codeforcesclient.di.builders;

import com.example.codeforcesclient.ui.ContestFragment;
import com.example.codeforcesclient.ui.GymContestsFragment;
import com.example.codeforcesclient.ui.ProblemForContestFragment;
import com.example.codeforcesclient.ui.ProblemFragment;
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

    @SuppressWarnings("unused")
    @ContributesAndroidInjector
    abstract ProblemFragment contributeProblemFragment();

    @SuppressWarnings("unused")
    @ContributesAndroidInjector
    abstract ProblemForContestFragment contributeProblemForContestFragment();

    @SuppressWarnings("unused")
    @ContributesAndroidInjector
    abstract GymContestsFragment contributeGymContestFragment();

}
