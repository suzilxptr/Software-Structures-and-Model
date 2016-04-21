package com.bigbang.bastolasushil.lab12;

import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
    TextView allLines;
    TextView size;
    TextView longestLine;

    public void render(String... strings){


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText urlName=(EditText)findViewById(R.id.url);
        allLines=(TextView)findViewById(R.id.totalLines);
         size=(TextView) findViewById(R.id.totalSize);
         longestLine=(TextView)findViewById(R.id.longestLine);
        Button scan=(Button)findViewById(R.id.scan);

        scan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url=urlName.getText().toString();
                String[] fetchDataFrom={url};
                new FetchData().execute(fetchDataFrom);

            }
        });

    }
    class FetchData extends AsyncTask<String,String,String> {
        int count=0;
        int longestLine1=0;
        int size1=0;
        StringBuffer buffer=null;

        @Override
        protected String doInBackground(String... strings) {


            String urlName= strings[0];
            URL url = null;

            try {
                url=new URL(urlName);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            try {
                HttpURLConnection connection=(HttpURLConnection)url.openConnection();
                connection.setRequestMethod("GET");
                connection.connect();
                connection.getContentLength();
                System.out.println("Length of file  " + connection.getContentLength());
                Log.d("Connection", "Successful");

                InputStream inputstream=connection.getInputStream();
                buffer=new StringBuffer();
                BufferedReader reader=new BufferedReader(new InputStreamReader(inputstream));

                String line;


                while((line=reader.readLine())!=null){

                    buffer.append(line + "\n");
                    count++;
                    int lengthofLine=line.length();
                    if(lengthofLine>longestLine1){
                        longestLine1=lengthofLine;

                    }


                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            Log.d("Datas", buffer.length()+"");
            Log.d("Count",count+"");
            Log.d("LongestLine",  longestLine+"");

            return null;
        }

        @Override
        protected void onPostExecute(String s) {
       allLines.setText(count+"");
       size.setText(buffer.length()+"");
       longestLine.setText(longestLine1+"");

        }
    }



}




