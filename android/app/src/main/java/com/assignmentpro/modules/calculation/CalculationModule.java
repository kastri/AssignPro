package com.assignmentpro.modules.calculation;

import androidx.annotation.NonNull;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

public class CalculationModule extends ReactContextBaseJavaModule {

    public CalculationModule(ReactApplicationContext context) {
        super(context);
    }


    @ReactMethod(isBlockingSynchronousMethod = true)
    public int getCalculationResult( String type,int numbOne,int numbTwo) {
        switch (type) {
            case "+":
                return numbOne + numbTwo;
            case "-":
                return numbOne - numbTwo;
            case "*":
                return numbOne * numbTwo;
            case "/":
                return numbOne / numbTwo;
            default:
                return numbOne + numbTwo;
        }
    }

    @NonNull
    @Override
    public String getName() {
        return "CalculationModule";
    }
}
