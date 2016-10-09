package com.jph.xxxaca.di.scope;

import java.lang.annotation.Retention;

import javax.inject.Scope;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by jph on 2016/9/30.
 */
@Scope
@Retention(RUNTIME)
public @interface PerActivity {
}
