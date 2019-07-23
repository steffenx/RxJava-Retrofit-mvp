package com.steffenxuan.yncloudsedaproject.Subscription;

import io.reactivex.CompletableConverter;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * Created by Steffen_xuan on 2019/7/22.
 */

public class SubscriptionManager implements SubscriptionHelper<Object> {

    public static SubscriptionManager subscriptionManager;
    private CompositeDisposable mDisposables;//存放disposable容器

    /**
     * 构造函数 new CompositeDisposable对象
     */
    public SubscriptionManager(){
        if (mDisposables==null){
            mDisposables=new CompositeDisposable();
        }
    }

    /**
     * 单例
     * @return
     */
    public static SubscriptionManager getInstance(){
        if (subscriptionManager==null){
            synchronized (SubscriptionManager.class){
                if (subscriptionManager==null){
                    subscriptionManager=new SubscriptionManager();
                }
            }
        }
        return subscriptionManager;
    }

    /**
     * 订阅事件加入到CompositeDisposable容器中
     * @param disposable 订阅事件
     */
    @Override
    public void add(Disposable disposable) {
        if(disposable==null) return;
        mDisposables.add(disposable);
    }

    /**
     * 取消订阅事件
     * @param disposable 订阅事件
     */
    @Override
    public void cancel(Disposable disposable) {
        if (disposable!=null){
            mDisposables.delete(disposable);
        }
    }

    /**
     * 清除容器所有
     */
    @Override
    public void cancelAll() {
        if (mDisposables!=null){
            mDisposables.clear();
        }
    }
}
