import java.util.*;

class Mythread extends Thread{
    public int start,end,ans,arr[];
    public Mythread(int arr[],int a,int b){
        this.start = a;
        this.end = b; 
        this.ans = 0;
        this.arr = arr;
    }

    @Override
    public void run(){
        for(int i=this.start;i<=this.end;i++){
            this.ans+=this.arr[i];
        }
    }

}


public class thread{
    public static void main(String args[]){
        int arr[] = {1,2,3,4,5,6,7,8,9,10};
        Mythread t1 = new Mythread(arr,0,4);
        Mythread t2 = new Mythread(arr,5,9);
        t1.start();
        t2.start();
        try{
            t1.join();
            t2.join();
        }catch(Exception e){
            e.printStackTrace();
        }
        
        int ans = t1.ans+t2.ans;
        System.out.println(ans);
    }
}
