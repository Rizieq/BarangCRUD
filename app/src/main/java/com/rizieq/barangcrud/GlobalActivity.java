package com.rizieq.barangcrud;

import android.app.Application;
import android.util.Log;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.interceptors.HttpLoggingInterceptor;

import okhttp3.OkHttpClient;

public class GlobalActivity extends Application {

    public static String BASE_URL = "http://192.168.70.231/api_barang/index.php/Api/";

    @Override
    public void onCreate() {
        super.onCreate();

        OkHttpClient okHttpClient = new OkHttpClient().newBuilder()
                .addNetworkInterceptor(new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
                    @Override
                    public void log(String message) {
                        Log.d("SINI",message);
                    }
                }))
                .build();
        AndroidNetworking.initialize(getApplicationContext(),okHttpClient);
    }
}
