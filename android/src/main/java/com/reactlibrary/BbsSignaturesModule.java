package com.reactlibrary;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.Callback;

public class BbsSignaturesModule extends ReactContextBaseJavaModule {

    private final ReactApplicationContext reactContext;

    public BbsSignaturesModule(ReactApplicationContext reactContext) {
        super(reactContext);
        this.reactContext = reactContext;
    }

    @Override
    public String getName() {
        return "BbsSignatures";
    }

    @ReactMethod
    public void sampleMethod(Callback callback) {
        callback.invoke("TEST: " + BbsLibrary.INSTANCE.bls_secret_key_size());
        // callback.invoke("BBS Signature Size: " + this.libbbs.bbs_signature_size());
    }
}
