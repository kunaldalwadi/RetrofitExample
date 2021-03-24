package com.example.retrofitexample.presentation.viewmodel;

import com.example.retrofitexample.data.GetCallRepo;
import com.example.retrofitexample.data.PostCallRepo;
import com.example.retrofitexample.data.PutCallRepo;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class MainActivityViewModelFactory implements ViewModelProvider.Factory {
    
    private GetCallRepo mGetCallRepo;
    private PostCallRepo mPostCallRepo;
    private PutCallRepo mPutCallRepo;
    
    public MainActivityViewModelFactory(GetCallRepo getCallRepo, PostCallRepo postCallRepo, PutCallRepo putCallRepo) {
        mGetCallRepo = getCallRepo;
        mPostCallRepo = postCallRepo;
        mPutCallRepo = putCallRepo;
    }
    
    
    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new MainActivityViewModel(mGetCallRepo, mPostCallRepo, mPutCallRepo);
    }
}
