package com.example.retrofitexample.presentation.viewmodel;

import com.example.retrofitexample.data.GetCallRepo;
import com.example.retrofitexample.data.PostCallRepo;
import com.example.retrofitexample.data.PutCallRepo;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainActivityViewModel extends ViewModel {
    
    private static final String TAG = MainActivityViewModel.class.getSimpleName();
    private MutableLiveData<String> getCallRepoLiveData = new MutableLiveData<>();
    private MutableLiveData<String> postCallRepoLiveData = new MutableLiveData<>();
    private MutableLiveData<String> putCallRepoLiveData = new MutableLiveData<>();
    private GetCallRepo mGetCallRepo;
    private PostCallRepo mPostCallRepo;
    private PutCallRepo mPutCallRepo;
    
    public MainActivityViewModel(GetCallRepo getCallRepo, PostCallRepo postCallRepo, PutCallRepo putCallRepo) {
        mGetCallRepo = getCallRepo;
        mPostCallRepo = postCallRepo;
        mPutCallRepo = putCallRepo;
    }


    public void makeGetCallToRepo(String url) {
        mGetCallRepo.makeGetCall(url, serverResponse -> getCallRepoLiveData.postValue(serverResponse));
    }
    
    public void makePostCallToRepo(String url){
        mPostCallRepo.makePostCall(url, serverResponse -> postCallRepoLiveData.postValue(serverResponse));
    }
    
    public void makePutCallToRepo(String url)
    {
        putCallRepoLiveData.postValue(mPutCallRepo.makePutCall(url).getValue());
    }
    
    public MutableLiveData<String> startObservingGetCallResponse(){
        return getCallRepoLiveData;
    }
    public MutableLiveData<String> startObservingPostCallResponse(){
        return postCallRepoLiveData;
    }
    public MutableLiveData<String> startObservingPutCallResponse(){
        return putCallRepoLiveData;
    }



}
