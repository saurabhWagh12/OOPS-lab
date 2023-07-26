import java.util.*;

class MyArray<T>{
    private ArrayList<T> arr;
    private static int size,count;

    public MyArray(){
        arr = new ArrayList<>();
        arr.ensureCapacity(1);
        arr.add(null);
        size = 1; count = 0;
    }

    private void grow(T t){
        size=(int)Math.ceil(size*1.5);
        arr.ensureCapacity(size);
        arr.add(t);
        count++;
    }

    public void add(T t){
        if(arr.get(0)==null){
            arr.remove(null);
            size=(int)Math.ceil(size*1.5);
            arr.ensureCapacity(size);
            arr.add(t);
            count++;
        }else if(size==count){
            grow(t);;
        }
        else{
            arr.add(t);
            count++;
        }

    }

    public void swap(int i,int j){
        if(i!=j){
            Collections.swap(arr, i, j);
        }
    }

    public void display(){
        System.out.println("List Now: "+arr+" current size of List :"+count+" "+", Max-Size: "+size+"\n");
    } 

}

public class Main{
    public static void main(String args[]){
        MyArray<Integer> iarr = new MyArray<>();
        iarr.add(12);
        iarr.display();
        iarr.add(13);
        iarr.display();
        iarr.add(14);
        iarr.add(15);
        iarr.add(16);
        iarr.display();
        iarr.add(17);
        iarr.display();
        iarr.swap(2, 4);
        System.out.println("Display of List After Swap: ");
        iarr.display();
   
    }

}