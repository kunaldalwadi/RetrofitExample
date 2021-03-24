package com.example.retrofitexample.data;

import android.util.Log;

import java.io.IOException;

import androidx.lifecycle.MutableLiveData;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;

public class GetCallRepo {
    
    private static final String TAG = GetCallRepo.class.getSimpleName();
    private MutableLiveData<String> serverResponse = new MutableLiveData<>();
    
    public MutableLiveData<String> makeGetCall(String url) {
        new Thread(() -> serverResponse.postValue(makeGETServiceCall(url))).start();
        return serverResponse;
    }
    
    private String makeGETServiceCall(String URL) {
        
        try
        {
            Call<ResponseBody> call =  ApiHelper.getApi().makeGETServiceCall(URL);
            Response<ResponseBody> response = call.execute();
            if (response.body() != null)
            {
                return response.body().string();
            }
            else
            {
                Log.d(TAG, "GET: null response" + response);
                return response.toString();
            }
        }
        catch (IOException e)
        {
            return null;
        }
    }
}

