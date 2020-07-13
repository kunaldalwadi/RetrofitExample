package com.example.retrofitexample;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.HEAD;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Url;

public interface Api {

    String BASE_URL_DEFAULT_HTTP = "http://localhost";
    String BASE_URL_SECURE_HTTPS = "https://localhost";


    String RestModeDefaultHTTP = "DefaultHTTP";
    String RestModeSecureHTTPS = "SecureHTTPS";

    @GET
    Call<ResponseBody> makeGETServiceCall(@Url String URL);

    @POST
    Call<ResponseBody> makePOSTServiceCall(@Url String URL);

    @PUT
    Call<ResponseBody> makePUTServiceCall(@Url String URL);

    @DELETE
    Call<ResponseBody> makeDELETEServiceCall(@Url String URL);

    @HEAD
    Call<ResponseBody> makeHEADServiceCall(@Url String URL);

}
