
import java.util.*;

class Server extends Thread{
    ArrayList<Integer> arr;
    private int a;
    public Server(ArrayList<Integer> arr){
        this.arr = arr;
    }

    @Override
    public void run(){
        while(true){
            synchronized(arr){
                this.a = new Random().nextInt(100);
                arr.add(this.a);
                System.out.println("Server Updated Score: "+this.a);
                arr.notifyAll();  
            }
            try{
                Thread.sleep(1000);
                }catch(Exception e){
                    System.out.println("Error in Server");
                }
        }
        
    }

}

class Client extends Thread{
    ArrayList<Integer> arr;
    private int i;
    public Client(ArrayList<Integer> arr,int n){
        this.arr = arr;
        this.i = n;
    }

    @Override
    public void run(){
        while(true){
            synchronized(arr){
                try{
                    if(arr.isEmpty()){
                        arr.wait();
                    }else{
                        arr.wait();
                    }
                    System.out.println("Client "+i+" read Score: "+arr.get(arr.size()-1));   
                
                }catch(Exception e){
                    System.out.println("Error");
                }

                
            }

             try{
                    Thread.sleep(10);
                    continue;
                    }catch(Exception e){
                        System.out.println("Error in Client");
                    }
        }
    }
}

public class clientServer {

    public static void main(String args[]){
        ArrayList<Integer> arr = new ArrayList<>();
        // arr.add(0);
        Server s = new Server(arr);

        Client c1 = new Client(arr,1);
        Client c2 = new Client(arr,2);
        Client c3 = new Client(arr,3);
        Client c4 = new Client(arr,4);
        Client c5 = new Client(arr,5);
        Client c6 = new Client(arr,6);
        Client c7 = new Client(arr,7);
        Client c8 = new Client(arr,8);
        Client c9 = new Client(arr,9);

        c1.start();
        c2.start();

        c4.start();
        c6.start();
        c5.start();

        c9.start();
        c7.start();
        c8.start();
        c3.start();



        s.start();


    }
    
}
