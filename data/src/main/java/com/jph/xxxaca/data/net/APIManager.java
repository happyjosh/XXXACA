package com.jph.xxxaca.data.net;

import com.jph.xxxaca.data.entity.UserDetail;

import rx.Observable;

/**
 * 管理接口请求的类
 * Created by jph on 2016/11/18.
 */
public class APIManager extends RetrofitWrapper {

    public Observable<UserDetail> userDetail(String userId) {
        return getAPIService().userDetail(userId)
                .compose(this.<UserDetail>getTransformer());
    }

}
