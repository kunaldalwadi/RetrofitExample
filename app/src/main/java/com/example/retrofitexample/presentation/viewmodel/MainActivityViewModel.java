package com.example.retrofitexample.presentation.viewmodel;

import com.example.retrofitexample.data.GetCallRepo;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainActivityViewModel extends ViewModel {
    
    private static final String TAG = MainActivityViewModel.class.getSimpleName();
    private MutableLiveData<String> getCallRepoResponse = new MutableLiveData<>();
    private GetCallRepo mGetCallRepo;
    
    public MainActivityViewModel(GetCallRepo getCallRepo) {
        mGetCallRepo = getCallRepo;
    }
    
    public void makeGetCallToRepo(String url) {
        MutableLiveData<String> stringGetCallMutableLiveData = mGetCallRepo.makeGetCall(url);
        getCallRepoResponse.postValue(stringGetCallMutableLiveData.getValue());
    }
    
    public MutableLiveData<String> startObservingGetCallResponse(){
        return getCallRepoResponse;
    }
    
}
