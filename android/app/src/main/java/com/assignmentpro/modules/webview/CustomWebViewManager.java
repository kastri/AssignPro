package com.assignmentpro.modules.webview;
import android.os.Build;
import android.view.ViewGroup.LayoutParams;
import android.webkit.ConsoleMessage;
import android.webkit.GeolocationPermissions;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.webkit.JavascriptInterface;
import android.webkit.ValueCallback;
import android.webkit.WebSettings;
import android.webkit.CookieManager;

import com.facebook.react.common.build.ReactBuildConfig;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.ThemedReactContext;
import com.reactnativecommunity.webview.RNCWebViewManager;
import com.reactnativecommunity.webview.WebViewConfig;

@ReactModule(name = CustomWebViewManager.REACT_CLASS)
public class CustomWebViewManager extends RNCWebViewManager {
    protected static final String REACT_CLASS = "MyCustomWebView";

    protected static class CustomReactWebViewClient extends RNCWebViewManager.RNCWebViewClient { }

    protected static class CustomReactWebView extends RNCWebViewManager.RNCWebView {
        public CustomReactWebView(ThemedReactContext reactContext) {
            super(reactContext);
        }
    }

    public CustomWebViewManager() {
        mWebViewConfig = new WebViewConfig() {
            public void configWebView(WebView webView) {
            }
        };
    }

    public CustomWebViewManager(WebViewConfig webViewConfig) {
        mWebViewConfig = webViewConfig;
    }

    @Override
    public String getName() {
        return REACT_CLASS;
    }

    @Override
    protected RNCWebView createRNCWebViewInstance(ThemedReactContext reactContext) {
        return  new CustomReactWebView(reactContext);
    }


    // I had to override this in order to enable my needed WebView functionality
    @Override
    protected WebView createViewInstance(ThemedReactContext reactContext) {
        RNCWebView webView = createRNCWebViewInstance(reactContext) ;

        webView.setWebChromeClient(new WebChromeClient() {
            @Override
            public boolean onConsoleMessage(ConsoleMessage message) {
                if (ReactBuildConfig.DEBUG) {
                    return super.onConsoleMessage(message);
                }
                // Ignore console logs in non debug builds.
                return true;
            }

            @Override
            public void onGeolocationPermissionsShowPrompt(String origin, GeolocationPermissions.Callback callback) {
                callback.invoke(origin, true, false);
            }
        });
        reactContext.addLifecycleEventListener(webView);
        mWebViewConfig.configWebView(webView);
        webView.getSettings().setBuiltInZoomControls(true);
        webView.getSettings().setDisplayZoomControls(false);
        webView.getSettings().setDomStorageEnabled(true);

        webView.getSettings().setAppCacheMaxSize(1024*1024*8);
        webView.getSettings().setAllowFileAccess(true);
        webView.getSettings().setAppCacheEnabled(true);
        // not sure if the below is needed, but at least one post indicated that it was so I did this with my package name to be safe
        webView.getSettings().setAppCachePath("data/data/<your package name here>/cache");
        webView.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
        webView.getSettings().setAllowFileAccessFromFileURLs(true);

        // Fixes broken full-screen modals/galleries due to body height being 0.
        webView.setLayoutParams(
                new LayoutParams(LayoutParams.MATCH_PARENT,
                        LayoutParams.MATCH_PARENT));

        if (ReactBuildConfig.DEBUG && Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            WebView.setWebContentsDebuggingEnabled(true);
        }

        return webView;
    }

    @Override
    protected void addEventEmitters(ThemedReactContext reactContext, WebView view) {
        // Do not register default touch emitter and let WebView implementation handle touches
        view.setWebViewClient(new CustomReactWebViewClient());
    }
}