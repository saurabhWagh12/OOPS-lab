import java.util.*;

class SorterOfStudent implements Comparator<Student>{

    public int compare(Student s1,Student s2){
        return Integer.compare(s1.getAge(),s2.getAge());
    }

}

class Student implements Comparable<Student>{
    private String name;
    private int age,sem;

    public Student(String n,int a,int sem){
        this.name = n;
        this.age = a;
        this.sem = sem;
    }

    public int compareTo(Student s){
        return Integer.compare(this.age,s.age);
    }

    public String getName(){
        return this.name;
    }

    public int getAge(){
        return this.age;
    }

}


public class collections {
    public static void main(String args[]){
            TreeSet<Student> arr= new TreeSet<>();
            ArrayList<Student> alist = new ArrayList<>();
            ArrayList<Student> alist2 = new ArrayList<>();

            Student s = new Student("Saurabh",20,4);
            arr.add(s);
            alist.add(s);
            alist2.add(s);
            s = new Student("Rashmi",19,4);
            arr.add(s);
            alist.add(s);
            alist2.add(s);
            s = new Student("Utkarsh",13,0);
            arr.add(s);
            alist.add(s);
            alist2.add(s);
            
            System.out.println("TreeSet:");
            for(Student student : arr){
                System.out.println("Name: "+student.getName());
            }

            Collections.sort(alist);
            System.out.println("\nArrayList:");
            for(Student student : alist){
                System.out.println("Name: "+student.getName());
            }

            Collections.sort(alist2,new SorterOfStudent());
            System.out.println("\nArrayList 2:");
            for(Student student : alist2){
                System.out.println("Name: "+student.getName());
            }



    }
}
