package com.sabeel.obdreader;

import android.content.Context;
import android.content.SharedPreferences;

public class PreferencesHandler {

    private static SharedPreferences pref;
    private static SharedPreferences.Editor editor;

    private static final String APP_FIRST_TIME = "app_first_time";
    private static final String UEMAIL = "uemail";
    private static final String UPWD = "upwd";
    private static final String EVENT_RUN_AT_START = "event_run_at_start";
    private static final String CURRENT_DATE = "no date";
    private static final String BEARER_TOKEN = "";
    private static final String DEVICE_ID = "device_id";
    private static final String START_ANIMATION = "token";
    private static final String ACTION = "action";
    private static final String ACTION_ID = "action_id";
    private static final String IMAGE_NAME = "";
    private static final String APP_SIZE = "";
    private static final String PATH = "";
    private static final String FILE_NAME = "";
    public PreferencesHandler() {

    }

    public PreferencesHandler(Context context) {
        pref = context.getSharedPreferences("obdReader", Context.MODE_PRIVATE);
        editor = pref.edit();
    }

    public String getStartAnimation() {
        return pref.getString(START_ANIMATION, "false");
    }

    public void setStartAnimation(String animation) {
        editor.putString(START_ANIMATION, animation);
        editor.apply();
        editor.commit();
    }


    public String getBearerToken() {
        return pref.getString(BEARER_TOKEN, "");
    }

    public void setBearerToken(String token) {
        editor.putString(BEARER_TOKEN, token);
        editor.apply();
        editor.commit();
    }

    public String getPath() {
        return pref.getString(PATH, "");
    }


    public void setPath(String path) {
        editor.putString(PATH, path);
        editor.apply();
        editor.commit();
    }

    public void setFileName(String path) {
        editor.putString(FILE_NAME, path);
        editor.apply();
        editor.commit();
    }

    public String getFileName() {
        return pref.getString(FILE_NAME, "");
    }

    public String getAction() {
        return pref.getString(ACTION, "action");
    }

    public void setAction(String token) {
        editor.putString(ACTION, token);
        editor.apply();
        editor.commit();
    }

    public String getActionId() {
        return pref.getString(ACTION_ID, "action_id");
    }

    public void setActionId(String token) {
        editor.putString(ACTION_ID, token);
        editor.apply();
        editor.commit();
    }

    public String getDeviceId() {
        return pref.getString(DEVICE_ID, "");
    }

    public void setDeviceId(String token) {
        editor.putString(DEVICE_ID, token);
        editor.apply();
        editor.commit();
    }

    public String getAppSize() {
        return pref.getString(APP_SIZE, "");
    }

    public void setAppSize(String size) {
        editor.putString(APP_SIZE, size);
        editor.apply();
        editor.commit();
    }

    public String getImageName() {
        return pref.getString(IMAGE_NAME, "");
    }

    public void setImageName(String name) {
        editor.putString(IMAGE_NAME, name);
        editor.apply();
        editor.commit();
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

    public String getUpwd() {
        return pref.getString(UPWD, "");
    }

    public void setUpwd(String upwd) {
        editor.putString(UPWD, upwd);
        editor.apply();
        editor.commit();
    }


    public String getEventRunAtStart() {
        return pref.getString(EVENT_RUN_AT_START, "false");
    }

    public void setEventRunAtStart(String eventRunAtStart) {
        editor.putString(EVENT_RUN_AT_START, eventRunAtStart);
        editor.apply();
        editor.commit();
    }

    public String getCurrentDate() {
        return pref.getString(CURRENT_DATE, "");
    }

    public void setCurrentDate(String currentDate) {
        editor.putString(CURRENT_DATE, currentDate);
        editor.apply();
        editor.commit();
    }
}

