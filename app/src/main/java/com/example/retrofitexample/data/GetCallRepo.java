package com.example.retrofitexample.data;

import android.util.Log;

import java.io.IOException;

import androidx.lifecycle.MutableLiveData;

import com.example.retrofitexample.domain.IGetCallRepo;

import javax.inject.Inject;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;

//Repo should have ONLY ONE public method.
public class GetCallRepo implements IGetCallRepo {

    private static final String TAG = GetCallRepo.class.getSimpleName();

    @Inject
    public GetCallRepo() {
    }

    //where the wpr is supposed to be done, just define the interface with methods which will reflect what is going to be sent to the class calling it.
    public interface GetCallRepoCallBack{
        void onGetCallResponse(String serverResponse);
    }

//Removing Live Data from Repo cause it is not recommended also that it is connected to the lifecycle of the app and
//which means we will have to be responsible for managing the LiveData.
//    private MutableLiveData<String> serverResponse = new MutableLiveData<>();

//should pass the interface object as the parameter so that this class can send back the response to the class/variable implementing it
    public void makeGetCall(String url, GetCallRepoCallBack getCallRepoCallBack) {
        new Thread(() -> {
            String response = makeGETServiceCall(url);
            getCallRepoCallBack.onGetCallResponse(response);
        }).start();

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

