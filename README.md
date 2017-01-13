# PermissionsChecker

[![License](https://img.shields.io/badge/license-Apache%202-green.svg)](https://github.com/Werb/PermissionsCheckerSample/blob/master/LICENSE)
[![Download](https://api.bintray.com/packages/werbhelius/maven/permissionschecker/images/download.svg) ](https://bintray.com/werbhelius/maven/permissionschecker/_latestVersion)

A Library help u to check permissions on Android M.

[中文版](https://github.com/Werb/PermissionsCheckerSample/blob/master/README_ZH.md)

## Screenshot

<img src="/screenshot/home_en.png" alt="screenshot" title="home" width="270" height="486" /> <img src="/screenshot/permission_en.png" alt="screenshot" title="permission" width="270" height="486" />

<img src="/screenshot/info_en.png" alt="screenshot" title="info" width="270" height="486" /> <img src="/screenshot/setting_en.png" alt="screenshot" title="setting" width="270" height="486" />

## Dependency

#### Gradle

```
  compile 'com.werb.permissionschecker:permissionschecker:last-version'
```

#### Maven

```
  <dependency>
      <groupId>com.werb.permissionschecker</groupId>
      <artifactId>permissionschecker</artifactId>
      <version>last-version</version>
      <type>pom</type>
  </dependency>
```

## Usage

* First ：initialize an array of permissions (and  statement in AndroidManifest.xml)

```
  static final String[] PERMISSIONS = new String[]{
            Manifest.permission.CAMERA,
            Manifest.permission.READ_EXTERNAL_STORAGE
    };
```

* Second ：initialize PermissionsChecker

```
  permissionChecker = new PermissionChecker(this); // initialize，must need
  permissionChecker.setTitle(getString(R.string.check_info_title)); // info when user refuse the Permissions ask not must need
  permissionChecker.setMessage(getString(R.string.check_info_message)); // we have default value , just as screenshot
```

* Third ：check Permissions

```
  // check if lack Permissions
  if (permissionChecker.isLackPermissions(PERMISSIONS)) {
        permissionChecker.requestPermissions();
  } else {
        // 执行你的相关操作
  }
```

* Fourth ：Permissions call back

```
  @Override
  public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
      switch (requestCode) {
          case PermissionChecker.PERMISSION_REQUEST_CODE:
              if (permissionChecker.hasAllPermissionsGranted(grantResults)) {
                  // do something u want
              } else {
                  // show dialog when refuse the Permissions
                  permissionChecker.showDialog();
              }
              break;
      }
  }
```

## Bug
Part of the domestic mobile phone to modify the permissions settings, if any abnormal circumstances, please contact me with issue, thank you
#### Known bug
Here will collect some known issues, if there is a good suggest, please contact me with issue

* request android.permission.CALL_PHONE 时，if u call number with “ intent.setAction(Intent.ACTION_CALL) ” ，Mi Phone will disregard the permission request instead execute their own permission settings

## License

[Apache2.0](https://github.com/Werb/PermissionsCheckerSample/blob/master/LICENSE)
