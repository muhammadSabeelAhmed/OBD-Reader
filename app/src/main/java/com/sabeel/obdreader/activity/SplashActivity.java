package com.sabeel.obdreader.activity;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.sabeel.obdreader.GeneralClasses.Global;
import com.sabeel.obdreader.GeneralClasses.PreferencesHandler;
import com.sabeel.obdreader.R;

public class SplashActivity extends Activity {

    Handler handler;
    PreferencesHandler preferencesHandler;
    Global global;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        handler = new Handler();

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE)
                + ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                + ActivityCompat.checkSelfPermission(this, Manifest.permission.BLUETOOTH)
                + ActivityCompat.checkSelfPermission(this, Manifest.permission.BLUETOOTH_ADMIN)
                + ActivityCompat.checkSelfPermission(this, Manifest.permission.WAKE_LOCK)
                + ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                + ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION)
                + ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_LOCATION_EXTRA_COMMANDS)
                + ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_LOGS) == PackageManager.PERMISSION_GRANTED) {
            init();

        } else {
            requestForSpecificPermission();
        }
    }


    private void init() {

        handler.postDelayed(new Runnable() {
            public void run() {

                preferencesHandler = new PreferencesHandler(SplashActivity.this);

                if (preferencesHandler.getAppFirstTime().equals("true")) {
                    preferencesHandler.setBaseurl("https://discoveritech.org/");
                    preferencesHandler.setAppFirstTime("false");

                    if (preferencesHandler.getIsautocheck().equals("false") && preferencesHandler.getUemail().equals("") && preferencesHandler.getUpwd().equals("")) {
                        global.changeActivity(SplashActivity.this, new LoginActivity());
                        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                        finish();
                    } else if (preferencesHandler.getIsautocheck().equals("true") && preferencesHandler.getUemail().equals("") && preferencesHandler.getUpwd().equals("")) {

                        global.changeActivity(SplashActivity.this, new LoginActivity());
                        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                        finish();
                    } else if (preferencesHandler.getIsautocheck().equals("true") && !preferencesHandler.getUemail().equals("") && !preferencesHandler.getUpwd().equals("")) {
                        Global.myEmail = preferencesHandler.getUemail();
                        global.changeActivity(SplashActivity.this, new MainActivity());
                        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                        finish();

                    } else if (preferencesHandler.getIsautocheck().equals("false") && !preferencesHandler.getUemail().equals("") && !preferencesHandler.getUpwd().equals("")) {
                        global.changeActivity(SplashActivity.this, new LoginActivity());
                        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                        finish();
                    }


                } else {

                    if (preferencesHandler.getIsautocheck().equals("false") && preferencesHandler.getUemail().equals("") && preferencesHandler.getUpwd().equals("")) {

                        global.changeActivity(SplashActivity.this, new LoginActivity());
                        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                        finish();
                    } else if (preferencesHandler.getIsautocheck().equals("true") && preferencesHandler.getUemail().equals("") && preferencesHandler.getUpwd().equals("")) {

                        global.changeActivity(SplashActivity.this, new LoginActivity());
                        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                        finish();
                    } else if (preferencesHandler.getIsautocheck().equals("true") && !preferencesHandler.getUemail().equals("") && !preferencesHandler.getUpwd().equals("")) {
                        Global.myEmail = preferencesHandler.getUemail();
                        global.changeActivity(SplashActivity.this, new MainActivity());
                        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                        finish();


                    } else if (preferencesHandler.getIsautocheck().equals("false") && !preferencesHandler.getUemail().equals("") && !preferencesHandler.getUpwd().equals("")) {

                        global.changeActivity(SplashActivity.this, new LoginActivity());
                        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                        finish();
                    }
                }

              /*  if (AdminHomeFragment.isSignout == false && preferencesHandler.getUemail().equals("admin@admin.com")) {
                    global.changeActivity(SplashActivity.this, new AdminDashboardActivity());
                    overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                    finish();
                }*/ /*else {
                    global.changeActivity(SplashActivity.this, new ClientDashboardActivity());
                    overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                    finish();
                }*/
            }

        }, 2000);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Global.ReleaseMemoryOnDestory();
    }

    private void requestForSpecificPermission() {
        ActivityCompat.requestPermissions(this, new String[]{
                Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.BLUETOOTH,
                Manifest.permission.BLUETOOTH_ADMIN,
                Manifest.permission.WAKE_LOCK,
                Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.ACCESS_COARSE_LOCATION,
                Manifest.permission.ACCESS_LOCATION_EXTRA_COMMANDS,
                Manifest.permission.READ_LOGS
        }, 101);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        Log.d("PermissionGrantedCode", "" + requestCode + "Grant Result" + grantResults.length);
        switch (requestCode) {
            case 101: {
                for (int i = 0; i <= grantResults.length - 1; i++) {
                    Log.d("PermissionGrantedCode", i + "mycheck" + grantResults[i]);
                }
                if ((grantResults.length >= 9) &&
                        grantResults[0] == PackageManager.PERMISSION_GRANTED &&
                        grantResults[1] == PackageManager.PERMISSION_GRANTED &&
                        grantResults[2] == PackageManager.PERMISSION_GRANTED &&
                        grantResults[3] == PackageManager.PERMISSION_GRANTED &&
                        grantResults[4] == PackageManager.PERMISSION_GRANTED &&
                        grantResults[5] == PackageManager.PERMISSION_GRANTED &&
                        grantResults[6] == PackageManager.PERMISSION_GRANTED &&
                        grantResults[7] == PackageManager.PERMISSION_GRANTED) {
                    init();
                } else {
                    Toast.makeText(SplashActivity.this, "All Permissions required.", Toast.LENGTH_SHORT).show();
                    requestForSpecificPermission();
                }
                return;
            }
        }
    }
}
