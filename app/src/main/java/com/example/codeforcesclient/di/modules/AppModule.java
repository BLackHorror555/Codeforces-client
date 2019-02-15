package com.example.codeforcesclient.di.modules;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {
    private final Application mApplication;

    public AppModule(Application aApplication) {
        mApplication = aApplication;
    }

    @Provides
    @Singleton
    Application provideApplication() {
        return mApplication;
    }


}
