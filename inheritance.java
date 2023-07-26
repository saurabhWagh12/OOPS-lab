public class inheritance {
    static class Date{
        int d,m,y;
        public Date(int d,int m,int y){
            this.d = d;
            this.m = m;
            this.y = y;
        }
    }
    static class Person{
        String name;
        Date date;
        
        Person(String name,int d,int m,int y){
            this.name = name;
            this.date = new Date(d, m, y);
        }
    }

    static class Student extends Person{
        float cgpa;
        String branch;
        public Student(String name,String branch,float gpa,int d,int m,int y){
            super(name, d, m, y);
            this.branch = branch;
            cgpa = gpa;
        }
    }

    static class Employee extends Person{
        String designation;
        double salary;
        public Employee(String name,int d,int m,int y,String desig,double sal){
            super(name, d, m, y);
            this.designation = desig;
            this.salary = sal;
        } 
    } 

    public static void main(String args[]){

    }
}
