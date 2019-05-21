package com.example.codeforcesclient.di.builders;

import com.example.codeforcesclient.ui.ContestFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class FragmentModule {

    @SuppressWarnings("unused")
    @ContributesAndroidInjector
    abstract ContestFragment contributeContestFragment();
}
