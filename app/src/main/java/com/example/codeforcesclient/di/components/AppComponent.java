package com.example.codeforcesclient.di.components;

import android.app.Application;

import com.example.codeforcesclient.CodeForcesApp;
import com.example.codeforcesclient.di.builders.ActivityModule;
import com.example.codeforcesclient.di.modules.AppModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component(modules = {AppModule.class, AndroidSupportInjectionModule.class,
        ActivityModule.class})
public interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(Application aApplication);
        AppComponent build();
    }

    void inject(CodeForcesApp aCodeForcedApp);
}
