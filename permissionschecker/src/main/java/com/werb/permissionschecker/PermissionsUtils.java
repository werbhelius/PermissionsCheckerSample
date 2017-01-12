package com.werb.permissionschecker;

import android.text.TextUtils;

/**
 * Created by wanbo on 2017/1/12.
 */

public class PermissionsUtils {

    public static boolean isEmpty(String src) {
        if (TextUtils.isEmpty(src)) {
            return true;
        } else {
            return false;
        }
    }
}
