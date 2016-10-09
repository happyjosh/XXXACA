package com.jph.xxxaca;

import android.app.Application;

import com.jph.xxxaca.di.component.AppComponent;
import com.jph.xxxaca.di.component.DaggerAppComponent;
import com.jph.xxxaca.di.module.AppModule;

/**
 * Created by jph on 2016/9/30.
 */

public class App extends Application {
    private AppComponent mAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        mAppComponent = DaggerAppComponent.builder().appModule(new AppModule(this)).build();
    }

    public AppComponent getAppComponent() {
        return mAppComponent;
    }
}
