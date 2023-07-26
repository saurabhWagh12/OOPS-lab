import java.util.*;

import javax.sound.sampled.SourceDataLine;

class DefinedExceptions extends Exception{
    String s;
    public DefinedExceptions(String s){
        this.s=s;
    }
    public DefinedExceptions(){
        s = "Error!!!";
    }
    public String getMessage(){
        return this.s;
    }
}

class PhoneDirectory{
    private boolean validate(Student s){
        if(s.name!="" && s.city!="" && s.contact!="" && s.contact.length()==10){
            if(s.roll!=0 && (s.sem<=8 && s.sem>0)){
                return true;
            }
        }
        return false;
    }

    private TreeSet<Student> studentArray = new TreeSet<>();
    void display(){
        for(Student s:studentArray)
            System.out.println(s.name+"\t");
    }

    void add(Student s){
        try{
            if(this.validate(s)){
                studentArray.add(s);
            }
            else{
                throw new DefinedExceptions("\nInvalid Student {Details missing or invalid}!!!\n");
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    void remove(Student s){
        studentArray.remove(s);
    }

    void cityWise(String city){
        for(Student s:studentArray){
            if(s.city==city){
                System.out.println("\n Student Details \n");
                System.out.println("Name: "+s.name);
                System.out.println("Contact: "+s.contact);
                System.out.println("Semester: "+s.sem);
                System.out.println("Roll: "+s.roll);
                System.out.println();
            }
        }
    }

    void viewAll(){
        Iterator<Student> stu = studentArray.iterator();
        while(stu.hasNext()){
            System.out.println("\n***** Student Details *****");
            Student s = (Student)stu.next();
                System.out.println("Name: "+s.name);
                System.out.println("Contact: "+s.contact);
                System.out.println("Semester: "+s.sem);
                System.out.println("Roll: "+s.roll);
                System.out.println("City: "+s.city);
                System.out.println();
        }
    }
}

class Student implements Comparable<Student>{
    int roll,sem;
    String name,city;
    String contact;
    public Student(int r,String n,int s,String c,String con){
        super();
        name = n; roll = r;
        city = c; sem = s; 
        contact = con;
    }

    public int compareTo(Student s){
        if(this.sem==s.sem){
            return Integer.compare(this.roll, s.roll);
        }else{
            return Integer.compare(this.sem, s.sem);

        }
    }
}

public class Prac7B{
    public static void main(String args[]){
        PhoneDirectory pd = new PhoneDirectory();
        Student s = new Student(12, "Saurabh1", 4, "nagpur", "8830035915");
        pd.add(s);
        s = new Student(2, "Saurabh2", 4, "nagpur", "8830035914");
        pd.add(s);
        s = new Student(30, "", 3, "nagpur", "7318946723");
        pd.add(s);
        s = new Student(60, "Saurabh3", 3, "nagpur", "8830035913");
        pd.add(s);

        pd.display();
        pd.viewAll();

    }
}
