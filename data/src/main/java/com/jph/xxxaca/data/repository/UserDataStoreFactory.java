package com.jph.xxxaca.data.repository;

import javax.inject.Inject;

import dagger.Lazy;

/**
 * Created by jph on 2016/9/30.
 */

public class UserDataStoreFactory {

    @Inject
    Lazy<NetUserDataStore> mNetUserDataStoreLazy;
    @Inject
    Lazy<CacheUserDataStore> mCacheUserDataStoreLazy;


    @Inject
    public UserDataStoreFactory() {
    }

    public IUserData create() {
        //TODO判断数据渠道
        if (true) {
            return mNetUserDataStoreLazy.get();
        }

        return mCacheUserDataStoreLazy.get();
    }
}
