package com.sabeel.obdreader.activity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.sabeel.obdreader.GeneralClasses.Global;
import com.sabeel.obdreader.GeneralClasses.PreferencesHandler;
import com.sabeel.obdreader.GeneralClasses.User;
import com.sabeel.obdreader.R;

public class SignupActivity extends Activity implements View.OnClickListener {

    private TextView lbl_signup;
    private EditText txt_full_name;
    private EditText txt_type;
    private EditText txt_model;
    private EditText txt_year;
    private EditText txt_engine;
    private EditText txt_user_email;
    private EditText txt_user_password;
    private Button btn_signup;
    private TextView btn_already_account;
    private ImageView btn_back;
    private TextView lbl_by_pressing_cont;
    private TextView lbl_terms;
    private TextView lbl_pravicy_policy;
    private TextView versionText;
    private String btn_already_account_txt = "<font color=#000000>Already have?</font>" + " " + "<font color=#ffcc00>Sign In</font>";
    private String lbl_terms_txt = "<font color=#ffcc00>Terms </font>" + " " + "<font color=#000000>& </font>";
    private Global global;

    private String txt_full_name_txt = "";
    private String txt_type_txt = "";
    private String txt_model_txt = "";
    private String txt_engine_txt = "";
    private String txt_year_txt = "";
    private String txt_user_email_txt = "";
    private String txt_user_password_txt = "";
    private FirebaseDatabase database;
    private DatabaseReference databaseReference;
    private FirebaseAuth mAuth;

