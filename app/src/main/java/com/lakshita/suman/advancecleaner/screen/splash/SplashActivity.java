package com.lakshita.suman.advancecleaner.screen.splash;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.annotation.Nullable;

import com.lakshita.suman.advancecleaner.CleanMasterApp;
import com.lakshita.suman.advancecleaner.R;
import com.lakshita.suman.advancecleaner.screen.BaseActivity;
import com.lakshita.suman.advancecleaner.screen.main.MainActivity;
import com.security.applock.utils.PreferencesHelper;

import butterknife.ButterKnife;

public class SplashActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_1);

        Intent mIntent = new Intent(SplashActivity.this, MainActivity.class);
        startActivity(mIntent);

    }

}
