package com.steffenxuan.yncloudsedaproject.MVP;

/**
 * Created by Steffen_xuan on 2019/7/22.
 */

public class BasePresenter<V extends BaseView> {
    public V view;

    /**
     * 添加view
     * @param v
     */
    public void addView(V v){
        this.view=v;
    }

    /**
     * 解除
     */
    public  void breakView(){
        if (view!=null){
            view=null;
        }
    }
}
