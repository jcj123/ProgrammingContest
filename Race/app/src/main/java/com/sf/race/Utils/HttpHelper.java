package com.sf.race.Utils;

import android.util.Log;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by jcj on 2017/12/15.
 */

public class HttpHelper {
    private static final String TAG="HttpHelper";
    public static final MediaType JSON
            = MediaType.parse("application/json; charset=utf-8");
    private static Response response;

    public static String post(String url,String json) {
        String result = null;
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url)
                .post(RequestBody.create(JSON, json))
                .build();
        try {
            response = client.newCall(request).execute();
            result = response.body().string();
        } catch (IOException e) {
            Log.e(TAG, "post: ", e);
        }
        return result;
    }
    public static String get(String url){
        String result = null;
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url)
                .get()
                .build();
        try {
            response = client.newCall(request).execute();
            result = response.body().string();
        } catch (IOException e) {
            Log.e(TAG, "get: ", e);
        }
        return result;
    }
}