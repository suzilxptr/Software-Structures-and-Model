package com.bigbang.bastolasushil.lab6;

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

import com.bigbang.bastolasushil.lab6.Creature;

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
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
   AllCreature allAnimals=AllCreature.getCreature();
    StringBuilder string=new StringBuilder();
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
            System.out.println("saved animals"+allAnimals.getAll());
            saveObject(allAnimals );

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

    public void saveObject(AllCreature c) throws IOException {
        FileOutputStream out=openFileOutput("saved1.ser", Context.MODE_PRIVATE);
        ObjectOutputStream out1=new ObjectOutputStream(out);
        System.out.println("Saved object "+ c.getAll());
        out1.writeObject(c);
        out1.close();

        out.close();
    }

    BufferedReader s;


    public void loadFile(){

        try {
            FileInputStream filein=openFileInput("saved1.ser");
            ObjectInputStream objin=new ObjectInputStream(filein);
            AllCreature c= (AllCreature) objin.readObject();
            ArrayList<Creature> one=c.getAll();
            System.out.println("The arraylist "+one);
            for(int i=0; i<one.size(); i++){
                Creature animal=one.get(i);
                String name=animal.toString();
                string.append(name);
                allAnimals.getAll().add(animal);


            }
            System.out.println(string.toString());




        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (StreamCorruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final Creature c=new Creature("","");
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
                Creature added=new Creature("", "");
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
                    added.setName(s);
                    added.setType(value);
                    allAnimals.getAll().add(added);




                    for(int i=0; i<allAnimals.getAll().size(); i++){
                        Creature cre=allAnimals.getAll().get(i);
                        all1.append(cre.toString());

                    }
                    System.out.println("The value is " + value);
                    AlertDialog.Builder builder1 = new AlertDialog.Builder(MainActivity.this);
                    builder1.setMessage(all1.toString());
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
