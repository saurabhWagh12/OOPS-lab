import java.util.Scanner;

public class Que6 {

    static class Time{
        int hour,min,sec;
        public Time(int h,int m){
            hour = h;
            min = m;
            // sec = s;
        }
        
        public Time addition(Time t){
            int i = this.hour*60*60+this.min*60;
            int j = t.hour*60*60+t.min*60;
            
            int finTime= i+j;
            
            Time time = new Time(0,0);
            time.hour = finTime/3600;
            time.min = (finTime-(time.hour*3600))/60;
            // time.sec = finTime - (time.hour*3600) - (time.min*60);
            return time;
        }
        
        public Time substraction(Time t){
            int i = this.hour*60*60+this.min*60;
            int j = t.hour*60*60+t.min*60;
            
            int finTime; 

            if(i<j){
                finTime = j-i;
                
            }else{
                finTime = 86400 + (j-i);
            }

            Time time = new Time(0,0);
            time.hour = finTime/3600;
            time.min = (finTime-(time.hour*3600))/60;
            // time.sec = finTime - (time.hour*3600) - (time.min*60);
            return time;
        }
    }

    static class GreatClock extends Time{
        int sec;
        private int miliSecTosec;
        public int mili;

        public GreatClock(int h,int m,int sec,int mili){
            super(h, m);
            this.sec = sec;
            this.mili = mili;
            this.miliSecTosec = (int)(mili/1000.0);
        }

        public Time addition(GreatClock t){
            int i = this.hour*60*60+this.min*60+this.sec+this.miliSecTosec;
            int j = t.hour*60*60+t.min*60+t.sec+t.miliSecTosec;
            
            int finTime= i+j;
            
            GreatClock time = new GreatClock(0,0,0,0);
            time.hour = finTime/3600;
            time.min = (finTime%3600)/60;
            time.sec = finTime%60;
            time.mili = time.sec*1000;
            
            return time;
        }

        public Time substraction(GreatClock t){
            int i = this.hour*60*60+this.min*60+this.sec+this.miliSecTosec;
            int j = t.hour*60*60+t.min*60+t.sec+t.miliSecTosec;
            
            int finTime; 

            if(i<j){
                finTime = j-i;
                
            }else{
                finTime = 86400 + (j-i);
            }

            GreatClock time = new GreatClock(0,0,0,0);
            // time.hour = finTime/3600;
            // time.min = (finTime%3600)/60;
            // time.sec = finTime%60;
            // time.mili = time.sec*1000;
            time.hour = finTime/3600;
            time.min = (finTime-(time.hour*3600))/60;
            time.sec = finTime - (time.hour*3600) - (time.min*60);
            return time;
        }

    }


    static class TimeZone extends Time{
        public TimeZone(int h,int m){
            super(h, m);
        }

        public Time addition(Time t,String s){
            int i=0;
            int j=0;
            Scanner scan = new Scanner(System.in);
            // System.out.print("Enter the code for TimeZone you want Time of {example:(USA,UK)} : ");
            // String z = scan.next();
            scan.close();
            if(s.equals("USA")){
                i = this.hour*60*60+this.min*60+34200;
                j = t.hour*60*60+t.min*60+34200;
            }else if(s.equals("UK")){
                i = this.hour*60*60+this.min*60+16200;
                j = t.hour*60*60+t.min*60+16200;
            }
            int finTime= i+j;
            
            Time time = new Time(0,0);
            time.hour = finTime/3600;
            time.min = (finTime%3600)/60;

            return time;
        }

        public Time substraction(Time t,String s){
            int i=0;
            int j=0;
            Scanner scan = new Scanner(System.in);
            // System.out.print("Enter the code for TimeZone you want Time of {example:(USA,UK)} : ");
            // String z = scan.next();
            scan.close();
            if(s.equals("USA")){
                i = this.hour*60*60+this.min*60+34200;
                j = t.hour*60*60+t.min*60+34200;
            }else if(s.equals("UK")){
                i = this.hour*60*60+this.min*60+16200;
                j = t.hour*60*60+t.min*60+16200;
            }

            int finTime;
            if(i<j){
                finTime = j-i;
                
            }else{
                finTime = 86400 + (j-i);
            }

            Time time = new Time(0,0);
            time.hour = finTime/3600;
            time.min = (finTime%3600)/60;

            return time;
        }

        public Time convert(){
            int i=0;
            Scanner scan = new Scanner(System.in);
            System.out.print("Enter the code for TimeZone you want Time of {example:(USA,UK)} : ");
            String z = scan.next();
            scan.close();
            Time time = new Time(0,0);

            if(z.equals("USA")){
                i = this.hour*60*60+this.min*60;
                time.hour = (i/3600)+9;
                time.min = ((i%3600)/60)+30;
            }else if(z.equals("UK")){
                i = this.hour*60*60+this.min*60;
                time.hour = i/3600+4;
                time.min = (i%3600)/60+30;
            }

            
            if(time.hour>24){
                time.hour = time.hour-24;
            }
            int d = 0;
            time.min = (i%3600)/60+30;
            if(time.min>60){
                d = time.min-60;
                time.min = d;
                time.hour+=1;
            }else if(time.min==60){
                time.min = 0;
                time.hour+=1;
            }

            return time;
        }
    }


    public static void main(String args[]){
        TimeZone uk = new TimeZone(17, 30);
        Time t = new Time(17, 0);
        t = uk.substraction(t);
        System.out.println(t.hour+" "+t.min);
        t = uk.convert();
        System.out.println("Converted time: "+t.hour+" "+t.min);

        GreatClock g = new GreatClock(4, 30, 50, 10000);
        GreatClock gdash = new GreatClock(4, 0, 50, 10000);
        Time tgreat = g.addition(gdash);
        System.out.println("Hours: "+tgreat.hour+" "+"Minutes: "+tgreat.min+" "+"Seconds: "+t.sec+" ");

        g = new GreatClock(14, 30, 50, 10000);
        gdash = new GreatClock(17, 0, 50, 10000);
        tgreat = g.substraction(gdash);
        System.out.println("Hours: "+tgreat.hour+" "+"Minutes: "+tgreat.min+" "+"Seconds: "+t.sec+" ");
        

    }
}
