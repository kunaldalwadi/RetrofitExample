package com.example.retrofitexample.domain;

import com.example.retrofitexample.data.GetCallRepo;

public interface IGetCallRepo {

    void makeGetCall(String url, GetCallRepo.GetCallRepoCallBack getCallRepoCallBack);
}
