package com.bigbang.bastolasushil.lab11;

import android.os.AsyncTask;

class CountProgress extends AsyncTask<String,Integer,String>  {
Observer o=null;


    @Override
    protected String doInBackground(String... strings){
        System.out.println( strings[0]);
        System.out.println(strings[1]);
        Integer sleep = Integer.parseInt(strings[1]);
        Integer step = Integer.parseInt(strings[0]);
        for(int i=0; i<=step; i++){
            try {
                Thread.sleep(sleep);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            publishProgress((int) ((i / (float) step) * 100));

        }

        return null;
    }
    protected  void onProgressUpdate(Integer...values){
        super.onProgressUpdate(values);
        o.update(values[0]);


    }


}