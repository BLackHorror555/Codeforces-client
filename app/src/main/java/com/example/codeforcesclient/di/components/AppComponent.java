package com.example.codeforcesclient.di.components;

import com.example.codeforcesclient.di.modules.AppModule;
import com.example.codeforcesclient.di.modules.NetModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class, NetModule.class})
public interface AppComponent {
    // void inject(MyFragment fragment);
}
