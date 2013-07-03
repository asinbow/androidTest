package com.example.Test;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Process;
import android.widget.TextView;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MyActivity extends Activity {

    private IRemoteService mService = null;
    private static final String TAG = "MainActivity, PID=" + Process.myPid();

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        //testHTTP();
        startService(new Intent("com.example.Test.RemoteService"));
    }

    protected void testHTTP() {
        BufferedReader in = null;
        try {
            HttpClient client = new DefaultHttpClient();
            HttpGet request = new HttpGet("http://www.google.com/");
            HttpResponse response = client.execute(request);

            in = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

            StringBuffer sb = new StringBuffer("");
            String line = "";
            String NL = System.getProperty("line.separator");
            while ((line = in.readLine()) != null) {
                sb.append(line + NL);
            }
            in.close();
            String page = sb.toString();

            TextView t = (TextView)findViewById(R.id.helloWorldText);
            t.setText(page);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
