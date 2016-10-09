package com.jph.xxxaca.data.repository;

import javax.inject.Inject;

/**
 * Created by jph on 2016/9/30.
 */

public class UserDataStoreFactory {

    @Inject
    public UserDataStoreFactory() {
    }

    public IUserData create() {
        return new NetUserDataStore();
    }
}
