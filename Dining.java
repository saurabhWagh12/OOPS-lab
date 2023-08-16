import java.util.*;

class thread implements Runnable{
    int forks[];
    private int i;
    public thread(int arr[],int i){
        this.forks = arr;
        this.i = i;
    }

    @Override
    public void run(){
        while(true){
            synchronized(forks){
                forks[i] = 1;
                forks[(i+1)%5] = 1;
                forks.notifyAll();
            }
            if(forks[i]==1 && forks[(i+1)%5]==1)
                System.out.println("Eating: "+(this.i+1));
            else if(forks[i]!=1 || forks[(i+1)%5]!=1){
                System.out.println("thinking: "+(this.i+1));
                try{
                    forks.wait();
                }catch(Exception e){e.printStackTrace();}
            }
            synchronized(forks){
                forks[i] = 0;
                forks[(i+1)%5] = 0;
                forks.notifyAll();
            }
            try{
                Thread.sleep(1000);
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
}

public class Dining{
    public static void main(String args[]){
        int arr[] = new int[5];
        Arrays.fill(arr,0);
        thread t1,t2,t3,t4,t5; 
        t1 = new thread(arr, 0);
        t2 = new thread(arr, 1);
        t3 = new thread(arr, 2);
        t4 = new thread(arr, 3);
        t5 = new thread(arr, 4);

        Thread g1,g2,g3,g4,g5;
        g1 = new Thread(t1);
        g2 = new Thread(t2);
        g3 = new Thread(t3);
        g4 = new Thread(t4);
        g5 = new Thread(t5);

        g1.start();
        g2.start();
        g3.start();
        g4.start();
        g5.start();





    }
}
