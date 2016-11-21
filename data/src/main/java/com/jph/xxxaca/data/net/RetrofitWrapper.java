package com.jph.xxxaca.data.net;

import com.jph.xxxaca.data.entity.APIResponse;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Subscriber;

/**
 * Created by jph on 2016/11/17.
 */
public class RetrofitWrapper {
    private APIService mAPIService;

    public RetrofitWrapper() {
        mAPIService = new Retrofit.Builder()
                .baseUrl("http://testcms.immocha.com/weixin/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build()
                .create(APIService.class);
    }

    public APIService getAPIService() {
        return mAPIService;
    }

    protected <T> Observable.Transformer<APIResponse<T>, T> getTransformer() {
        return (Observable.Transformer<APIResponse<T>, T>) mTransformer;
    }

    private final Observable.Transformer mTransformer = new Observable.Transformer() {
        @Override
        public Object call(Object observable) {
            return ((Observable) observable)
//                    .subscribeOn(Schedulers.io())
//                    .observeOn(AndroidSchedulers.mainThread())
                    .lift(new Observable.Operator<Object, APIResponse>() {
                        @Override
                        public Subscriber<? super APIResponse> call(
                                final Subscriber<? super Object> subscriber) {
                            return new Subscriber<APIResponse>() {
                                @Override
                                public void onCompleted() {

                                }

                                @Override
                                public void onError(Throwable e) {
                                    subscriber.onError(e);
                                }

                                @Override
                                public void onNext(APIResponse response) {
                                    if (response.isSuccess()) {
                                        if (!subscriber.isUnsubscribed()) {
                                            subscriber.onNext(response.getData());
                                        }
                                    } else {
                                        if (!subscriber.isUnsubscribed()) {
                                            subscriber.onError(new APIException(response.getCode(),
                                                    response.getMessage()));
                                        }
                                        return;
                                    }

                                    if (!subscriber.isUnsubscribed()) {
                                        subscriber.onCompleted();
                                    }
                                }
                            };
                        }
                    });
        }
    };
}
