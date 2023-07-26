public class interfaces {
    static class Employee{
        long employeeId;
        String employeeName;
        public Employee(long id,String name){
            this.employeeId = id;
            this.employeeName = name; 
        }

        void display(){
            System.out.println("*****Employee Details******");
            System.out.println("Employee ID: "+this.employeeId);
            System.out.println("Employee Name: "+this.employeeName);
        }

    }

    interface Taxable{
        public double taxFinding();
        void display();
    }

    static class permanent extends Employee implements Taxable{

        double salary;
        double additionalEarning;

        public permanent(long id,String name,double sal,double additional){
            super(id, name);
            this.salary = sal;
            this.additionalEarning = additional;
        }

        void additionalEarnings(double additional){
            this.additionalEarning = additional;
        }
        
        public double taxFinding(){
            if(this.salary>=100000 && this.salary<=500000){
                return this.salary*0.1;
            }else if(this.salary>=500000){
                return this.salary*0.2;
            }
            return 0.0;
        }

        public void display(){
            super.display();
            System.out.println();
            System.out.println("*****Permanent Employee*****");
            System.out.println("Earning's: "+this.salary);
            System.out.println("Additional Earning: "+this.additionalEarning);
        }
    }

    static class HourlyEmployee extends Employee{
        int hoursWorked;
        int rate;

        public HourlyEmployee(long id,String name,int hours,int rate){
            super(id, name);
            this.hoursWorked = hours;
            this.rate = rate;
        }
    }

   
    public static void main(String args[]){
        permanent e = new permanent(1234567, "Saurabh Wagh", 2500000, 100000);
        e.display();

    }
}
