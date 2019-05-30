package com.example.codeforcesclient.di.modules;

import android.app.Application;

import androidx.lifecycle.ViewModelProvider;
import androidx.room.Room;

import com.example.codeforcesclient.data.local.CodeForcesDatabase;
import com.example.codeforcesclient.data.local.dao.ContestDao;
import com.example.codeforcesclient.data.local.dao.ProblemDao;
import com.example.codeforcesclient.data.local.dao.UserDao;
import com.example.codeforcesclient.data.remote.service.ContestService;
import com.example.codeforcesclient.data.remote.service.ProblemService;
import com.example.codeforcesclient.data.remote.service.UserService;
import com.example.codeforcesclient.di.components.ViewModelSubComponent;
import com.example.codeforcesclient.utils.LoadExecutors;
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
    private static final Retrofit sRetrofit = new Retrofit.Builder()
            .baseUrl(sBaseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    @Provides
    @Singleton
    Gson provideGson() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES);
        return gsonBuilder.create();
    }

    @Provides
    @Singleton
    LoadExecutors provideLoadExecutors() {
        return LoadExecutors.createDefaultLoadExecutors();
    }

    @Provides
    @Singleton
    ContestService provideContestService() {
        return sRetrofit.create(ContestService.class);
    }

    @Provides
    @Singleton
    UserService provideUserService() {
        return sRetrofit.create(UserService.class);
    }

    @Provides
    @Singleton
    ProblemService provideProblemService() {
        return sRetrofit.create(ProblemService.class);
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

    @Singleton
    @Provides
    UserDao provideUserDao(CodeForcesDatabase aCodeForcesDatabase) {
        return aCodeForcesDatabase.userDao();
    }
    @Singleton
    @Provides
    ProblemDao provideProblemDao(CodeForcesDatabase aCodeForcesDatabase) {
        return aCodeForcesDatabase.problemDao();
    }


    @Provides
    @Singleton
    ViewModelProvider.Factory provideViewModelFactory(ViewModelSubComponent.Builder viewModelSubComponent) {
        return new ViewModelFactory(viewModelSubComponent.build());
    }
}
