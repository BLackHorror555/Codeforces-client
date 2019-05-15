package com.example.codeforcesclient.di.modules;

import com.example.codeforcesclient.ui.ContestFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class FragmentBuildersModule {

    @ContributesAndroidInjector
    abstract ContestFragment bindProjectFragment();
}
