package com.steffenxuan.yncloudsedaproject.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.gson.Gson;
import com.steffenxuan.yncloudsedaproject.BaseActivity;
import com.steffenxuan.yncloudsedaproject.Bean.TestBean;
import com.steffenxuan.yncloudsedaproject.Error.ExceptionHandle;
import com.steffenxuan.yncloudsedaproject.MVP.BaseView;
import com.steffenxuan.yncloudsedaproject.MVP.Presenter.TestPresenter;
import com.steffenxuan.yncloudsedaproject.R;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends BaseActivity<TestPresenter> implements BaseView {
    String TAG="aaa";
    TextView textView;
    Button button;

    /**
     * 绑定p层
     * @return
     */
    @Override
    protected TestPresenter createPresenter() {
        return new TestPresenter();
    }

    /**
     * 加载当前activity
     * @return
     */
    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    /**
     * 成功回调
     * @param object
     */
    @Override
    public void onSuccess(Object object) {
        Log.d(TAG, "onSuccess: "+beanToJson(object));
        TestBean testBean= (TestBean) object;
        textView.setText(testBean.getData().getContent());
    }

    /**
     * 失败回调
     * @param t 异常
     */
    @Override
    public void onFail(ExceptionHandle.ResponseException t) {
        Log.d(TAG, t.message.toString());
    }

    @Override
    public void onCompleted() {

    }

    /**
     * 序列化为json字符串
     * @param bean 对象
     * @return
     */
    public String beanToJson(Object bean) {
        Gson gson = new Gson();
        String jsonStr = gson.toJson(bean);
        return jsonStr;
    }

    /**
     * 初始化界面
     */
    @Override
    public void initView() {
        super.initView();
        textView=findViewById(R.id.mtv);
        button=findViewById(R.id.mbtn);
    }

    /**
     * 初始化数据
     */
    @Override
    public void initData() {
        super.initData();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.test("123");
            }
        });
    }

    //
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//
//        Observable.create(new ObservableOnSubscribe<Integer>() {
//            @Override
//            public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
//                emitter.onNext(1);
//                emitter.onNext(2);
//                emitter.onNext(3);
//                emitter.onComplete();
//            }
//        })
//                .observeOn(AndroidSchedulers.mainThread())//回调在主线程
//                .subscribeOn(Schedulers.io())//执行在io线程
//                .subscribe(new Observer<Integer>() {
//                    @Override
//                    public void onSubscribe(Disposable d) {
//                        Log.d(TAG, "onSubscribe");
//                    }
//
//                    @Override
//                    public void onNext(Integer value) {
//                        Log.d(TAG, "onNext=" + value);
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        Log.d(TAG, "onError");
//                    }
//
//                    @Override
//                    public void onComplete() {
//                        Log.d(TAG, "onComplete");
//                    }
//                });
//
//
//    }
}
