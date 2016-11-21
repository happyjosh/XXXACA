package com.jph.xxxaca.data.net;

import com.jph.xxxaca.data.entity.APIResponse;
import com.jph.xxxaca.data.entity.UserDetail;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;

/**
 * 请求接口地址
 * Created by jph on 2016/11/18.
 */
public interface APIService {

    @FormUrlEncoded
    @POST("jphLogin")
    Observable<APIResponse<UserDetail>> userDetail(@Field("userID") String userName);
}
