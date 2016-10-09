package com.jph.xxxaca.di.component;

import com.jph.xxxaca.di.module.UserModule;
import com.jph.xxxaca.di.scope.PerActivity;
import com.jph.xxxaca.v.UserDetailActivity;

import dagger.Component;

/**
 * Created by jph on 2016/9/30.
 */

@PerActivity
@Component(dependencies = AppComponent.class, modules = UserModule.class)
public interface UserComponent {

    void inject(UserDetailActivity userDetailActivity);
}
