package com.example.retrofitexample.data;

import android.app.Application;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.security.cert.CertificateException;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import okhttp3.OkHttpClient;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiHelper {
    
    static Api mApi;
    
    public static Api getApi() {
        if (mApi == null)
        {
            mApi = createApiObject();
        }
        return mApi;
        
    }
    
    private static Api createApiObject() {
        Gson gson = new GsonBuilder().create();
        
        OkHttpClient okHttpClient = getOkHttpClient();
        
        retrofit2.Retrofit retrofit = new retrofit2.Retrofit.Builder().baseUrl(Api.BASE_URL_SECURE_HTTPS).addConverterFactory(GsonConverterFactory.create(gson)).client(okHttpClient).build();
        
        return retrofit.create(Api.class);
    }
    
    /**
     * Create an OkHTTPClient for retrofit to use
     * Add certificates to allow for HTTPS
     */
    public static OkHttpClient getOkHttpClient() {
        
        try
        {
            /*
             * Create a trust manager that does not validate certificate chains.
             */
            final TrustManager[] trustAllCerts = new TrustManager[] { new X509TrustManager() {
                @Override
                public void checkClientTrusted(java.security.cert.X509Certificate[] chain, String authType) throws CertificateException {
                }
                
                @Override
                public void checkServerTrusted(java.security.cert.X509Certificate[] chain, String authType) throws CertificateException {
                }
                
                @Override
                public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                    return new java.security.cert.X509Certificate[0];
                }
            } };
            
            /*
             * Install the trust manager
             */
            final SSLContext sslContext = SSLContext.getInstance("TLS");
            
            sslContext.init(null, trustAllCerts, new java.security.SecureRandom());
            
            /*
             * Create an ssl socket factory with our manager
             */
            final SSLSocketFactory sslSocketFactory = sslContext.getSocketFactory();
            
            return new OkHttpClient().newBuilder().readTimeout(20000, TimeUnit.MILLISECONDS).writeTimeout(20000, TimeUnit.MILLISECONDS).sslSocketFactory(sslSocketFactory).hostnameVerifier(org.apache.http.conn.ssl.SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER).build();
        }
        catch (Exception e)
        {
            throw new RuntimeException(e);
        }
    }
}
