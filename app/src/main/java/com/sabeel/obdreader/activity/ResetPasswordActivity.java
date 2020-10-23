package com.sabeel.obdreader.activity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.sabeel.obdreader.GeneralClasses.Global;
import com.sabeel.obdreader.R;

import static androidx.constraintlayout.widget.Constraints.TAG;

public class ResetPasswordActivity extends Activity implements View.OnClickListener {

    private TextView lbl_enter_your_email_address;
    private EditText txt_user_email;
    private Button btn_send;
    private ImageView btn_back;
    private Global global;
    private TextView versionText;
    private String txt_user_email_txt;


    private void Init() {
        lbl_enter_your_email_address = (TextView) findViewById(R.id.lbl_enter_your_email_address);
        global.SetView(ResetPasswordActivity.this, lbl_enter_your_email_address, false, true);

        txt_user_email = (EditText) findViewById(R.id.txt_user_email);
        global.SetView(ResetPasswordActivity.this, txt_user_email, false);

        btn_send = (Button) findViewById(R.id.btn_send);
        global.SetView(ResetPasswordActivity.this, btn_send, false, true);
        btn_send.setOnClickListener(this);

        btn_back = (ImageView) findViewById(R.id.btn_back);
        btn_back.setOnClickListener(this);


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resetpassword);
        Init();


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_send:
                global.HideKeyBoard(ResetPasswordActivity.this, v);

                if (fields_validation() == false) {

                } else {
                    if (Global.CheckInternetConnectivity(ResetPasswordActivity.this)) {
                        FirebaseAuth.getInstance().sendPasswordResetEmail(txt_user_email.getText().toString())
                                .addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task) {
                                        if (task.isSuccessful()) {
                                            Toast.makeText(getApplicationContext(), "Password reset email sent", Toast.LENGTH_SHORT).show();
                                            Log.d(TAG, "Email sent.");
                                            onBackPressed();
                                        }
                                    }
                                });
                    }
                }
                break;


            case R.id.btn_back:
                global.HideKeyBoard(ResetPasswordActivity.this, v);
                global.changeActivity(ResetPasswordActivity.this, new LoginActivity());
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                finish();
                break;
        }
    }

/*    private void ResetPassword() {

        global.mKProgressHUD = KProgressHUD.create(ResetPasswordActivity.this).setStyle(KProgressHUD.Style.SPIN_INDETERMINATE).setDimAmount(0.7f).setAnimationSpeed(2).setLabel("Please Wait").setCancellable(true);
        global.mKProgressHUD.show();

        mCB1 = new WebServicesPostData.myCallback() {
            @Override
            public void onServiceResponse(String returnJson) throws JSONException {

                Log.d("response_Resetpassword", returnJson.toString());

                if (returnJson.startsWith("<!DOCTYPE html>")) {
                    global.mKProgressHUD.dismiss();
                    global.changeActivity(ResetPasswordActivity.this, new DialogActivity());
                    overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                }


                global.jsonObject = new JSONObject(returnJson);
                String result = global.jsonObject.getString("result");

                if (result.equals("error")) {
                    global.mKProgressHUD.dismiss();
                    String message = global.jsonObject.getString("message");
                    Toast.makeText(ResetPasswordActivity.this, message, Toast.LENGTH_LONG).show();
                } else {
                    global.isSend = 1;
                    global.mKProgressHUD.dismiss();
                    global.changeActivity(ResetPasswordActivity.this, new ThankyouActivity());
                    overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                    finish();
                }

            }
        };

        try {

            PreferencesHandler preferencesHandler = new PreferencesHandler(ResetPasswordActivity.this);

            myServiec = new WebServicesPostData(ResetPasswordActivity.this,
                    preferencesHandler.getBaseUrl() + "/fgpwd.php", "email=" + txt_user_email.getText().toString(), 3, mCB1);

        } catch (Exception ex) {

            Log.e("response_error", ex.getMessage());
        }

    }*/

    public boolean fields_validation() {
        boolean valid = true;

        txt_user_email_txt = txt_user_email.getText().toString();


        if (txt_user_email_txt.isEmpty() || !txt_user_email_txt.matches(global.emailPattern)) {
            Toast.makeText(ResetPasswordActivity.this, R.string.rd_email, Toast.LENGTH_SHORT).show();
            valid = false;
        }


        return valid;
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        Global.ReleaseMemoryOnDestory();
    }

    @Override
    protected void onResume() {
        // TODO Auto-generated method stub
        super.onResume();
    }


    @Override
    public void onBackPressed() {
//        super.onBackPressed();

        global.changeActivity(ResetPasswordActivity.this, new LoginActivity());
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        finish();
    }

}
