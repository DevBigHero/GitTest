package com.example.bighero.js;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.example.bighero.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class JsActivity extends AppCompatActivity {

    @Bind(R.id.wv_web)
    WebView wvWeb;
    private String TAG = JsActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_js);
        ButterKnife.bind(this);
        initWeb();

    }

    private void initWeb() {
        WebSettings settings = wvWeb.getSettings();
        settings.setJavaScriptEnabled(true);
        wvWeb.addJavascriptInterface(new JsHook(),"bighero");
        wvWeb.loadUrl("file:///android_asset/bighero.html");
    }

    private class JsHook {

        @JavascriptInterface
        public void javaMethod(String p){
            Log.d(TAG , "JSHook.JavaMethod() called! + "+p);
        }
        @JavascriptInterface
        public void showAndroid(){
            final String info = "来自手机内的内容！！！";
            wvWeb.post(new Runnable() {
                @Override
                public void run() {
                    wvWeb.loadUrl("javascript:show('"+info+"')");
                }
            });
        }
        @JavascriptInterface
        public String getInfo(){
            return "获取手机内的信息！！";
        }
    }
}
