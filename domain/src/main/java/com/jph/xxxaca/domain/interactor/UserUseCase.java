package com.jph.xxxaca.domain.interactor;

import com.jph.xxxaca.data.repository.IUserData;

import javax.inject.Inject;

import rx.Observable;

/**
 * Created by jph on 2016/9/30.
 */

public class UserUseCase extends UseCase {

    private String mUserId;
    private IUserData mIUserData;

    @Inject
    public UserUseCase(String userId, IUserData IUserData) {
        mUserId = userId;
        mIUserData = IUserData;
    }

    @Override
    public Observable buildUseCaseObservable() {
        return mIUserData.getUserDetail(mUserId);
    }
}
