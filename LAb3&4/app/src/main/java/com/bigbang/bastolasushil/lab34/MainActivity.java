package com.bigbang.bastolasushil.lab34;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.StreamCorruptedException;

public class MainActivity extends AppCompatActivity {
   final Creature c=new Creature();
    StringBuilder all=new StringBuilder();
    StringBuilder all1;
    @Override
    protected void onStart(){

        super.onStart();
        loadFile();
        Log.d("Start"," start called");
    }
    @Override
    protected void onResume(){
        super.onResume();
        Log.d("Resume"," resume called");
    }

    @Override
    protected void onStop(){
        super.onStop();
        try {
            saveObject(c);
            System.out.println("serailization done");
        } catch (IOException e) {
            e.printStackTrace();
        }
        Log.d("Stop"," Stop called");
    }

    @Override
    protected void onPause(){
        super.onPause();
        Log.d("Pause"," Pause called");
    }

    @Override
    protected void onRestart(){
        super.onRestart();
        Log.d("Pause"," restart called");
    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.d("Destroy"," Destroy called");
    }
    public void saveObject(Creature c) throws IOException {
        FileOutputStream out=openFileOutput("saved1", Context.MODE_PRIVATE);
        out.write(all.toString().getBytes());

        out.close();
    }
    BufferedReader s;

    public void loadFile(){
        try {
            FileInputStream filein=openFileInput("saved1");
             s=new BufferedReader(new InputStreamReader(filein));
            String allAnimals;
            while((allAnimals=s.readLine())!=null){

                all.append("\n" + allAnimals);

            }
            System.out.println(all.toString());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (StreamCorruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final Creature c=new Creature();
        super.onCreate(savedInstanceState);
        Log.d("create", " onCreate called");
        setContentView(R.layout.activity_main);

        Button clear=(Button)findViewById(R.id.clear);
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText e= (EditText)findViewById(R.id.text);
                e.setText("");
            }
        });

        Button add=(Button)findViewById(R.id.add);
        add.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                all1=new StringBuilder();
                EditText e=(EditText)findViewById(R.id.text);
               String s= e.getText().toString();

                RadioGroup r=(RadioGroup)findViewById(R.id.radioGroup);
               if((r.getCheckedRadioButtonId()!=-1) && (!(s.trim().equals("")))){
                   int selectedvalue=r.getCheckedRadioButtonId();
                   View radioButton=r.findViewById(selectedvalue);
                   int radioId=r.indexOfChild(radioButton);
                   RadioButton theButton=(RadioButton)r.getChildAt(radioId);
                   String value=(String)theButton.getText();

                   c.getCreatures().add("\n"+s);

                   System.out.println("The size is"+c.getCreatures().size());

                    for(int i=0; i<c.getCreatures().size(); i++){
                        String cre=c.getCreatures().get(i);
                        all1.append(cre);

                   }
                   System.out.println("The value is " + value);
                   AlertDialog.Builder builder1 = new AlertDialog.Builder(MainActivity.this);
                   builder1.setMessage(all.toString()+all1.toString());
                   builder1.setCancelable(true);



                   builder1.setNegativeButton(
                           "Back",
                           new DialogInterface.OnClickListener() {
                               public void onClick(DialogInterface dialog, int id) {
                                   dialog.cancel();
                               }
                           });

                   AlertDialog alert11 = builder1.create();
                   alert11.show();

               }
                else{
                   AlertDialog.Builder builder1 = new AlertDialog.Builder(MainActivity.this);
                   builder1.setMessage("Please enter all field");
                   builder1.setCancelable(true);



                   builder1.setNegativeButton(
                           "Back",
                           new DialogInterface.OnClickListener() {
                               public void onClick(DialogInterface dialog, int id) {
                                   dialog.cancel();
                               }
                           });

                   AlertDialog alert11 = builder1.create();
                   alert11.show();


               }
            }

        });
    }
}
