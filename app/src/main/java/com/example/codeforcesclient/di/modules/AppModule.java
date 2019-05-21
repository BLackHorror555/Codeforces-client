package com.example.codeforcesclient.di.modules;

import android.app.Application;

import androidx.lifecycle.ViewModelProvider;
import androidx.room.Room;

import com.example.codeforcesclient.data.local.CodeForcesDatabase;
import com.example.codeforcesclient.data.local.dao.ContestDao;
import com.example.codeforcesclient.data.remote.service.ContestService;
import com.example.codeforcesclient.di.components.ViewModelSubComponent;
import com.example.codeforcesclient.viewmodel.ViewModelFactory;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module(subcomponents = ViewModelSubComponent.class)
public class AppModule {
    private static final String sBaseUrl = "http://codeforces.com/api/";

    @Provides
    @Singleton
    Gson provideGson() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES);
        return gsonBuilder.create();
    }

    @Provides
    @Singleton
    Retrofit provideRetrofit() {
        return new Retrofit.Builder()
                .baseUrl(sBaseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    @Provides
    @Singleton
    ContestService provideContestService() {
        return new Retrofit.Builder()
                .baseUrl(sBaseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ContestService.class);
    }

    @Singleton
    @Provides
    CodeForcesDatabase providesCodeForcesDatabase(Application aApplication) {
        return Room.databaseBuilder(aApplication, CodeForcesDatabase.class, "CodeForces").build();
    }

    @Singleton
    @Provides
    ContestDao provideContestDao(CodeForcesDatabase aCodeForcesDatabase) {
        return aCodeForcesDatabase.contestDao();
    }

    @Provides
    @Singleton
    ViewModelProvider.Factory provideViewModelFactory(ViewModelSubComponent.Builder viewModelSubComponent) {
        return new ViewModelFactory(viewModelSubComponent.build());
    }
}
