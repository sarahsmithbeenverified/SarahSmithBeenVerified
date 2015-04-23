package com.example.SarahSmithBeenVerified;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import org.json.JSONObject;

/**
 * Created by sesmith325 on 4/22/15.
 */
public class TabOneTable extends Activity {

    private Button testbutton, tab1, tab2, tab3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().requestFeature(Window.FEATURE_PROGRESS);

        this.setContentView(R.layout.activity_tab1_table);

        View view = findViewById(R.id.relLayout1);
        TextView tv1 = (TextView)view.findViewById(R.id.row0_0);
        tv1.setText("Hello");

        TextView tv2 = (TextView) view.findViewById(R.id.row0_1);
        tv2.setText("Hello2");


        // be able to click to the next button (tab 2)
        tab1 = (Button)findViewById(R.id.tab1);
        tab1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(TabOneTable.this,TabOne.class);
                startActivity(intent);
            }
        });

        tab2 = (Button) findViewById(R.id.tab2);
        tab2 = (Button) findViewById(R.id.tab2);
        tab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(TabOneTable.this, TabTwo.class);
                startActivity(intent);
            }
        });



    }
}
