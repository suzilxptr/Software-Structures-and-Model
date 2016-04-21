package com.bigbang.bastolasushil.lab7;

import android.content.Intent;
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
        Button add=(Button) findViewById(R.id.button);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText edit=(EditText)findViewById(R.id.editText);
                String value=edit.getText().toString();
            /*
                EditText edit=(EditText)findViewById(R.id.editText);
                String value=edit.getText().toString();
                Intent i=new Intent(MainActivity.this,NextActivity.class);
                i.putExtra("value",value);
                startActivity(i);*/

                Intent i=new Intent("android.intent.action.TESTACTION");
                i.putExtra("name",value);
                startActivity(i);



            }
        });
    }
}
