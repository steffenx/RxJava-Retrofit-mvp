package com.steffenxuan.yncloudsedaproject.Subscription;

import io.reactivex.disposables.Disposable;

/**
 * Created by Steffen_xuan on 2019/7/22.
 */

public interface SubscriptionHelper<T> {
    /**
     * 添加
     * @param d
     */
    void add(Disposable d);

    /**
     * 取消
     * @param d
     */
    void cancel(Disposable d);

    /**
     * 取消所有
     */
    void cancelAll();
}
