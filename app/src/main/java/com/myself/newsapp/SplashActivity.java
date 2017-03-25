package com.myself.newsapp;

import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;

import com.myself.library.controller.BaseActivity;
import com.myself.newsapp.account.AccountHelper;
import com.myself.newsapp.guidance.GuidanceActivity;

/**
 * 闪屏页面
 * Created by Jusenr on 2017/3/25.
 */
public class SplashActivity extends BaseActivity {

    @Override
    protected int getLayoutId() {
        return R.layout.activity_splash;
    }

    @Override
    protected void onViewCreatedFinish(Bundle saveInstanceState) {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }

    @Override
    protected void onResume() {
        super.onResume();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (!AccountHelper.isLogin()) {
                    startActivity(GuidanceActivity.class);
                } else {
                    startActivity(MainActivity.class);
                }
                finish();
            }
        }, 2000);
    }
}
