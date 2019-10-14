package com.reactlibrary;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.Callback;
import android.content.Intent;
import android.os.Bundle;

public class FamocoLaserReaderModule extends ReactContextBaseJavaModule {

    private final ReactApplicationContext reactContext;

    public FamocoLaserReaderModule(ReactApplicationContext reactContext) {
        super(reactContext);
        this.reactContext = reactContext;
    }

    @Override
    public String getName() {
        return "FamocoLaserReader";
    }

    @ReactMethod
    public void sampleMethod(String stringArgument, int numberArgument, Callback callback) {
        // TODO: Implement some actually useful functionality
        Intent intent = new Intent(ScannerConstants.ACTION_START_SCANNER);
        // set length of interleaved 2 of 5 barcode to [default,55]
        Bundle bundle = new Bundle();
        bundle.putInt("23", 55);
        intent.putExtra(ScannerConstants.EXTRA_PARAMETERS, bundle);
        Log.d(TAG, String.format("Sending %s...", intent.getAction()));

        intent.setPackage(ScannerConstants.SCANNER_SERVICE_PACKAGE);
        intent.setFlags(Intent.FLAG_FROM_BACKGROUND);
        getCurrentActivity().startService(intent);
        callback.invoke("Received numberArgumentzzzz: " + numberArgument + " stringArgument: " + stringArgument);
    }
}
