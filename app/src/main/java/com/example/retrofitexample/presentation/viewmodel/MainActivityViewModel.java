package com.example.retrofitexample.presentation.viewmodel;

import com.example.retrofitexample.data.GetCallRepo;
import com.example.retrofitexample.data.PostCallRepo;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainActivityViewModel extends ViewModel {
    
    private static final String TAG = MainActivityViewModel.class.getSimpleName();
    private MutableLiveData<String> getCallRepoLiveData = new MutableLiveData<>();
    private MutableLiveData<String> postCallRepoLiveData = new MutableLiveData<>();
    private GetCallRepo mGetCallRepo;
    private PostCallRepo mPostCallRepo;
    
    public MainActivityViewModel(GetCallRepo getCallRepo, PostCallRepo postCallRepo) {
        mGetCallRepo = getCallRepo;
        mPostCallRepo = postCallRepo;
    }
    
    public void makeGetCallToRepo(String url) {
        getCallRepoLiveData.postValue(mGetCallRepo.makeGetCall(url).getValue());
    }
    
    public void makePostCallToRepo(String url){
        postCallRepoLiveData.postValue(mPostCallRepo.makePostCall(url).getValue());
    }
    
    public MutableLiveData<String> startObservingGetCallResponse(){
        return getCallRepoLiveData;
    }
    public MutableLiveData<String> startObservingPostCallResponse(){
        return postCallRepoLiveData;
    }
    
}
