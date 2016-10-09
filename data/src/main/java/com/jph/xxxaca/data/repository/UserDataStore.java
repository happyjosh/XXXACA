package com.jph.xxxaca.data.repository;

import com.jph.xxxaca.data.entity.UserDetail;

import javax.inject.Inject;

import rx.Observable;

/**
 * Created by jph on 2016/9/30.
 */

public class UserDataStore implements IUserData {
    private UserDataStoreFactory mUserDataStoreFactory;

    @Inject
    public UserDataStore(UserDataStoreFactory userDataStoreFactory) {
        mUserDataStoreFactory = userDataStoreFactory;
    }

    @Override
    public Observable<UserDetail> getUserDetail(int userId) {
        return mUserDataStoreFactory.create().getUserDetail(userId);
    }
}
