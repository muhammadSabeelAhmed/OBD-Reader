package com.sabeel.obdreader.GeneralClasses;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.kaopiz.kprogresshud.KProgressHUD;
import com.sabeel.obdreader.R;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStreamWriter;

import static android.widget.Toast.LENGTH_SHORT;

public class Global {
public static String filePath="";
    public static String controllerName = "";
    public static boolean isBackFunctionally = false;
    public static KProgressHUD mKProgressHUD;
    public static String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    public static PreferencesHandler preferencesHandler = new PreferencesHandler();
    public static boolean useFontFotViews = true;
    public static String appFontNameLIGHT = "open-sans.light.ttf";
    public static String appFontNameREGULAR = "open-sans.regular.ttf";
    public static String appFontNameSemiBold = "open-sans.semibold.ttf";
    public static int toggle_key = 1;
    public static String device_back_tag = "";
    public String Base_URL = "https://discoveritech.org/";
    public static String myEmail = "";

    public static void SetView(Context mContext, android.widget.Button selectedView, boolean isBold) {
        if (useFontFotViews) {
            String fontName = Global.appFontNameLIGHT;
            if (isBold) {
                fontName = Global.appFontNameREGULAR;
            }
            android.graphics.Typeface font = android.graphics.Typeface.createFromAsset(mContext.getAssets(), fontName);
            selectedView.setTypeface(font);
        }
    }

    public static void SetView(Context mContext, android.widget.TextView selectedView, boolean isBold, boolean isSemiBold) {
        if (useFontFotViews) {
            String fontName = Global.appFontNameLIGHT;
            if (isBold) {
                fontName = Global.appFontNameREGULAR;
            } else if (isSemiBold) {
                fontName = Global.appFontNameSemiBold;
            }
            android.graphics.Typeface font = android.graphics.Typeface.createFromAsset(mContext.getAssets(), fontName);
            selectedView.setTypeface(font);
        }
    }

    public static void SetView(Context mContext, android.widget.EditText selectedView, boolean isBold) {
        if (useFontFotViews) {
            String fontName = Global.appFontNameLIGHT;
            if (isBold) {
                fontName = Global.appFontNameREGULAR;
            }
            android.graphics.Typeface font = android.graphics.Typeface.createFromAsset(mContext.getAssets(), fontName);
            selectedView.setTypeface(font);
        }
    }

    public static void ReleaseMemoryOnDestory() {
        try {
            System.gc();
        } catch (Exception ee) {
        }

        try {
            Runtime.getRuntime().gc();
        } catch (Exception ee) {
        }
    }

    public static void HideKeyBoard(Context mContext, android.view.View clickedView) {
        try {
            android.view.inputmethod.InputMethodManager inputManager = (android.view.inputmethod.InputMethodManager)
                    mContext.getSystemService(Context.INPUT_METHOD_SERVICE);
            inputManager.hideSoftInputFromWindow(clickedView.getWindowToken(),
                    android.view.inputmethod.InputMethodManager.HIDE_NOT_ALWAYS);
        } catch (Exception ee) {
            ee.printStackTrace();
        }
    }

    public static boolean CheckInternetConnectivity(Context con) {
        android.net.ConnectivityManager cm = (android.net.ConnectivityManager)
                con.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (cm.getActiveNetworkInfo() != null
                && (cm.getActiveNetworkInfo().isAvailable()
                && cm.getActiveNetworkInfo().isConnected())) {
            return true;
        } else {
            NetworkError(con);
            return false;
        }
    }

    public static int roundValue(float f) {
        int c = (int) ((f) + 0.5f);
        float n = f + 0.5f;
        return (n - c) % 2 == 0 ? (int) f : c;
    }

