package com.jph.xxxaca.p;

import com.jph.xxxaca.data.entity.UserDetail;
import com.jph.xxxaca.domain.interactor.UseCase;
import com.jph.xxxaca.v.IUserDetailView;

import javax.inject.Inject;
import javax.inject.Named;

import rx.Subscriber;

/**
 * Created by jph on 2016/9/30.
 */

public class UserDetailPresenter {

    UseCase mUserUseCase;
    IUserDetailView mUserDetailView;

    @Inject
    public UserDetailPresenter(@Named(value = "UserDetail") UseCase userUseCase, IUserDetailView userDetailView) {
        mUserUseCase = userUseCase;
        mUserDetailView = userDetailView;
    }

    public void loadUserDetail() {
        mUserUseCase.execute(new Subscriber<UserDetail>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(UserDetail userDetail) {
                mUserDetailView.showUserName(userDetail.getName());
            }
        });
    }
}
