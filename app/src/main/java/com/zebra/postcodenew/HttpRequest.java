package com.zebra.postcodenew;

import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;


public class HttpRequest {

    private float longitude = -20.1812f;
    private float latitude = 51.5258f;

    OkHttpClient client = new OkHttpClient();

    Request request = new Request.Builder()
            .url("http://api.postcodes.io/postcodes?lon=" + longitude + "&lat=" + latitude)
            .build();

    public void sendRequest(Callback callback){

        client.newCall(request).enqueue(callback);

    }
}