    private static void NetworkError(Context mContext) {
        android.app.AlertDialog.Builder dialog = new android.app.AlertDialog.Builder(mContext, R.style.MyDialogStyle);
        dialog.setIcon(R.drawable.ic_btcar);
        dialog.setTitle(" ");
        dialog.setCancelable(false);
        dialog.setMessage(R.string.lbl_network_error);
//        keyValue(mContext, "network_error")
//        keyValue(mContext, "ok")
        dialog.setPositiveButton(R.string.lbl_ok,
                new android.content.DialogInterface.OnClickListener() {
                    public void onClick(android.content.DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        dialog.show();
    }

    public static void changeActivity(Context context, Activity activity) {

        Intent in = new Intent();
        in.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        in.setClass(context, activity.getClass());
        context.startActivity(in);

    }

    public static void savedatatostorage(Context context, String data, String file_name) {
        OutputStreamWriter out = null;
        try {
            out = new OutputStreamWriter(context.openFileOutput(file_name, Context.MODE_PRIVATE));
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        }

        try {
            out.write(data);
            out.write('\n');
            out.close();
        } catch (IOException e1) {
            e1.printStackTrace();
        }


    }

    public static void OpenKeybord(Context context, EditText editText) {
        InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.showSoftInput(editText, InputMethodManager.SHOW_IMPLICIT);
    }

    public static void FragmentBackButtonClick(Activity mActivity) {
        Log.d("back_frag", Global.device_back_tag);
        mActivity.getFragmentManager().popBackStack(Global.device_back_tag,
                FragmentManager.POP_BACK_STACK_INCLUSIVE);
    }

    public static void DialogBox(final Context mContext, final String message) {
        android.app.AlertDialog.Builder dialog = new android.app.AlertDialog.Builder(mContext, R.style.MyDialogStyle);
        dialog.setCancelable(false);
        dialog.setTitle(" ");
        dialog.setIcon(R.drawable.ic_btcar);
        dialog.setMessage(message);
        dialog.setNegativeButton("No",
                new android.content.DialogInterface.OnClickListener() {
                    public void onClick(android.content.DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });

        dialog.setNegativeButton("Yes",
                new android.content.DialogInterface.OnClickListener() {
                    public void onClick(android.content.DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        dialog.show();
    }

    public static String discountOffered(String invoiceNum) {
        DatabaseReference newRef = FirebaseDatabase.getInstance().getReference("Invoices");
        final String[] result = new String[1];
        newRef.child(invoiceNum).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                result[0] = dataSnapshot.child("discount").getValue(String.class);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        return result[0];
    }

    public static void RedirectedDialog(final Context mContext, final String url, final String message) {
        android.app.AlertDialog.Builder dialog = new android.app.AlertDialog.Builder(mContext, R.style.MyDialogStyle);
        dialog.setCancelable(false);
        dialog.setMessage(message);
        dialog.setNegativeButton(R.string.btn_no,
                new android.content.DialogInterface.OnClickListener() {
                    public void onClick(android.content.DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });

        dialog.setPositiveButton(R.string.btn_yes,
                new android.content.DialogInterface.OnClickListener() {
                    public void onClick(android.content.DialogInterface dialog, int which) {

                        try {
                            Intent browserIntentsupport = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                            mContext.startActivity(browserIntentsupport);
                            dialog.dismiss();
                        } catch (ActivityNotFoundException exception) {
                            Toast.makeText(mContext, "Web Browser not installed", LENGTH_SHORT).show();
                        }
                    }
                });
        dialog.show();
    }

    public static void removePaidInvoice(String invoiceNumber, String invoice_title, String payment_status, String paid_amount) {
        DatabaseReference updateData = FirebaseDatabase.getInstance()
                .getReference("Invoices")
                .child(invoiceNumber);
        updateData.child("paymentStatus").setValue(payment_status);
        updateData.child("invoiceTitle").setValue(invoice_title);
        updateData.child("paidAmount").setValue(paid_amount);
        updateData.child("currency").setValue("USD");
    }

    public static boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
        } catch (NumberFormatException e) {
            return false;
        } catch (NullPointerException e) {
            return false;
        }
        // only got here if we didn't return false
        return true;
    }

}
