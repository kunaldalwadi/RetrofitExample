package com.example.retrofitexample.data;

import android.util.Log;

import java.io.IOException;

import androidx.lifecycle.MutableLiveData;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;

public class PutCallRepo {
    
    private static final String TAG = PutCallRepo.class.getSimpleName();
    private MutableLiveData<String> putResponseFromServer = new MutableLiveData<>();
    
    
    public MutableLiveData<String> makePutCall(String url) {
        new Thread(() -> putResponseFromServer.postValue(makePUTServiceCall(url)));
        return putResponseFromServer;
    }
    
    
    private String makePUTServiceCall(String URL) {
        
        try
        {
            Call<ResponseBody> call = ApiHelper.getApi().makePUTServiceCall(URL);
            Response<ResponseBody> response = call.execute();
            if (response.body() != null)
            {
                return response.body().string();
            }
            else
            {
                Log.d(TAG, "PUT: null response" + response);
                return response.toString();
            }
        }
        catch (IOException e)
        {
            return null;
        }
    }
    
}
