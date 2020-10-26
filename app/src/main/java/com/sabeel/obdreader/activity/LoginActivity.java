package com.sabeel.obdreader.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.kaopiz.kprogresshud.KProgressHUD;
import com.sabeel.obdreader.GeneralClasses.Global;
import com.sabeel.obdreader.GeneralClasses.PreferencesHandler;
import com.sabeel.obdreader.R;

public class LoginActivity extends Activity implements View.OnClickListener {
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;
    private FirebaseAuth mAuth;

    private TextView lbl_login;
    private TextView lbl_keep_me_logged_in;
    private EditText txt_username;
    private EditText txt_password;
    private Button btn_login;
    private Button btn_reset_password;
    private TextView btn_create_account;
    private ImageView chk_keep_me_logged_in;
    private ImageView pwd_hide_show;
    private String btn_create_account_txt = "<font color=#000000>Not account yet?</font>" + " " + "<font color=#ffcc00>Sign Up Free</font>";
    private Global global;
    private ScrollView mscrollview;
    private TextView versionText;
    private String txt_user_name_txt;
    private String txt_password_txt;
    private PreferencesHandler preferencesHandler;

    private void Init() {
        mAuth = FirebaseAuth.getInstance();
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("Users");

        preferencesHandler = new PreferencesHandler(LoginActivity.this);

        mscrollview = (ScrollView) findViewById(R.id.mscrollview);

        lbl_login = (TextView) findViewById(R.id.lbl_login);
        global.SetView(LoginActivity.this, lbl_login, false, true);

        lbl_keep_me_logged_in = (TextView) findViewById(R.id.lbl_keep_me_logged_in);
        global.SetView(LoginActivity.this, lbl_keep_me_logged_in, false, true);
        lbl_keep_me_logged_in.setOnClickListener(this);

        txt_username = (EditText) findViewById(R.id.txt_username);
        global.SetView(LoginActivity.this, txt_username, false);

        txt_password = (EditText) findViewById(R.id.txt_password);
        global.SetView(LoginActivity.this, txt_password, false);

        btn_login = (Button) findViewById(R.id.btn_login);
        global.SetView(LoginActivity.this, btn_login, false, true);
        btn_login.setOnClickListener(this);

        btn_reset_password = (Button) findViewById(R.id.btn_reset_password);
        global.SetView(LoginActivity.this, btn_reset_password, false, true);
        btn_reset_password.setOnClickListener(this);

        btn_create_account = (TextView) findViewById(R.id.btn_create_account);
        global.SetView(LoginActivity.this, btn_create_account, false, true);
        btn_create_account.setText(Html.fromHtml(btn_create_account_txt));
        btn_create_account.setOnClickListener(this);

        chk_keep_me_logged_in = (ImageView) findViewById(R.id.chk_keep_me_logged_in);
        chk_keep_me_logged_in.setOnClickListener(this);

        pwd_hide_show = (ImageView) findViewById(R.id.pwd_hide_show);
        pwd_hide_show.setOnClickListener(this);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Init();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Global.ReleaseMemoryOnDestory();
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_login:
                global.mKProgressHUD = KProgressHUD.create(LoginActivity.this).setStyle(KProgressHUD.Style.SPIN_INDETERMINATE).setDimAmount(0.7f).setAnimationSpeed(2).setLabel("Please Wait").setCancellable(true);
                global.mKProgressHUD.show();
                global.HideKeyBoard(LoginActivity.this, v);
                if (fields_validation() == false) {
                    global.mKProgressHUD.dismiss();
                } else {
                    if (Global.CheckInternetConnectivity(LoginActivity.this)) {
                        final String username = txt_username.getText().toString();
                        final String userpassword = txt_password.getText().toString();
                        Log.d("MyLoginCradentials", "" + username + " " + userpassword);
                        if (!username.equals("") && !userpassword.equals("")) {
                            btn_login.setClickable(false);
                            mAuth.signInWithEmailAndPassword(username, userpassword)
                                    .addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                                        @Override
                                        public void onComplete(@NonNull Task<AuthResult> task) {
                                            if (!task.isSuccessful()) {
                                                btn_login.setClickable(true);
                                                Toast.makeText(LoginActivity.this, "Failed to Login", Toast.LENGTH_LONG).show();
                                                global.mKProgressHUD.dismiss();
                                            } else {
                                                preferencesHandler.setUemail(username);
                                                preferencesHandler.setUpwd(userpassword);
                                                getAccountDetails();
                                                Toast.makeText(LoginActivity.this, "Signed in!", Toast.LENGTH_LONG).show();
                                                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                                                startActivity(intent);
                                                global.mKProgressHUD.dismiss();
                                                finish();
                                            }
                                        }
                                    });
                        }

                    }
                }
                break;

            case R.id.btn_create_account:
                global.HideKeyBoard(LoginActivity.this, v);
                global.changeActivity(LoginActivity.this, new SignupActivity());
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                break;

            case R.id.btn_reset_password:
                global.HideKeyBoard(LoginActivity.this, v);
                global.changeActivity(LoginActivity.this, new ResetPasswordActivity());
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                break;

            case R.id.pwd_hide_show:
                Passwordhideandshow();
                break;

            case R.id.chk_keep_me_logged_in:
                Checkloggedin();
                break;

            case R.id.lbl_keep_me_logged_in:
                Checkloggedin();
                break;

        }
    }

    private void Checkloggedin() {
        preferencesHandler = new PreferencesHandler(LoginActivity.this);
        if (global.toggle_key == 0) {
            chk_keep_me_logged_in.setImageResource(R.drawable.check_without_makr);
            global.toggle_key = 1;
            preferencesHandler.setIsautocheck("false");
        } else {
            chk_keep_me_logged_in.setImageResource(R.drawable.check_with_mark);
            global.toggle_key = 0;
            preferencesHandler.setIsautocheck("true");
        }
    }


    private void Passwordhideandshow() {
        if (global.toggle_key == 0) {
            pwd_hide_show.setImageResource(R.drawable.hidepass_icon);
            txt_password.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
            global.toggle_key = 1;

        } else {
            pwd_hide_show.setImageResource(R.drawable.showpass_icon);
            txt_password.setInputType(InputType.TYPE_CLASS_TEXT);
            global.toggle_key = 0;
        }


    }

    public boolean fields_validation() {
        boolean valid = true;

        txt_user_name_txt = txt_username.getText().toString();
        txt_password_txt = txt_password.getText().toString();

        if (txt_user_name_txt.isEmpty()) {
            Toast.makeText(LoginActivity.this, R.string.rd_user_name, Toast.LENGTH_SHORT).show();
            valid = false;
        } else if (txt_password_txt.isEmpty() || txt_password_txt.length() < 6) {
            Toast.makeText(LoginActivity.this, R.string.rd_password, Toast.LENGTH_SHORT).show();
            valid = false;
        }
        return valid;
    }

    private void getAccountDetails() {
        databaseReference.orderByChild("uemail").equalTo(txt_user_name_txt).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot datas : dataSnapshot.getChildren()) {
                    preferencesHandler.setUserName(datas.child("uname").getValue().toString());
                    preferencesHandler.setUserName(datas.child("vtype").getValue().toString());
                    preferencesHandler.setUserName(datas.child("vyear").getValue().toString());
                    preferencesHandler.setUserName(datas.child("vmodel").getValue().toString());
                    preferencesHandler.setUserName(datas.child("vengine").getValue().toString());
                    global.mKProgressHUD.dismiss();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

}
