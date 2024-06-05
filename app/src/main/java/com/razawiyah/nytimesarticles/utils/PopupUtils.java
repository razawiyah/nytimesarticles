package com.razawiyah.nytimesarticles.utils;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

public class PopupUtils {
    public static void showAlert(Context context, String title, String message) {
        new AlertDialog.Builder(context)
                .setTitle(title)
                .setMessage(message)
                .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // Continue with action
                    }
                })
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();
    }
}
