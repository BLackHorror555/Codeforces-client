package com.example.codeforcesclient.viewmodel;

import android.util.ArrayMap;

import com.example.codeforcesclient.di.components.ViewModelSubComponent;
import com.example.codeforcesclient.ui.BaseRecycleViewFragment;

import java.util.Map;
import java.util.concurrent.Callable;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class ViewModelFactory implements ViewModelProvider.Factory {
    private final ArrayMap<Class, Callable<? extends ViewModel>> mCreators;

    @Inject
    public ViewModelFactory(final ViewModelSubComponent aViewModelSubComponent) {
        mCreators = new ArrayMap<>();
        mCreators.put(ContestViewModel.class, aViewModelSubComponent::contestViewModel);
        mCreators.put(UserListViewModel.class, aViewModelSubComponent::userListViewModel);
        mCreators.put(UserViewModel.class, aViewModelSubComponent::userViewModel);
        mCreators.put(ProblemListViewModel.class, aViewModelSubComponent::problemListViewModel);
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> aModelClass) {
        Callable<? extends ViewModel> creator = mCreators.get(aModelClass);

        if (creator == null) {
            for (Map.Entry<Class, Callable<? extends ViewModel>> entry : mCreators.entrySet()) {
                if (aModelClass.isAssignableFrom(entry.getKey())) {
                    creator = entry.getValue();
                    break;
                }
            }
        }
        if (creator == null) {
            throw new IllegalArgumentException("Unknown model class " + aModelClass);
        }
        try {
            return (T) creator.call();
        } catch (Exception e) {
            throw new RuntimeException(e);

        }
    }
}
