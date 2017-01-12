package com.werb.permissionschecker;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.provider.Settings;
import android.support.v7.app.AlertDialog;

/**
 * Created by wanbo on 2017/1/12.
 */

public class PermissionDialog {

    private AlertDialog.Builder builder;
    private Activity activity;
    private String title;
    private String message;
    private static final String PACKAGE_URL_SCHEME = "package:";

    public PermissionDialog(Activity activity) {
        this.activity = activity;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    private String getTitle() {
        if (PermissionsUtils.isEmpty(title)) {
            return activity.getString(R.string.check_info_title);
        } else {
            return title;
        }
    }

    private String getMessage() {
        if (PermissionsUtils.isEmpty(message)) {
            return activity.getString(R.string.check_info_message);
        } else {
            return message;
        }
    }

    public void init() {
        builder = new AlertDialog.Builder(activity);
        builder.setTitle(getTitle());
        builder.setMessage(getMessage());

        builder.setNegativeButton(activity.getString(R.string.check_info_exit), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        builder.setPositiveButton(activity.getString(R.string.check_info_setting), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                startAppSettings();
            }
        });
    }

    public void show() {
        builder.show();
    }

    private void startAppSettings() {
        Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
        intent.setData(Uri.parse(PACKAGE_URL_SCHEME + activity.getPackageName()));
        activity.startActivity(intent);
    }
}
