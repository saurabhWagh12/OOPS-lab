import java.util.*;

class T extends Thread{
    public boolean forks[];
    int i;

    public T(String a,boolean f[],int i){
        this.setName(a);
        this.i = i;
        this.forks = f;
    }

    private void eat(){
        System.out.println("Philosopher "+i+" is eating");
    }

    @Override
    public void run(){
        while(true){
        synchronized(forks){
            forks[i] = true;
            forks[(i+1)%5] = true;
            eat();
            forks[i] = false;
            forks[(i+1)%5] = false;
        }
        try{
            this.sleep(1000);
        }catch(Exception e){
            e.printStackTrace();
        }
        }
    }
}

public class dining {
    public static void main(String args[]){
        boolean forks[] = new boolean[5];
        T t1 = new T("Thread1", forks, 0);
        T t2 = new T("Thread2", forks, 1); 
        T t3 = new T("Thread3", forks, 2); 
        T t4 = new T("Thread4", forks, 3); 
        T t5 = new T("Thread5", forks, 4); 

        t2.start();
        t5.start();
        t1.start();
        t4.start();
        t3.start();

 
    }
}
