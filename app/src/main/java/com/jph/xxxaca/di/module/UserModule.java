package com.jph.xxxaca.di.module;

import com.jph.xxxaca.data.repository.UserDataStore;
import com.jph.xxxaca.di.scope.PerActivity;
import com.jph.xxxaca.domain.interactor.UseCase;
import com.jph.xxxaca.domain.interactor.UserUseCase;
import com.jph.xxxaca.v.IUserDetailView;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

/**
 * Created by jph on 2016/9/30.
 */
@Module
public class UserModule {

    private int mUserId;
    private IUserDetailView mUserDetailView;

    public UserModule(IUserDetailView userDetailView, int userId) {
        this.mUserDetailView = userDetailView;
        this.mUserId = userId;
    }

    @Provides
    @PerActivity
    public IUserDetailView provideUserDetailView() {
        return mUserDetailView;
    }

    @Provides
    @PerActivity
    @Named(value = "UserDetail")
    public UseCase provideUserUseCase(UserDataStore userData) {
        return new UserUseCase(mUserId, userData);
    }
}
