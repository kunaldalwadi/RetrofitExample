package com.example.retrofitexample.presentation.viewmodel;

import com.example.retrofitexample.data.GetCallRepo;
import com.example.retrofitexample.data.PostCallRepo;
import com.example.retrofitexample.data.PutCallRepo;
import com.example.retrofitexample.domain.IGetCallRepo;
import com.example.retrofitexample.domain.IPostCallRepo;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class MainActivityViewModelFactory implements ViewModelProvider.Factory {
    
    private IGetCallRepo mGetCallRepo;
    private IPostCallRepo mPostCallRepo;
    private PutCallRepo mPutCallRepo;
    
    public MainActivityViewModelFactory(IGetCallRepo getCallRepo, IPostCallRepo postCallRepo, PutCallRepo putCallRepo) {
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
