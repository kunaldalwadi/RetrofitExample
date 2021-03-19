package com.example.retrofitexample.presentation.view;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.retrofitexample.data.Api;
import com.example.retrofitexample.presentation.BaseActivity;
import com.example.retrofitexample.data.model.Person;
import com.example.retrofitexample.R;
import com.example.retrofitexample.databinding.MainActivityBinding;

import java.io.IOException;

import androidx.databinding.DataBindingUtil;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;

public class MainActivity extends BaseActivity {

    public Api mApi;
    public static final String TAG = MainActivity.class.getSimpleName();
    public MainActivityBinding mMainActivityBinding;
    public String responseFromService;
    public String BASE_URL_SECURE_HTTPS = "https://localhost";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //this is just another way to bind activity with the java file.
        mMainActivityBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        //this is another way to bind activity with the java file
//        mMainActivityBinding = MainActivityBinding.inflate(getLayoutInflater());
//        View mView = mMainActivityBinding.getRoot();
//        setContentView(mView);

        Person person = new Person("Elon", "Musk");
        mMainActivityBinding.setPerson(person);

        mApi = createApiObject();

        //GET call
        mMainActivityBinding.btnGet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        String dataFromEditText = getDataFromEditText();
                        responseFromService = makeGETServiceCall(dataFromEditText);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                setTextToTextView(responseFromService);
                            }
                        });
                    }
                }).start();
            }
        });


        //POST call
        mMainActivityBinding.btnPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        String dataFromEditText = getDataFromEditText();
                        responseFromService = makePOSTServiceCall(dataFromEditText);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                setTextToTextView(responseFromService);
                            }
                        });
                    }
                }).start();
            }
        });


        //PUT call
        mMainActivityBinding.btnPut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        String dataFromEditText = getDataFromEditText();
                        responseFromService = makePUTServiceCall(dataFromEditText);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                setTextToTextView(responseFromService);
                            }
                        });
                    }
                }).start();
            }
        });


        //DELETE call
        mMainActivityBinding.btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        String dataFromEditText = getDataFromEditText();
                        responseFromService = makeDELETEServiceCall(dataFromEditText);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                setTextToTextView(responseFromService);
                            }
                        });
                    }
                }).start();
            }
        });


        //HEAD call
        mMainActivityBinding.btnHead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        String dataFromEditText = getDataFromEditText();
                        responseFromService = makeHEADServiceCall(dataFromEditText);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                setTextToTextView(responseFromService);
                            }
                        });
                    }
                }).start();
            }
        });
    }

    public String getDataFromEditText() {
        String text = mMainActivityBinding.etUrl.getText().toString().trim();
        return BASE_URL_SECURE_HTTPS + text;
    }

    public void setTextToTextView(String result) {
        mMainActivityBinding.tvResult.setText(result);
    }

    public String makeGETServiceCall(String URL) {

        try
        {
            Call<ResponseBody> call = mApi.makeGETServiceCall(URL);
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

    public String makePOSTServiceCall(String URL) {

        try
        {
            Call<ResponseBody> call = mApi.makePOSTServiceCall(URL);
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

    public String makePUTServiceCall(String URL) {

        try
        {
            Call<ResponseBody> call = mApi.makePUTServiceCall(URL);
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

    public String makeDELETEServiceCall(String URL) {

        try
        {
            Call<ResponseBody> call = mApi.makeDELETEServiceCall(URL);
            Response<ResponseBody> response = call.execute();
            if (response.body() != null)
            {
                return response.body().string();
            }
            else
            {
                Log.d(TAG, "DELETE: null response" + response);
                return response.toString();
            }
        }
        catch (IOException e)
        {
            return null;
        }
    }

    public String makeHEADServiceCall(String URL) {

        try
        {
            Call<ResponseBody> call = mApi.makeHEADServiceCall(URL);
            Response<ResponseBody> response = call.execute();
            if (response.body() != null)
            {
                return response.body().string();
            }
            else
            {
                Log.d(TAG, "HEAD: null response" + response);
                return response.toString();
            }
        }
        catch (IOException e)
        {
            return null;
        }
    }

}