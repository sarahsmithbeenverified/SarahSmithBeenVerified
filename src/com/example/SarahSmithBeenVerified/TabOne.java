package com.example.SarahSmithBeenVerified;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
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
                Intent intent = new Intent();
                intent.setClass(TabOne.this,TabOneTable.class);
                startActivity(intent);
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

        // call setup JSONObject
        JSONObject json = setupURL();

        try {
            String fullName = json.get("full_name").toString();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public JSONObject setupURL(){
        InputStream is = null;
        JSONObject jObj = null;
        String json = "";
        try {
            URL url = new URL("https://api.github.com/users/BeenVerifiedInc/repos");
            HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
            httpConn.connect();

            DefaultHttpClient httpClient = new DefaultHttpClient();
            HttpPost httpPost = new HttpPost("https://api.github.com/users/BeenVerifiedInc/repos");

            HttpResponse httpResponse = httpClient.execute(httpPost);
            HttpEntity httpEntity = httpResponse.getEntity();
            is = httpEntity.getContent();
        }catch (Exception e){
            e.printStackTrace();
        }
        try{
            BufferedReader buffRead = new BufferedReader(new InputStreamReader(is, "iso-8859-1"), 8);
            StringBuilder strBuilder = new StringBuilder();
            String entry;
            while((entry = buffRead.readLine())!= null){
                strBuilder.append(entry);
            }
            is.close();
            json = strBuilder.toString();

            jObj = new JSONObject(json);

        }catch(Exception e){
            e.printStackTrace();
        }
        return jObj;

    }

}
