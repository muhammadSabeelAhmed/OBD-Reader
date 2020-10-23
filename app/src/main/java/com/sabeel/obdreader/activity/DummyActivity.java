package com.sabeel.obdreader.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.sabeel.obdreader.GeneralClasses.LiveData;
import com.sabeel.obdreader.GeneralClasses.PreferencesHandler;
import com.sabeel.obdreader.R;

public class DummyActivity extends Activity {
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;
    private FirebaseAuth mAuth;
    private PreferencesHandler preferencesHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dummy);
        init();
    }

    private void init() {
        preferencesHandler = new PreferencesHandler(DummyActivity.this);
        mAuth = FirebaseAuth.getInstance();
        firebaseDatabase = FirebaseDatabase.getInstance();
        for (int i = 0; i <= 3; i++) {
            databaseReference = firebaseDatabase.getReference(preferencesHandler.getUemail().replace("@", "AT").replace(".", "DOT"));
            LiveData liveData = new LiveData("aaa", "aaa", "aaa", "aaa", "aaa", "aaa", "aaa", "aaa", "aaa",
                    "aaa", "aaa", "aaa", "aaa", "aaa", "aaa", "aaa", "aaa",
                    "aaa", "aaa", "aaa", "aaa", "aaa", "aaa", "aaa",
                    "aaa", "aaa", "aaa", "aaa");
            DatabaseReference newRef = databaseReference.push();
            newRef.setValue(liveData);
        }
    }
}