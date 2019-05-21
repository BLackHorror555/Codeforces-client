package com.example.codeforcesclient.di.builders;

import com.example.codeforcesclient.ui.MainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityModule {

    @SuppressWarnings("unused")
    @ContributesAndroidInjector(modules = FragmentModule.class)
    abstract MainActivity contributeMainActivity();
}
