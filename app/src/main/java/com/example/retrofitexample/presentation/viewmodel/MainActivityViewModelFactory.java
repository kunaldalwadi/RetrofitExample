package com.example.retrofitexample.presentation.viewmodel;

import com.example.retrofitexample.data.GetCallRepo;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class MainActivityViewModelFactory implements ViewModelProvider.Factory {
    
    private GetCallRepo mGetCallRepo;
    
    public MainActivityViewModelFactory(GetCallRepo getCallRepo) {
        mGetCallRepo = getCallRepo;
    }
    
    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new MainActivityViewModel(mGetCallRepo);
    }
}
