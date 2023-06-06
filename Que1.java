import java.time.LocalDate;
import java.time.Period;
import java.util.*;
public class Que1{

    static class Person{
        String name;
        int DOB[];
        public Person(String name,int d,int m,int y){
            this.name = name;
            this.DOB = new int[3];
            DOB[0] = d; DOB[1] = m; DOB[2] = y; 
        }
    }

    static class Student extends Person{
        int rollNo,semester; float cgpa;
        public Student(String name,int d,int m,int y,int roll,int sem,float cgpa){
            super(name, d, m, y);
            this.rollNo = roll;
            this.cgpa = cgpa;
            this.semester = sem;
        }

    }

    static class Teacher extends Person{
        double salary;
        int experience;
        String qualifications;
        public Teacher(String name,int d,int m,int y,int exp,String qualification){
            super(name, d, m, y);
            this.experience = exp;
            // this.salary = sal;
            this.qualifications = qualification;
        }
    }


    static class Department{
        String nameOfDepartment;
        private Student studArr[];
        private Teacher teachArr[];
        int ageofStudents[];
        int ageofTeachers[]; 
        private Scanner sc = new Scanner(System.in);

        public Department(String name,int stud,int teach){
            studArr = new Student[stud];
            teachArr = new Teacher[teach];
            ageofStudents = new int[stud];
            ageofTeachers = new int[teach];
            this.nameOfDepartment = name;
        } 

        public void setStudents(){
            String name;int d;int m;int y;int roll;int sem;float cgpa;
            System.out.println("*****Enter Details Of student's:*****");
            System.out.println();
            for(int i=0;i<this.studArr.length;i++){
                System.out.print("Enter name of Student "+(i+1)+" : "); name = sc.next();
                System.out.print("Enter date for Date Of Birth of Student "+(i+1)+" : "); d = sc.nextInt();
                System.out.print("Enter month for Date Of Birth of Student "+(i+1)+" : "); m = sc.nextInt();
                System.out.print("Enter year for Date Of Birth of Student "+(i+1)+" : "); y = sc.nextInt();
                System.out.print("Enter roll number of Student "+(i+1)+" : "); roll = sc.nextInt();
                System.out.print("Enter Semester number of Student "+(i+1)+" : "); sem = sc.nextInt();
                System.out.print("Enter CGPA of Student "+(i+1)+" : "); cgpa = sc.nextFloat();

                studArr[i] = new Student(name, d, m, y, roll,sem, cgpa);
            }
            System.out.println();
        }

        public void setTeacher(){
            String name;int d;int m;int y;double sal;int exp;String qualification;
            System.out.println("*****Enter Details Of Teacher's:*****");
            System.out.println();
            for(int i=0;i<this.teachArr.length;i++){
                System.out.print("Enter name of Teacher "+(i+1)+" : "); name = sc.next();
                System.out.print("Enter date for Date Of Birth of Teacher "+(i+1)+" : "); d = sc.nextInt();
                System.out.print("Enter month for Date Of Birth of Teacher "+(i+1)+" : "); m = sc.nextInt();
                System.out.print("Enter year for Date Of Birth of Teacher "+(i+1)+" : "); y = sc.nextInt();
                // System.out.print("Enter Salary of Teacher "+(i+1)+" : "); sal = sc.nextDouble();
                System.out.print("Enter year's of Experience of Teacher "+(i+1)+" : "); exp = sc.nextInt();
                System.out.print("Enter Qualification's of Teacher "+(i+1)+" : "); qualification = sc.next();

                teachArr[i] = new Teacher(name, d, m, y, exp, qualification);
            }
            System.out.println();
        }

        public void calculateAge(){
            for(int i=0;i<this.studArr.length;i++){
                Student s = this.studArr[i];
                LocalDate birDate = LocalDate.of(s.DOB[2],s.DOB[1],s.DOB[0]);
                LocalDate today = LocalDate.now();
                Period age = Period.between(birDate, today);
                ageofStudents[i] = age.getYears();
            }
            for(int i=0;i<this.teachArr.length;i++){
                Teacher t = this.teachArr[i];
                LocalDate birDate = LocalDate.of(t.DOB[2],t.DOB[1],t.DOB[0]);
                LocalDate today = LocalDate.now();
                Period age = Period.between(birDate, today);
                ageofTeachers[i] = age.getYears();
            }
        }

        public int[] minAndMaxAgeOfTeachers(){
            int minmax[]=new int[2];

            int max = Arrays.stream(ageofTeachers).max().getAsInt();
            // System.out.println("Maximum value: " + max);
            int min = Arrays.stream(ageofTeachers).min().getAsInt();
            minmax[0] = min; minmax[1] = max;
            return minmax;
        }

        public double averageAgeOfStudents(){
            double s=0.0;
            for(int i=0;i<this.ageofStudents.length;i++){
                s+=this.ageofStudents[i];
            }

            return (s/(this.ageofStudents.length));
        }

        private double findSalary(String quali,int exp){
            double Salary=0.0;
            if(quali.equals("PG")){
                Salary = 60000.0+exp*2000;
            }else if(quali.equals("PHD")){
                 Salary = 80000.0+exp*2000;
            }
            return Salary;
        }
        
        public void calculateSalary(){
            for(int i=0;i<this.teachArr.length;i++){
                Teacher t = teachArr[i];
                t.salary = findSalary(t.qualifications,t.experience); 
            }
        }

        public double departmentalAverage(){
            double average=0.0;
            for(int i=0;i<this.studArr.length;i++){
                average += this.studArr[i].cgpa;
            }
            return (average/(this.studArr.length));
        }

        public double semesterAverage(int sem){
            double average=0.0;
            int count=0;
            for(int i=0;i<this.studArr.length;i++){
                if(this.studArr[i].semester==sem){
                    average+=this.studArr[i].cgpa;
                    count++;
                }
            }
            return (average/count);
        }
    }

    public static void main(String args[]){
        Department CSE = new Department("CSE", 3, 2);
        CSE.setStudents();
        CSE.setTeacher();
        CSE.calculateAge();
        CSE.calculateSalary();
        int ageOfTeach[] = CSE.minAndMaxAgeOfTeachers();
        System.out.println("Max Age of Teacher: "+ageOfTeach[1]+"   "+"Min Age of Teacher: "+ageOfTeach[0]);
        System.out.println("Average Age of Students: "+CSE.averageAgeOfStudents()); 
        System.out.println("Departmental Average: "+CSE.departmentalAverage());
        System.out.println("Semester Average: "+CSE.semesterAverage(3));


    }
}