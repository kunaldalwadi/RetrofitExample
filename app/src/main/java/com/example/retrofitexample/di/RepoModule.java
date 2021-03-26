package com.example.retrofitexample.di;

import com.example.retrofitexample.data.GetCallRepo;
import com.example.retrofitexample.data.PostCallRepo;
import com.example.retrofitexample.data.PutCallRepo;
import com.example.retrofitexample.domain.IGetCallRepo;
import com.example.retrofitexample.domain.IPostCallRepo;

import dagger.Binds;
import dagger.Module;

@Module
abstract class RepoModule {

    @Binds
    abstract IPostCallRepo bindsPostCallRepo(PostCallRepo postCallRepo);

//    @Binds
//    abstract IPutCallRepo bindsPutCallRepo(PutCallRepo postCallRepo);

    @Binds
    abstract IGetCallRepo bindsGetCallRepo(GetCallRepo postCallRepo);
}
