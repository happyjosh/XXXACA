package com.jph.xxxaca.data.repository;

import com.jph.xxxaca.data.entity.UserDetail;

import rx.Observable;

/**
 * 缓存用户数据提供
 * Created by jph on 2016/11/21.
 */
public class CacheUserDataStore implements IUserData {
    @Override
    public Observable<UserDetail> getUserDetail(String userId) {
        return Observable.just(new UserDetail("我来自缓存"));
    }
}
