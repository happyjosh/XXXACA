package com.jph.xxxaca.data.repository;

import com.jph.xxxaca.data.entity.UserDetail;

import rx.Observable;

/**
 * Created by jph on 2016/9/30.
 */

public interface IUserData {

    Observable<UserDetail> getUserDetail(int userId);
}
