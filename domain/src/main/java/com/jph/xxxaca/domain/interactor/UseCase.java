package com.jph.xxxaca.domain.interactor;


import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * 所有UseCase父类
 * Created by jph on 2016/9/30.
 */
public abstract class UseCase {
    private Subscription mSubscription;

    public abstract Observable buildUseCaseObservable();

    public void execute(Subscriber subscriber) {
        mSubscription = buildUseCaseObservable()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    public void unsubscribe() {
        if (mSubscription != null && mSubscription.isUnsubscribed()) {
            mSubscription.unsubscribe();
        }
    }
}
