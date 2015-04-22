package com.example.SarahSmithBeenVerified;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by sesmith325 on 4/21/15.
 */
public class TabTwo extends Activity {
    private Button tab1, tab3;
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        getWindow().requestFeature(Window.FEATURE_PROGRESS);

        this.setContentView(R.layout.activity_tab2);

        tab1 = (Button)findViewById(R.id.tab1);
        tab1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(TabTwo.this,TabOne.class);
                startActivity(intent);
            }
        });



    }

    @Override
    public boolean dispatchKeyEvent(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.KEYCODE_ENTER) {
            WebView webView = (WebView)findViewById(R.id.webview);
            TextView text = (TextView)findViewById(R.id.tab2textview);
            EditText eText = (EditText)findViewById(R.id.tab2textview);
            eText.setTextColor(Color.BLACK);
            //webView.loadUrl(text.getText().toString());




            webView.getSettings().setJavaScriptEnabled(true);

            final Activity activity = this;
            webView.setWebChromeClient(new WebChromeClient() {
                public void onProgressChanged(WebView view, int progress) {
                    // Activities and WebViews measure progress with different scales.
                    // The progress meter will automatically disappear when we reach 100%
                    activity.setProgress(progress * 1000);
                }
            });
            webView.setWebViewClient(new WebViewClient() {
                public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                    Toast.makeText(activity, "Oh no! " + description, Toast.LENGTH_SHORT).show();
                }
            });

            webView.loadUrl(text.getText().toString());
            return true;
        }
        return super.dispatchKeyEvent(e);
    };
}
