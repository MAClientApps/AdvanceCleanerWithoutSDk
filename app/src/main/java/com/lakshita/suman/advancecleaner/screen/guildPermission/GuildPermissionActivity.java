package com.lakshita.suman.advancecleaner.screen.guildPermission;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.widget.TextView;

import com.lakshita.suman.advancecleaner.R;
import com.lakshita.suman.advancecleaner.screen.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GuildPermissionActivity extends BaseActivity {

    private static final String PERMISSION_NAME = "permission name";
    @BindView(R.id.tv_content)
    TextView tvContent;

    public static void openActivityGuildPermission(Context mContext, String permissionName) {
        Intent mIntent = new Intent(mContext, GuildPermissionActivity.class);
        mIntent.putExtra(PERMISSION_NAME, permissionName);
        mContext.startActivity(mIntent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide_setting);
        ButterKnife.bind(this);
        findViewById(R.id.ic_close).setOnClickListener(view -> finish());
        findViewById(R.id.layout_padding).setOnClickListener(view -> finish());
        initView();
    }

    private void initView() {
        String permissionName = getIntent().getStringExtra(PERMISSION_NAME);
        if (permissionName.equals(Settings.ACTION_MANAGE_OVERLAY_PERMISSION)) {
            tvContent.setText(getString(R.string.find_and_grant, getString(R.string.app_name), getString(R.string.floatint_windown_per)));
        } else if (permissionName.equals(Settings.ACTION_ACCESSIBILITY_SETTINGS)) {
            tvContent.setText(getString(R.string.find_and_grant, getString(R.string.app_name), getString(R.string.accessibility_permission)));
        } else if (permissionName.equals(Settings.ACTION_NOTIFICATION_LISTENER_SETTINGS)) {
            tvContent.setText(getString(R.string.find_and_grant, getString(R.string.app_name), getString(R.string.listener_notification_per)));
        } else if (permissionName.equals(Settings.ACTION_MANAGE_WRITE_SETTINGS)) {
            tvContent.setText(getString(R.string.find_and_grant, getString(R.string.app_name), getString(R.string.write_setting_per)));
        } else if (permissionName.equals(Settings.ACTION_USAGE_ACCESS_SETTINGS)) {
            tvContent.setText(getString(R.string.find_and_grant, getString(R.string.app_name), getString(R.string.usage_access_permission)));
        }
    }
}
