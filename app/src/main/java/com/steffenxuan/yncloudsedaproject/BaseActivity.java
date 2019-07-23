package com.steffenxuan.yncloudsedaproject;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.steffenxuan.yncloudsedaproject.MVP.BasePresenter;
import com.steffenxuan.yncloudsedaproject.MVP.BaseView;
import com.steffenxuan.yncloudsedaproject.Subscription.SubscriptionManager;

/**
 * Created by Steffen_xuan on 2019/7/22.
 */

public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity implements BaseView {
    public Context context;
    protected P presenter;

    //获取P层
    protected abstract P createPresenter();
    //获取是哪个activity
    protected abstract int getLayoutId();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context=this;
        setContentView(getLayoutId());
        presenter=createPresenter();
        presenter.addView(this);
        initView();
        initData();
    }

    public void initData(){

    };

    public void initView(){

    };

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (presenter != null) {
            presenter.breakView();
            SubscriptionManager.getInstance().cancelAll();
        }
    }
}
