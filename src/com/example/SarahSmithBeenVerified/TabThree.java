package com.example.SarahSmithBeenVerified;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

/**
 * Created by sesmith325 on 4/22/15.
 */
public class TabThree extends Activity {
    private Button tab1, tab2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().requestFeature(Window.FEATURE_PROGRESS);

        this.setContentView(R.layout.activity_tab1);


        tab1 = (Button)findViewById(R.id.tab1);
        tab1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(TabThree.this,TabOne.class);
                startActivity(intent);
            }
        });

        tab2 = (Button)findViewById(R.id.tab2);
        tab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(TabThree.this,TabTwo.class);
                startActivity(intent);
            }
        });

    }
}
