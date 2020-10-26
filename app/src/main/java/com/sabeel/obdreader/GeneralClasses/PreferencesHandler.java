package com.sabeel.obdreader.GeneralClasses;


import android.content.Context;
import android.content.SharedPreferences;


public class PreferencesHandler {

    private static SharedPreferences pref;
    private static SharedPreferences.Editor editor;
    private static final String APP_FIRST_TIME = "app_first_time";

    private static final String ISAUTOCHECK = "isautocheck";
    public static final String DISCOUNT_OFFERED = "";

    public static final String USER_NAME = "uname";
    public static final String V_TYPE = "vtype";
    public static final String V_MODEL = "vmodel";
    public static final String V_ENGINE = "vengine";
    public static final String V_YEAR = "vyear";
    private static final String UEMAIL = "uemail";
    private static final String UPWD = "upwd";

    public PreferencesHandler() {

    }

    public PreferencesHandler(Context context) {
        pref = context.getSharedPreferences("bcar_obd", Context.MODE_PRIVATE);
        editor = pref.edit();
    }

    public String getAppFirstTime() {
        return pref.getString(APP_FIRST_TIME, "true");
    }

    public void setAppFirstTime(String appFirstTime) {
        editor.putString(APP_FIRST_TIME, appFirstTime);
        editor.apply();
        editor.commit();
    }

    public String getUemail() {
        return pref.getString(UEMAIL, "");
    }

    public void setUemail(String uemail) {
        editor.putString(UEMAIL, uemail);
        editor.apply();
        editor.commit();
    }

    public String getUserName() {
        return pref.getString(USER_NAME, "");
    }

    public void setUserName(String userName) {
        editor.putString(USER_NAME, userName);
        editor.apply();
        editor.commit();
    }


    public String getType() {
        return pref.getString(V_TYPE, "");
    }

    public void setType(String type) {
        editor.putString(V_TYPE, type);
        editor.apply();
        editor.commit();
    }

    public String getEngine() {
        return pref.getString(V_ENGINE, "");
    }

    public void setEngine(String engine) {
        editor.putString(V_ENGINE, engine);
        editor.apply();
        editor.commit();
    }

    public String getYear() {
        return pref.getString(V_YEAR, "");
    }

    public void setYear(String year) {
        editor.putString(V_YEAR, year);
        editor.apply();
        editor.commit();
    }

    public String getModel() {
        return pref.getString(V_MODEL, "");
    }

    public void setModel(String model) {
        editor.putString(V_MODEL, model);
        editor.apply();
        editor.commit();
    }


    public String getUpwd() {
        return pref.getString(UPWD, "");
    }

    public void setUpwd(String upwd) {
        editor.putString(UPWD, upwd);
        editor.apply();
        editor.commit();
    }

    public String getIsautocheck() {
        return pref.getString(ISAUTOCHECK, "false");
    }

    public void setIsautocheck(String isautocheck) {
        editor.putString(ISAUTOCHECK, isautocheck);
        editor.apply();
        editor.commit();
    }

}
