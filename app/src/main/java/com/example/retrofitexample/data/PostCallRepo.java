package com.example.retrofitexample.data;

import android.util.Log;

import java.io.IOException;

import androidx.lifecycle.MutableLiveData;

import com.example.retrofitexample.domain.IPostCallRepo;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;

public class PostCallRepo implements IPostCallRepo {
    
    private static final String TAG = PostCallRepo.class.getSimpleName();


//    private MutableLiveData<String> postServiceResponse = new MutableLiveData<>();

    public interface PostCallRepoCallBack{
        void postCallResponse(String serverResponse);
    }

    public void makePostCall(String url, PostCallRepoCallBack postCallRepoCallBack) {
        new Thread(() -> {
            String response = makePOSTServiceCall(url);
            postCallRepoCallBack.postCallResponse(response);
        }).start();

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
