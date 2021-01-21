package com.sabeel.obdreader;

import com.google.firebase.crashlytics.FirebaseCrashlytics;

public class Crashlytics {
    FirebaseCrashlytics crashlytics;
    // Operations on FirebaseCrashlytics.
  public  void checkCrash() {
      if (crashlytics == null) {
          crashlytics = FirebaseCrashlytics.getInstance();
      }
   //   crashlytics.log("my message");

// To log a message to a crash report, use the following syntax:
      crashlytics.log("E/TAG: my message");

  }
}
