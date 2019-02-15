package com.example.codeforcesclient.di.components;

import com.example.codeforcesclient.viewmodel.ContestViewModel;

import dagger.Subcomponent;

/**
 * Component responsible for creating of ViewModels.
 */
@Subcomponent
public interface ViewModelSubComponent {
    @Subcomponent.Builder
    interface Builder {
        ViewModelSubComponent build();
    }

    ContestViewModel contestViewModel();
}
