package com.example.retrofitexample.data;

import android.util.Log;

import java.io.IOException;

import androidx.lifecycle.MutableLiveData;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;

public class PostCallRepo {
    
    private static final String TAG = PostCallRepo.class.getSimpleName();
    private MutableLiveData<String> postServiceResponse = new MutableLiveData<>();
    
    public MutableLiveData<String> makePostCall(String url) {
        new Thread(() -> postServiceResponse.postValue(makePOSTServiceCall(url)));
        return postServiceResponse;
    }
    
    private String makePOSTServiceCall(String URL) {
        
        try
        {
            Call<ResponseBody> call = ApiHelper.getApi().makePOSTServiceCall(URL);
            Response<ResponseBody> response = call.execute();
            if (response.body() != null)
            {
                return response.body().string();
            }
            else
            {
                Log.d(TAG, "POST: null response" + response);
                return response.toString();
            }
        }
        catch (IOException e)
        {
            return null;
        }
    }
}
