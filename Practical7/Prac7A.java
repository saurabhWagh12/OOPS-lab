import java.util.*;

class MyArray<T> {
    T arr[];
    static int size; static int count;

    MyArray() {
        this.arr = (T[]) new Object[1];
        this.size = 1;
        count = 0;
    }

    private void grow(T t) {
        this.size += Math.ceil(this.size * 1.5);
        T adash[] = (T[]) new Object[size];
        int i;
        for (i = 0; i < count; i++) {
            adash[i] = arr[i];
        }
        adash[i] = t;
        arr = adash;
        count++;
    }

    public void add(T t) {
        if (this.arr.length == 1) {
            this.size += Math.ceil(this.size * 1.5);
            arr = (T[]) new Object[size];
            arr[0] = t;
            count++;
        } else if (this.size == count+1) {
            grow(t);
        } else {
            arr[count] = t;
            count++;
        }
    }

    void swap(int i,int j){
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    void display() {
        System.out.println("Size: "+size);
        System.out.print("Array:\t");
        for (int i = 0; i <count; i++) {
            System.out.print(arr[i] + "\t");
        }
        System.out.println();
    }
}

public class Prac7A {
    public static void main(String args[]) {
        MyArray<Integer> myarr = new MyArray<>();
        myarr.add(5);
        myarr.display();
        myarr.add(4);
        myarr.add(3);
        myarr.display();
        myarr.add(2);
        myarr.display();

        myarr.add(1);
        myarr.add(3);
        myarr.add(4);
        myarr.add(5);
        myarr.display();
        myarr.swap(1, 4);
        System.out.println("After Swap: ");
        myarr.display();

    }
}
