import java.util.ArrayList;

class Producer extends Thread {
    int size;
    ArrayList<Integer> arr;

    public Producer(ArrayList<Integer> arr, int s) {
        this.arr = arr;
        this.size = s;
    }

    @Override
    public void run() {
        while(true) {
            synchronized (arr) {
                if (arr.size() == size) {
                    try {
                        arr.wait();
                    } catch (InterruptedException e) {
                        System.out.println("Error In Producer");
                    }
                }

                arr.add(1);
                System.out.println("Produced: " + arr.get(arr.size() - 1) + " size: " + arr.size());
                arr.notifyAll();

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println("Error In Producer");
                }
            }
        }
    }
}

class Consumer extends Thread {
    int size,id;
    ArrayList<Integer> arr;

    public Consumer(ArrayList<Integer> arr, int s,int id) {
        this.arr = arr;
        this.size = s;
        this.id = id;
    }

    public void run() {
        while (true) {
            synchronized (arr) {
                if(arr.size() == 0) {
                    try {
                        arr.wait();
                    } catch (InterruptedException e) {
                        System.out.println("Error In Consumer");
                    }
                }

                arr.remove(0);
                System.out.println("Consumed"+id+ " size: " + arr.size());
                arr.notifyAll();
            }
        }
    }
}

public class PC {
    public static void main(String args[]) throws Exception {
        ArrayList<Integer> a = new ArrayList<>();
        Producer p = new Producer(a, 5);
        Consumer c = new Consumer(a, 5,1);
        Consumer c2 = new Consumer(a, 5,2);


        p.start();
        Thread.sleep(10);
        c.start();
        c2.start();
    }
}


