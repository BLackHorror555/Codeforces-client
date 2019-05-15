package com.example.codeforcesclient.di.components;

import com.example.codeforcesclient.viewmodel.ContestViewModel;
import com.example.codeforcesclient.viewmodel.ProblemViewModel;
import com.example.codeforcesclient.viewmodel.UserViewModel;
import com.example.codeforcesclient.viewmodel.ViewModelFactory;

import dagger.Subcomponent;

/**
 * Component responsible for creating of ViewModels.
 *
 * <p>
 *     Used by {@link ViewModelFactory} for getting ViewModel instances.
 * </p>
 */
@Subcomponent
public interface ViewModelSubComponent {
    @Subcomponent.Builder
    interface Builder {
        ViewModelSubComponent build();
    }

    ContestViewModel contestViewModel();
//    ProblemViewModel problemViewModel();
//    UserViewModel userViewModel();
}