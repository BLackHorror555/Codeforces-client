package com.example.codeforcesclient.di.modules;

import com.example.codeforcesclient.data.remote.ContestService;
import com.example.codeforcesclient.di.components.ViewModelSubComponent;
import com.example.codeforcesclient.viewmodel.ViewModelFactory;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.inject.Singleton;

import androidx.lifecycle.ViewModelProvider;
import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module(subcomponents = ViewModelSubComponent.class)
public class AppModule {
    private final String mBaseUrl = "http://codeforces.com/api/";

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
                .baseUrl(mBaseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    @Provides
    @Singleton
    ContestService provideContestService() {
        return new Retrofit.Builder()
                .baseUrl(mBaseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ContestService.class);
    }

    @Provides
    @Singleton
    ViewModelProvider.Factory provideViewModelFactory(ViewModelSubComponent.Builder viewModelSubComponent) {
        return new ViewModelFactory(viewModelSubComponent.build());

    }
}
