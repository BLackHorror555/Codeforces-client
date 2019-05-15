package com.example.codeforcesclient.di.modules;

import com.example.codeforcesclient.ui.MainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuilder {
    @ContributesAndroidInjector(modules = FragmentBuildersModule.class)
    abstract MainActivity bindMainActivity();
}
