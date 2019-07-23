package com.steffenxuan.yncloudsedaproject.MVP.Presenter;

import com.steffenxuan.yncloudsedaproject.Bean.TestBean;
import com.steffenxuan.yncloudsedaproject.Error.ExceptionHandle;
import com.steffenxuan.yncloudsedaproject.MVP.BasePresenter;
import com.steffenxuan.yncloudsedaproject.MVP.BaseView;
import com.steffenxuan.yncloudsedaproject.MVP.Model.Observer;
import com.steffenxuan.yncloudsedaproject.MVP.Model.TestModel;
import com.steffenxuan.yncloudsedaproject.Subscription.SubscriptionManager;

import io.reactivex.disposables.Disposable;

/**
 * Created by Steffen_xuan on 2019/7/22.
 */

public class TestPresenter extends BasePresenter<BaseView> {
    private TestModel testModel;
    /**
     * 绑定M层
     */
    public TestPresenter (){
        testModel=new TestModel();
    }

    public void test(String time){
        //网络请求，创建观察者
        testModel.getTestInfo(time, new Observer<TestBean>() {
            @Override
            protected void OnDisposable(Disposable d) {
                SubscriptionManager.getInstance().add(d);
            }

            @Override
            protected void OnSuccess(TestBean testBean) {
                view.onSuccess(testBean);
            }

            @Override
            protected void OnFail(ExceptionHandle.ResponseException e) {
                view.onFail(e);
            }

            @Override
            protected void OnCompleted() {
                view.onCompleted();
            }
        });
    }

}
