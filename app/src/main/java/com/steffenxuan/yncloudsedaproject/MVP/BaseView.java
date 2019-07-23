package com.steffenxuan.yncloudsedaproject.MVP;

import com.steffenxuan.yncloudsedaproject.Error.ExceptionHandle;

/**
 * Created by Steffen_xuan on 2019/7/22.
 */

public interface BaseView {

    /**
     * 成功回调
     * @param object
     */
    void onSuccess(Object object);

    /**
     * 失败回调
     * @param t 异常
     */
    void onFail(ExceptionHandle.ResponseException t);

    /**
     * 发射结束
     */
    void onCompleted();
}
