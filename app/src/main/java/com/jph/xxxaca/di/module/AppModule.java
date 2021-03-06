package com.jph.xxxaca.di.module;

import android.content.Context;

import com.jph.xxxaca.data.net.APIManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by jph on 2016/9/30.
 */
@Module
public class AppModule {
    private Context mContext;

    public AppModule(Context context) {
        mContext = context;
    }

    @Singleton
    @Provides
    public Context provideContext() {
        return mContext;
    }

    @Singleton
    @Provides
    public APIManager provideAPIManager() {
        return new APIManager();
    }
}
