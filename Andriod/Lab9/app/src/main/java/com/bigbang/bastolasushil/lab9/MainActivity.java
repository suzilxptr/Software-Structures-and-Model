package com.bigbang.bastolasushil.lab9;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button go=(Button)findViewById(R.id.go);
        go.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                EditText edit=(EditText)findViewById(R.id.editText);
                String url=edit.getText().toString();
                Intent i=new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);

            }

        });
    }


}
