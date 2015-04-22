package com.example.SarahSmithBeenVerified;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by sesmith325 on 4/22/15.
 */
public class TabOne extends Activity {
    private Button testbutton, tab2, tab3;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        getWindow().requestFeature(Window.FEATURE_PROGRESS);

        this.setContentView(R.layout.activity_tab1);


        testbutton = (Button) findViewById(R.id.testbutton);
        testbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //when play is clicked show stop button and hide play button
                View b = findViewById(R.id.testbutton);
                b.setVisibility(View.GONE);

            }
        });

        // be able to click to the next button (tab 2)
        tab2 = (Button) findViewById(R.id.tab2);
        tab2 = (Button)findViewById(R.id.tab2);
        tab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(TabOne.this, TabTwo.class);
                startActivity(intent);
            }
        });


    }
    public void setupURL(){

        try {
            URL url = new URL("https://api.github.com/users/BeenVerifiedInc/repos");
            URLConnection urlConnection = url.openConnection();
            InputStream in = new BufferedInputStream(urlConnection.getInputStream());
        }catch (Exception e){}
    }

}