    private void Init() {
        lbl_signup = (TextView) findViewById(R.id.lbl_signup);
        global.SetView(SignupActivity.this, lbl_signup, false, true);

        txt_full_name = (EditText) findViewById(R.id.txt_full_name);
        global.SetView(SignupActivity.this, txt_full_name, false);

        txt_type = (EditText) findViewById(R.id.txt_type);
        global.SetView(SignupActivity.this, txt_type, false);

        txt_model = (EditText) findViewById(R.id.txt_model);
        global.SetView(SignupActivity.this, txt_model, false);

        txt_engine = (EditText) findViewById(R.id.txt_engine);
        global.SetView(SignupActivity.this, txt_engine, false);

        txt_year = (EditText) findViewById(R.id.txt_year);
        global.SetView(SignupActivity.this, txt_year, false);

        txt_user_email = (EditText) findViewById(R.id.txt_user_email);
        global.SetView(SignupActivity.this, txt_user_email, false);

        txt_user_password = (EditText) findViewById(R.id.txt_user_password);
        global.SetView(SignupActivity.this, txt_user_password, false);

        btn_signup = (Button) findViewById(R.id.btn_signup);
        global.SetView(SignupActivity.this, btn_signup, false, true);
        btn_signup.setOnClickListener(this);

        btn_already_account = (TextView) findViewById(R.id.btn_already_account);
        global.SetView(SignupActivity.this, btn_already_account, false, true);
        btn_already_account.setText(Html.fromHtml(btn_already_account_txt));
        btn_already_account.setOnClickListener(this);

        lbl_by_pressing_cont = (TextView) findViewById(R.id.lbl_by_pressing_cont);
        global.SetView(SignupActivity.this, lbl_by_pressing_cont, false, true);

        lbl_terms = (TextView) findViewById(R.id.lbl_terms);
        global.SetView(SignupActivity.this, lbl_terms, false, true);
        lbl_terms.setText(Html.fromHtml(lbl_terms_txt));
        lbl_terms.setOnClickListener(this);

        lbl_pravicy_policy = (TextView) findViewById(R.id.lbl_pravicy_policy);
        global.SetView(SignupActivity.this, lbl_pravicy_policy, false, true);
        lbl_pravicy_policy.setOnClickListener(this);

        btn_back = (ImageView) findViewById(R.id.btn_back);
        btn_back.setOnClickListener(this);


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        Init();

        mAuth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();
        databaseReference = database.getReference("Users");

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_signup:
                global.HideKeyBoard(SignupActivity.this, v);
                if (Global.CheckInternetConnectivity(SignupActivity.this)) {
                    if (fields_validation()) {
                        mAuth.createUserWithEmailAndPassword(txt_user_email_txt, txt_user_password_txt).addOnCompleteListener(SignupActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    Toast.makeText(SignupActivity.this, "Account Created Successful", Toast.LENGTH_LONG).show();
                                    User user = new User("" + txt_full_name_txt, "" + txt_type_txt, "" + txt_model_txt, "" + txt_engine_txt, "" + txt_year_txt,
                                            "" + txt_user_email_txt, "" + txt_user_password_txt);
                                    DatabaseReference newRef = databaseReference.push();
                                    newRef.setValue(user);

                                    txt_full_name.setText("");
                                    txt_user_password.setText("");
                                    txt_user_email.setText("");
                                    txt_year.setText("");
                                    txt_model.setText("");
                                    txt_engine.setText("");
                                    txt_type.setText("");
                                    //   databaseReference.setValue(user);

                                } else {
                                    Toast.makeText(SignupActivity.this, "fail to create account", Toast.LENGTH_LONG).show();
                                }
                            }
                        });
                    }
                }


                break;
            case R.id.btn_already_account:
                global.HideKeyBoard(SignupActivity.this, v);
                global.changeActivity(SignupActivity.this, new LoginActivity());
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                finish();
                break;

            case R.id.btn_back:
                global.HideKeyBoard(SignupActivity.this, v);
                global.changeActivity(SignupActivity.this, new LoginActivity());
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                finish();
                break;

            case R.id.lbl_pravicy_policy:
                Intent browserIntentpolicy = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.casvpn.com/privacy-policy"));
                startActivity(browserIntentpolicy);
                break;


            case R.id.lbl_terms:
                Intent browserIntentservices = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.casvpn.com/terms-of-services"));
                startActivity(browserIntentservices);
                break;
        }
    }


  /*  private void Addfreeclient() {
        global.mKProgressHUD = KProgressHUD.create(SignupActivity.this).setStyle(KProgressHUD.Style.SPIN_INDETERMINATE).setDimAmount(0.7f).setAnimationSpeed(2).setLabel("Please Wait").setCancellable(true);
        global.mKProgressHUD.show();

        mCB1 = new WebServicesPostData.myCallback() {
            @Override
            public void onServiceResponse(String returnJson) throws JSONException {

                Log.d("response_addfreeclient", returnJson.toString());

                if (returnJson.startsWith("<!DOCTYPE html>")) {
                    global.mKProgressHUD.dismiss();
                    global.changeActivity(SignupActivity.this, new DialogActivity());
                    overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                }

                global.jsonObject = new JSONObject(returnJson);
                String result = global.jsonObject.getString("result");

                if (result.equals("error")) {
                    global.mKProgressHUD.dismiss();
                    String message = global.jsonObject.getString("message");
                    Toast.makeText(SignupActivity.this, message, Toast.LENGTH_LONG).show();
                } else {

                    global.isSend = 0;
                    global.mKProgressHUD.dismiss();
                    global.changeActivity(SignupActivity.this, new ThankyouActivity());
                    overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                    finish();

                }

            }
        };

        try {

            PreferencesHandler preferencesHandler = new PreferencesHandler(SignupActivity.this);

            myServiec = new WebServicesPostData(SignupActivity.this,
                    preferencesHandler.getBaseUrl() + "/addfreeclient.php", "name=" + txt_full_name.getText().toString() + "&" + "email=" + txt_user_email.getText().toString(), 2, mCB1);

        } catch (Exception ex) {

            Log.d("response_error", ex.getMessage());
        }

    }*/

    public boolean fields_validation() {
        boolean valid = true;
        txt_full_name_txt = txt_full_name.getText().toString();
        txt_user_email_txt = txt_user_email.getText().toString();
        txt_user_password_txt = txt_user_password.getText().toString();
        txt_type_txt = txt_type.getText().toString();
        txt_model_txt = txt_model.getText().toString();
        txt_engine_txt = txt_engine.getText().toString();
        txt_year_txt = txt_year.getText().toString();

        if (txt_full_name_txt.isEmpty()) {
            Toast.makeText(SignupActivity.this, R.string.rd_full_name, Toast.LENGTH_SHORT).show();
            valid = false;
        } else if (txt_type_txt.isEmpty() && txt_type_txt.length() < 3) {
            Toast.makeText(SignupActivity.this, R.string.rd_type, Toast.LENGTH_SHORT).show();
            valid = false;
        } else if (txt_model_txt.isEmpty() && txt_model_txt.length() < 3) {
            Toast.makeText(SignupActivity.this, R.string.rd_model, Toast.LENGTH_SHORT).show();
            valid = false;
        } else if (txt_engine_txt.isEmpty() && txt_engine_txt.length() < 3) {
            Toast.makeText(SignupActivity.this, R.string.rd_engine, Toast.LENGTH_SHORT).show();
            valid = false;
        } else if (txt_year_txt.isEmpty() && txt_year_txt.length() < 4) {
            Toast.makeText(SignupActivity.this, R.string.rd_year, Toast.LENGTH_SHORT).show();
            valid = false;
        } else if (txt_user_email_txt.isEmpty() || !txt_user_email_txt.matches(global.emailPattern)) {
            Toast.makeText(SignupActivity.this, R.string.rd_email, Toast.LENGTH_SHORT).show();
            valid = false;
        } else if (txt_user_password_txt.isEmpty()) {
            Toast.makeText(SignupActivity.this, R.string.rd_password, Toast.LENGTH_SHORT).show();
            valid = false;
        } else if (txt_user_password_txt.length() < 5) {
            Toast.makeText(SignupActivity.this, "Password length should greater then 5", Toast.LENGTH_SHORT).show();
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

//        global.HideKeyBoard(ResetPasswordActivity.this, v);
        global.changeActivity(SignupActivity.this, new LoginActivity());
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        finish();
    }

}
