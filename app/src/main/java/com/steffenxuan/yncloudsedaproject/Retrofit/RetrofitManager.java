package com.steffenxuan.yncloudsedaproject.Retrofit;

import android.print.PrintJob;
import android.util.Log;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.steffenxuan.yncloudsedaproject.Api.IApiService;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Steffen_xuan on 2019/7/22.
 */

public class RetrofitManager {
    private static RetrofitManager retrofitManager;
    private Retrofit retrofit;
    private static final String BASE_URL="http://yyyxuan.cn";
    private IApiService apiService;

    /**
     * 单例模式
     * @return
     */
    public static RetrofitManager getInstance (){
        if (retrofitManager==null){
            synchronized (RetrofitManager.class){
                if (retrofitManager==null){
                    retrofitManager= new RetrofitManager();
                }
            }
        }
        return retrofitManager;
    }

    private RetrofitManager(){
        initRetrofitManager();
    }

    private void initRetrofitManager() {

        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(new HttpLoggingInterceptor(
                        new HttpLoggingInterceptor.Logger() {
                            @Override
                            public void log(String message) {
                                Log.d("retrofit:", message);
                            }
                        }
                ).setLevel(HttpLoggingInterceptor.Level.BODY))
                .addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        Request original = chain.request();
                        Request request = original.newBuilder()
                                .header("Content-Type", "application/x-www-form-urlencoded")
                                .method(original.method(), original.body())
                                .build();
                        return chain.proceed(request);
                    }
                })
                .connectTimeout(10000, TimeUnit.MILLISECONDS)
                .build();
        //创建Retrofit实例
        retrofit=new Retrofit.Builder().baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        apiService=retrofit.create(IApiService.class);
    }


    public IApiService apiservice(){return apiService;}

}
