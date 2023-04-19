/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practical3;
import java.util.*;

/**
 *
 * @author SRCOEM
 */
public class Practical3 {
    
     static class Time{
        long hour,min,sec;
        public Time(long h,long m,long s){
            hour = h;
            min = m;
            sec = s;
        }
        
        public Time addition(Time t){
            long i = this.hour*60*60+this.min*60+this.sec;
            long j = t.hour*60*60+t.min*60+t.sec;
            
            long finTime= i+j;
            
            Time time = new Time(0,0,0);
            time.hour = finTime/3600;
            time.min = (finTime-(time.hour*3600))/60;
            time.sec = finTime - (time.hour*3600) - (time.min*60);
            return time;
        }
        
        public Time substraction(Time t){
            long i = this.hour*60*60+this.min*60+this.sec;
            long j = t.hour*60*60+t.min*60+t.sec;
            
            long finTime; 
//                    Math.abs(i-j);
            if(i<j){
                finTime = j-i;
                
            }else{
                finTime = 86400 + (j-i);
            }
            Time time = new Time(0,0,0);
            time.hour = finTime/3600;
            time.min = (finTime-(time.hour*3600))/60;
            time.sec = finTime - (time.hour*3600) - (time.min*60);
            return time;
        }
    }
    
    
    static class Attendence{
        Time tin;
        Time tout;
        int day,month,year;
        
        public Attendence(Time tin,Time tout,int d,int m,int y){
            this.tin = tin;
            this.tout = tout;
            this.day = d;
            this.month = m;
            this.year = y;
        }
        
    }
    
    static class Employee{
        String name,designation;
        int id,age;
        double salary;
        Attendence attend[];
        
        public Employee(String name,String designation,int id,int age,double sal,Attendence a[]){
            this.name = name;
            this.designation = designation;
            this.id = id; this.age = age;
            this.salary = sal;
            attend = a;
            
        }
        
        public Time noHoursWorked(){
            Time t = new Time(0,0,0);
            for(int i=0;i<this.attend.length;i++){
                t = t.addition(this.attend[i].tout.substraction(this.attend[i].tin));
            }
            return t;
        }
        
        public Time forGivenDate(int d,int m,int y){
            Time t = new Time(0,0,0);
            for(int i=0;i<this.attend.length;i++){
                if(this.attend[i].day == d && this.attend[i].month == m && this.attend[i].year == y ){
                   t = this.attend[i].tout.substraction(this.attend[i].tin);
                   break;
                }
            }
            return t;
        }
        
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Attendence a[] = new Attendence[3];
        Time in = new Time(10,10,0);
        Time out = new Time(5,5,30);
        a[0] = new Attendence(in,out,19,4,23);
        in = new Time(11,00,30);
        out = new Time(5,30,40);
        a[1] = new Attendence(in,out,20,4,23);
        in = new Time(13,10,0);
        out = new Time(6,50,30);
        a[2] = new Attendence(in,out,21,4,23);
        
        Employee e1 = new Employee("Shreyansh","SDE",1234,23,2500000,a);
        Time t = e1.noHoursWorked();
        System.out.println(t.hour+":"+t.min+":"+t.sec);
        
        t = e1.forGivenDate(21, 4, 23);
        System.out.println(t.hour+":"+t.min+":"+t.sec);
        
        
        
        
//        Employee e1 = new Employee();

    }
    
}
