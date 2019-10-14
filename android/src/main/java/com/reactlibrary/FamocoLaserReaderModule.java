package com.reactlibrary;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

import java.lang.annotation.Repeatable;
import java.util.logging.LogManager;

import com.facebook.react.bridge.Callback;
import android.util.Log;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;

public class FamocoLaserReaderModule extends ReactContextBaseJavaModule {

    private final ReactApplicationContext reactContext;
    private LaserBroadcastReceiver laserBroadcastReceiver;

    public FamocoLaserReaderModule(ReactApplicationContext reactContext) {
        super(reactContext);
        this.reactContext = reactContext;
    }

    @Override
    public String getName() {
        return "FamocoLaserReader";
    }

    @ReactMethod
    public void startReader(Callback callback) {
        laserBroadcastReceiver = new LaserBroadcastReceiver(callback, getCurrentActivity());
        IntentFilter filter = new IntentFilter();

        // filter.addAction(ScannerConstants.ACTION_SCANNER_ENABLED);
        // filter.addAction(ScannerConstants.ACTION_SCANNER_DISABLED);
        filter.addAction(ScannerConstants.ACTION_SCANNER_STARTED);
        filter.addAction(ScannerConstants.ACTION_SCANNER_RELEASED);
        filter.addAction(ScannerConstants.ACTION_SCAN_COMPLETE);
        getCurrentActivity().registerReceiver(laserBroadcastReceiver, filter);
    }

}
