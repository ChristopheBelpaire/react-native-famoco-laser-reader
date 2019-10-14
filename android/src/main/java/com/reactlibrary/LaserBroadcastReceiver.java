package com.reactlibrary;

import java.util.logging.LogManager;

import com.facebook.react.bridge.Callback;
import android.util.Log;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.BroadcastReceiver;
import android.app.Activity;

public class LaserBroadcastReceiver extends BroadcastReceiver {
    private Callback callback;
    private Activity activity;

    public LaserBroadcastReceiver(Callback callback, Activity activity) {
        this.callback = callback;
        this.activity = activity;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (ScannerConstants.ACTION_SCAN_COMPLETE.equals(action)) {
            String content = intent.getExtras().getString(ScannerConstants.EXTRA_CONTENT);
            content = content.replaceAll("\\u0000", "");
            callback.invoke(null, content);
            activity.unregisterReceiver(this);
        }
    }
};