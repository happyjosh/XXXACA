package com.jph.xxxaca.di.component;

import android.content.Context;

import com.jph.xxxaca.di.module.AppModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by jph on 2016/9/30.
 */
@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {

    Context getContext();
}
