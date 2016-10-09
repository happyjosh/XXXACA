package com.jph.xxxaca.data.repository;

import com.jph.xxxaca.data.entity.UserDetail;

import rx.Observable;

/**
 * Created by jph on 2016/9/30.
 */

public class NetUserDataStore implements IUserData {
    @Override
    public Observable<UserDetail> getUserDetail(int userId) {
        //TODO
        return Observable.just(new UserDetail("手动生成的"));
    }
}
