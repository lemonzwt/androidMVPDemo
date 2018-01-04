package cn.lemon.mvp;

import android.Manifest;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.jakewharton.rxbinding.view.RxView;
import com.tbruyelle.rxpermissions.Permission;
import com.tbruyelle.rxpermissions.RxPermissions;

import rx.functions.Action0;
import rx.functions.Action1;

/**
 * Created by lemon on 2018/1/4.
 */

public class RxPermissionsActivity extends AppCompatActivity {
    final String TAG="RxPermissionsActivity";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rx_permissions);
        RxPermissions rxPermissions = new RxPermissions(this);
        rxPermissions.setLogging(true);
//        //直接申请单个权限
//        rxPermissions.request(Manifest.permission.CAMERA)
//                .subscribe(new Action1<Boolean>() {
//                    @Override
//                    public void call(Boolean granted) {
//                        if(granted)
//                        {
//                            //已经获取权限，6.0之前默认返回true
//                        }
//                        else {
//                            //没有获取权限
//                        }
//                    }
//                });
        //直接申请多个权限
//        rxPermissions.request(Manifest.permission.CAMERA, Manifest.permission.RECORD_AUDIO)
//                        .subscribe(new Action1<Boolean>() {
//                            @Override
//                            public void call(Boolean granted) {
//
//                            }
//                        });
        //点击按钮申请权限
        RxView.clicks(findViewById(R.id.btnCamera))
                .compose(rxPermissions.ensureEach(Manifest.permission.CAMERA))
                .subscribe(new Action1<Permission>() {
                    @Override
                    public void call(Permission permission) {
                        Log.i(TAG, "Permission result " + permission);
                        if(permission.granted)
                        {
                            //已经获取权限，6.0之前默认返回true
                        }
                        else {
                            //没有获取权限
                        }
                    }
                });
    }
}
