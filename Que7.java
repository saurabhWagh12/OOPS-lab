public class Que7 {
    public interface Employee{
        public double getSalary();
        public void display();
    }
    public interface TemporaryEmployee extends Employee{
        public double hourlySalary(int hours);
    }
    public interface PermanentEmployee extends Employee{
        public double bonusSalary(int years);
    }
    public interface Manager extends Employee{
        public String leading();
    }

    public interface Consultant extends TemporaryEmployee{
        public double salaryForExtraWork();
    }

    static class ConsultantManager implements Consultant,Manager{
        int hours;
        String name;
        double total;
        int extraHours;
        String leadingTeam;
        public ConsultantManager(String n,int hours,int extra,String leading){
            this.name = n;
            this.extraHours = extra;
            this.leadingTeam =leading;
            this.hours = hours;
        }
        public String leading(){
            return this.leadingTeam;
        }

        public double hourlySalary(int h){
            return h*5000;
        }

        public double salaryForExtraWork(){
            return this.extraHours*3000;
        }

        public double getSalary(){
            this.total = this.hourlySalary(this.hours)+this.salaryForExtraWork();
            return this.total;
        }

        public void display(){
            System.out.println("******* Consultant Manager Information *******");
            System.out.println("Name: "+this.name);
            System.out.println("Leading Team: "+leading());
            System.out.println("Salary: "+getSalary());
        }
    }

    static class Director implements Manager{
        String name;
        double salary;
        double total;
        int esop;
        double stockPrice;
        String leadingTeam;

        public Director(String n,double sal,int esop,double stockPrice,String leading){
            this.esop = esop;
            this.leadingTeam = leading;
            this.name = n;
            this.salary = sal;
            this.stockPrice = stockPrice;
        }

        public String leading(){
            return this.leadingTeam;
        }

        public double getSalary(){
            this.total = this.salary+this.stockPrice*this.esop;
            return this.total;
        }

        public void display(){
            System.out.println("******* Director's Information *******");
            System.out.println("Name: "+this.name);
            System.out.println("Leading: "+leading());
            System.out.println("Salary: "+getSalary());
        }
    }

    static class PermanentManager implements Manager,PermanentEmployee{
        String name;
        double salary;
        int esop;
        double total;
        double stockPrice;
        int years;
        String leadingTeam;
        public PermanentManager(String n,double sal,int esop,double stockPrice,int y,String Leading){
            this.esop = esop;
            this.leadingTeam = Leading;
            this.years = y;
            this.salary = sal;
            this.name = n;
            this.stockPrice = stockPrice;
        }

        public String leading(){
            return this.leadingTeam;
        }

        public double bonusSalary(int y){
            return 100000*y;
        }

        public double getSalary(){
            this.total = this.salary+this.stockPrice*this.esop+this.bonusSalary(this.years);
            return this.total;
        }

        public void display(){
            System.out.println("******* Permanent Manager's Information *******");
            System.out.println("Name: "+this.name);
            System.out.println("Leading: "+this.leading());
            System.out.println("Salary: "+getSalary());
        }

    }



    public static void main(String args[]){
        PermanentManager PM = new PermanentManager("Saurabh Wagh", 2500000, 2, 12000, 4, "ChatGpt");
        PM.display();
        
        Director D = new Director("Anup Wagh", 3500000, 10, 12000, "Strategy Team");
        D.display();

        ConsultantManager CM = new ConsultantManager("Rashmi", 30, 10, "Consulting Team");
        CM.display();
    }
    
}
