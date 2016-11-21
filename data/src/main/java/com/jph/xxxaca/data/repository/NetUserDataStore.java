package com.jph.xxxaca.data.repository;

import com.jph.xxxaca.data.entity.UserDetail;
import com.jph.xxxaca.data.net.APIManager;

import rx.Observable;

/**
 * Created by jph on 2016/9/30.
 */

public class NetUserDataStore implements IUserData {

    private APIManager mAPIManager;

//    @Inject
    public NetUserDataStore(APIManager APIManager) {
        mAPIManager = APIManager;
    }

    @Override
    public Observable<UserDetail> getUserDetail(String userId) {
//        return Observable.just(new UserDetail("我来自网络"));
        return mAPIManager.userDetail(userId);
    }
}
