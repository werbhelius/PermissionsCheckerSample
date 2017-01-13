# PermissionsChecker

[![License](https://img.shields.io/badge/license-Apache%202-green.svg)](https://github.com/Werb/PermissionsCheckerSample/blob/master/LICENSE)
[![Download](https://api.bintray.com/packages/werbhelius/maven/permissionschecker/images/download.svg) ](https://bintray.com/werbhelius/maven/permissionschecker/_latestVersion)

一个帮助你完成 Android M 运行时权限检查的库。

[English Version](https://github.com/Werb/PermissionsCheckerSample/blob/master/README.md)

## Screenshot

<img src="/screenshot/home_zh.png" alt="screenshot" title="主界面" width="270" height="486" /> <img src="/screenshot/permission_zh.png" alt="screenshot" title="权限检查" width="270" height="486" />

<img src="/screenshot/info_zh.png" alt="screenshot" title="拒绝权限提示" width="270" height="486" /> <img src="/screenshot/setting_zh.png" alt="screenshot" title="设置界面" width="270" height="486" />

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

* 第一步：在需要相关权限的地方定义权限数组(同时在 AndroidManifest.xml 中声明)

```
  static final String[] PERMISSIONS = new String[]{
            Manifest.permission.CAMERA,
            Manifest.permission.READ_EXTERNAL_STORAGE
    };
```

* 第二步：初始化 PermissionsChecker

```
  permissionChecker = new PermissionChecker(this); // 初始化，必需
  permissionChecker.setTitle(getString(R.string.check_info_title)); // 权限拒绝后的提示，非必需
  permissionChecker.setMessage(getString(R.string.check_info_message)); // 不写会有默认值，如上方截图所示
```

* 第三步：判断权限

```
  // check if lack Permissions
  if (permissionChecker.isLackPermissions(PERMISSIONS)) {
        permissionChecker.requestPermissions();
  } else {
        // 执行你的相关操作
  }
```

* 第四步：权限回调

```
  @Override
  public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
      switch (requestCode) {
          case PermissionChecker.PERMISSION_REQUEST_CODE:
              if (permissionChecker.hasAllPermissionsGranted(grantResults)) {
                  // 执行你的相关操作
              } else {
                  // 权限拒绝后的提示
                  permissionChecker.showDialog();
              }
              break;
      }
  }
```

## Bug
部分国产手机修改了权限设置，若有异常情况出现，请及时提 issue 联系我 ，谢谢
#### 已知问题
这里会收集一些已知问题，若有很好的处理方法，也请及时提 issue 联系我

* 申请 android.permission.CALL_PHONE 时，当遇到 intent.setAction(Intent.ACTION_CALL) 小米手机会走自己的权限提示

## License

[Apache2.0](https://github.com/Werb/PermissionsCheckerSample/blob/master/LICENSE)
