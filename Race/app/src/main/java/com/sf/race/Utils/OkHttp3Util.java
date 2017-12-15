package com.sf.race.Utils;

import com.sf.race.MainApplication;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * 简单封装了下OkHttp3
 */

public class OkHttp3Util {

    public static final MediaType JSON
            = MediaType.parse("application/json; charset=utf-8");

    public static String post(String url,String json)throws IOException{
        OkHttpClient client = new OkHttpClient();
            RequestBody body = RequestBody.create(JSON, json);
            Request request = new Request.Builder()
                    .url(url)
                    .post(body)
                    .build();
            Response response = client.newCall(request).execute();
            return response.body().string();
    }
    private static final String urlPrefix = "";

    /**
     * 普通的post请求
     */
    public static void post(String url, Map<String, String> stringParams, Callback callback) {
        post(true,url, stringParams, null, callback);
    }
    /**
     * 无参数请求
     * @param url
     * @param callback
     */
    public static void post(final String url, final Callback callback){

        RequestBody requestBody = new FormBody.Builder().build();

        Request request = new Request.Builder().url(urlPrefix + url).post(requestBody).build();

        MainApplication.getOkHttpClient().newCall(request).enqueue(callback);
    }
    private static void post(boolean usePre, String url, Map<String, String> stringParams, File file, Callback callback) {
        MultipartBody.Builder multipartBody = new MultipartBody.Builder();
        if (stringParams != null)
            for (String key : stringParams.keySet())
                multipartBody.addFormDataPart(key, stringParams.get(key));

        if (file != null)
            multipartBody.addFormDataPart("file", "tmp.jpg", RequestBody.create(MediaType.parse("image/png"), file));
        RequestBody requestBody = multipartBody.setType(MultipartBody.FORM).build();
        Request request;
        if (usePre) {
            request = new Request.Builder().url(urlPrefix + url).post(requestBody).build();
        }else {
            request = new Request.Builder().url(url).post(requestBody).build();
        }
        MainApplication.getOkHttpClient().newCall(request).enqueue(callback);
    }
    public static void get(String url, Callback callback) {
        Request request;
        request = new Request.Builder().url(url).get().build();
        MainApplication.getOkHttpClient().newCall(request).enqueue(callback);
    }
}
