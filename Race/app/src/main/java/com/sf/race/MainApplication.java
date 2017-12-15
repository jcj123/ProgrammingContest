package com.sf.race;

import android.app.Application;
import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;



public class MainApplication extends Application {

    private static OkHttpClient okHttpClient;
    private static Context mContext = null;
    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();
        okHttpClient = new OkHttpClient.Builder()
                .cookieJar(new CookieJar() {
                    private List<Cookie> cookies = null;

                    @Override
                    public void saveFromResponse(HttpUrl url, List<Cookie> cookies) {

                        this.cookies = cookies;
                    }

                    @Override
                    public List<Cookie> loadForRequest(HttpUrl url) {
                        return cookies != null ? cookies : new ArrayList<Cookie>();
                    }
                })
                .build();
    }
    public  static Context getContextObject(){
        return mContext;
    }

    //直接调用
    public static OkHttpClient getOkHttpClient() {
        return okHttpClient;
    }

}
