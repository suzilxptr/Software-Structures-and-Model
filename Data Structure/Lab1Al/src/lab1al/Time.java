package lab1al;

import java.util.Date;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author The BigBang
 */
public class Time {
    private int hours;
    private int minutes;
   
    public Time(){
        this.hours=0;
        this.minutes=0;
       
    }
     public Time(int h, int m){
    this.hours=h;
    this.minutes=m;
   
    }
    public void setTime(int h, int m){
    this.hours=h;
    this.minutes=m;
   
    }
    
    public void read(String what){
   Scanner s1=new Scanner(System.in);
   System.out.println(what);
   String s=s1.nextLine();
  String[] timearr = s.split(":");
    int hr=Integer.parseInt(timearr[0]);
    int min=Integer.parseInt(timearr[1]);
    setTime(hr,min);    }
    
    public boolean lessThan(Time t){
        boolean val;
        int hr2=t.hours;
        int min2=t.minutes;
        if (hours>hr2 ||hours==hr2&&minutes>min2){
        val=false;
        }else val=true;
        return val;
    }
    
   public Time subtract(Time time1) {
       int hrs = 0, mins = 0;
    if(!this.lessThan(time1)){
    hrs=hours-time1.hours;
    if (minutes<time1.minutes){
        hrs--;
        mins=60+(minutes-time1.minutes);
    }else mins=minutes-time1.minutes;
    }
    return new Time(hrs,mins);
   }

    public void print() {
        System.out.println(String.format("%02d:%02d", hours, minutes));
    }
    
}