package com.lambda.myapplication;

import android.net.ConnectivityManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // S03M03-6 add components to build urls for database
    private static final String BASE_URL       = "https://journaldemo-7fabe.firebaseio.com";
    private static final String ENTRIES_OBJECT = "/entries";
    private static final String URL_ENDING     = ".json";

    private static final String READ_ALL_URL = BASE_URL + ENTRIES_OBJECT + URL_ENDING;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        ConnectivityManager cManager=(ConnectivityManager)getSystemService(this.CONNECTIVITY_SERVICE);
        NetworkInfo ninfo=cManager.getActiveNetworkInfo();
        if(ninfo!=null&&ninfo.isConnected()){
            final String result = NetworkAdapter.httpRequest(READ_ALL_URL);

            TextView tv=findViewById( R.id.text_debug);
            tv.setText(result );
        }
  }
}