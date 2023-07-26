import java.util.*;
public class adderThread{
    static int sum;static int count;
    static class Adder extends Thread{
        ArrayList<Integer> arr; int s,e;
        public Adder(ArrayList<Integer> a,int s,int e){
            this.arr = a; this.s = s; this.e = e;
            this.start();
        }

        @Override
        public void run(){
            
            synchronized(arr){if(count==0){
                count++;
            synchronized(arr){
                for(int i=s;i<e;i++){
                    sum+=arr.get(i);
                }
                count--;
                arr.notifyAll();
            }
        }else{
            try{
                arr.wait();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
        

        }

    }

    public static void main(String args[]){
        sum =count= 0;
        ArrayList<Integer> arr=new ArrayList<>();
        for(int i=0;i<100;i++){
            arr.add(i,1);
        }
        Adder a1,a2,a3,a4;

        a1 = new Adder(arr, 0, 25);
        a2 = new Adder(arr, 25, 50);
        a3 = new Adder(arr, 50, 75);
        a4 = new Adder(arr, 75, 100);

        

        try{
            // Thread.sleep(10);
            a1.join(100);
            a3.join(100);
            a2.join(100);
            a4.join(100);
            System.out.println("Threads Joined");
        }catch(Exception q){
            q.printStackTrace();
        }

        System.out.println(sum);



    }
}