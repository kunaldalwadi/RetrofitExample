package com.example.retrofitexample.domain;

import com.example.retrofitexample.data.PostCallRepo;

public interface IPostCallRepo {

    interface PostCallRepoCallBack {
        void postCallResponse(String serverResponse);
    }

    void makePostCall(String url, PostCallRepo.PostCallRepoCallBack postCallRepoCallBack);
}
