package lab2.a;






import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author sandeshpoudel
 */
public class Time implements Comparable<Time> {

    

    private int hour;
    private int minute;

    Scanner myScanner = new Scanner(System.in);

    public Time() {

    }

    public Time(int hour, int minute) {
        this.hour = hour;
        this.minute = minute;

    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public void read(String someText) {
        System.out.println(someText);
        String currentTime = myScanner.nextLine();
        String[] time = currentTime.split(" ");

        this.hour = (Integer.parseInt(time[0]));
        this.minute = (Integer.parseInt(time[1]));

    }

    

    public void print() {
        System.out.print(getHour() + ":" + getMinute());

    }

   @Override
    public int compareTo(Time o) {
        int result =0;
     if(!(this.hour==o.hour && this.minute==o.minute)){
         if(this.hour>o.hour){
             result =1;
             
         } else if (this.hour<o.hour){
            result = -1; 
         } else {
             if(this.minute>o.minute){
               result = 1;  
             } else{
                 result = -1;
             
             }
             
             
         } 
         
     }else{
         result =0;
     }
        
    return result;
    }

    @Override
    public String toString() {
        return  "Time{"+ this.getHour()+":"+this.getMinute()+"}.";
    }
    

}