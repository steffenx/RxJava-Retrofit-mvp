package com.steffenxuan.yncloudsedaproject.MVP.Model;

import com.steffenxuan.yncloudsedaproject.Bean.TestBean;
import com.steffenxuan.yncloudsedaproject.Retrofit.RetrofitManager;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Steffen_xuan on 2019/7/22.
 */

public class TestModel {
    /**
     * 网络请求，添加订阅关系
     * @param time
     * @param observer
     */
    public void getTestInfo(String time, Observer<TestBean> observer){
        RetrofitManager.getInstance().apiservice().getData(time)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(observer);
    }
}
