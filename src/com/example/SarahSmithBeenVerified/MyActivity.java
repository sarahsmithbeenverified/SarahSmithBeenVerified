package com.example.SarahSmithBeenVerified;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.Button;

public class MyActivity extends Activity {
    private Button tab1, tab2, tab3;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        tab2 = (Button)findViewById(R.id.tab2);

        tab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MyActivity.this,TabTwo.class);
                startActivity(intent);
            }
        });
    }
}
