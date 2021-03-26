package com.example.retrofitexample.domain;

import com.example.retrofitexample.data.PostCallRepo;

public interface IPostCallRepo {

     void makePostCall(String url, PostCallRepo.PostCallRepoCallBack postCallRepoCallBack);
}
