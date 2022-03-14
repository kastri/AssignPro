package com.assignmentpro.modules;

import androidx.annotation.NonNull;

import com.assignmentpro.modules.calculation.CalculationModule;
import com.assignmentpro.modules.webview.CustomWebViewManager;
import com.facebook.react.ReactPackage;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.ViewManager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ModulePackage implements ReactPackage {


    @NonNull
    @Override
    public List<NativeModule> createNativeModules(@NonNull ReactApplicationContext reactContext) {
        List<NativeModule> modules = new ArrayList<>();

        modules.add(new CalculationModule(reactContext));
        return modules;
    }

    @NonNull
    @Override
    public List<ViewManager> createViewManagers(@NonNull ReactApplicationContext reactContext) {

        return Arrays.<ViewManager>asList(new CustomWebViewManager());
    }
}
