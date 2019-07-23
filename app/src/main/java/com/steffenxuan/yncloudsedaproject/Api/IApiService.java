package com.steffenxuan.yncloudsedaproject.Api;

import com.steffenxuan.yncloudsedaproject.Bean.TestBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by Steffen_xuan on 2019/7/22.
 * http://yyyxuan.cn/lay-eggs/androidtest.php
 */

public interface IApiService {
    @POST("/lay-eggs/androidtest.php")
    Observable<TestBean> getData(@Query("time") String time);
}
