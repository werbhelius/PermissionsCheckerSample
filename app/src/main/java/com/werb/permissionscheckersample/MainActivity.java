package com.werb.permissionscheckersample;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.werb.permissionschecker.PermissionChecker;

public class MainActivity extends AppCompatActivity {

    private PermissionChecker permissionChecker;
    static final String[] PERMISSIONS = new String[]{
            Manifest.permission.CALL_PHONE,
            Manifest.permission.READ_EXTERNAL_STORAGE
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        permissionChecker = new PermissionChecker(this);
        permissionChecker.setTitle(getString(R.string.check_info_title));
        permissionChecker.setMessage(getString(R.string.check_info_message));

        Button button = (Button) findViewById(R.id.btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // check if lack Permissions
                if (permissionChecker.isLackPermissions(PERMISSIONS)) {
                    permissionChecker.requestPermissions();
                } else {
                    call();
                }
            }
        });

    }

    private void call() {
        String phone = "123";
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:" + phone));
        startActivity(intent);
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case PermissionChecker.PERMISSION_REQUEST_CODE:
                if (permissionChecker.hasAllPermissionsGranted(grantResults)) {
                    call();
                } else {
                    permissionChecker.showDialog();
                }
                break;
        }
    }
}
