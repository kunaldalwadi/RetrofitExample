package com.example.retrofitexample.presentation.viewmodel;

import com.example.retrofitexample.data.GetCallRepo;
import com.example.retrofitexample.data.PostCallRepo;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class MainActivityViewModelFactory implements ViewModelProvider.Factory {
    
    private GetCallRepo mGetCallRepo;
    private PostCallRepo mPostCallRepo;
    
    public MainActivityViewModelFactory(GetCallRepo getCallRepo, PostCallRepo postCallRepo) {
        mGetCallRepo = getCallRepo;
        mPostCallRepo = postCallRepo;
    }
    
    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new MainActivityViewModel(mGetCallRepo, mPostCallRepo);
    }
}
