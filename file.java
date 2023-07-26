import java.util.*;
import java.io.*;

class Student implements Serializable{
    private String name,email;
    public Student(String n,String e){
        this.name = n;
        this.email = e;
    }

    public String getName(){
        return this.name;
    }

    public String getEmail(){
        return this.email;
    }
}


public class file {
    public static void main(String args[]){
        ArrayList<Student> arr = new ArrayList<>();
        arr.add(new Student("Saurabh","waghsa1@rknec.edu"));
        arr.add(new Student("Utkarsh","waghut@rknec.edu"));
        arr.add(new Student("Rashmi","kanharkar@rknec.edu"));

        try(FileOutputStream fos = new FileOutputStream("file.txt")){
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            for(Student s:arr){
                oos.writeObject(s);   
            }
        }catch(IOException e){
            e.printStackTrace();
        }

        try(FileInputStream fis = new FileInputStream("file.txt")){
            ObjectInputStream ois = new ObjectInputStream(fis);

            while(true){
                try{
                    Student temp = (Student)ois.readObject();
                    System.out.println("Details Of Student:"+temp.getName()+ " " + temp.getEmail());

                }catch(EOFException e){
                    break;
                }catch(Exception e){
                    e.printStackTrace();
                }
            }

        }catch(IOException e){
            e.printStackTrace();
        }
            
        
    }
}
