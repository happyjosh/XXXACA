package com.jph.xxxaca.v;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.jph.xxxaca.App;
import com.jph.xxxaca.R;
import com.jph.xxxaca.di.component.DaggerUserComponent;
import com.jph.xxxaca.di.module.UserModule;
import com.jph.xxxaca.p.UserDetailPresenter;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by jph on 2016/9/30.
 */

public class UserDetailActivity extends AppCompatActivity implements IUserDetailView {

    @Inject
    UserDetailPresenter mUserDetailPresenter;

    @Bind(R.id.user_detail_txt_name)
    TextView mNameTxt;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_detail);
        ButterKnife.bind(this);

        DaggerUserComponent.builder()
                .appComponent(((App) getApplication()).getAppComponent())
                .userModule(new UserModule(this, 1)).build().inject(this);
    }

    @OnClick(R.id.user_detail_btn_load)
    public void OnLoadClick(View v) {
        mUserDetailPresenter.loadUserDetail();
    }

    @Override
    public void showUserName(String name) {
        mNameTxt.setText(name);
    }
}
