public class Practical4{
    protected static long countsaving = 11100;
    protected static long countFixed = 55500;

    static class BankAccount{
        long accNo,aadharNo;
        String name;
        double ROI;
        double balance;
        public void openAccount(long adno,String name,long count){
            this.accNo = count;
            System.out.println();
            System.out.println("Account Created for: "+name+" with account Number: "+accNo);
            System.out.println();
            this.aadharNo = adno;
            this.name = name;
            this.balance = 0.0;
        }
        public double deposit(double amount){
            this.balance += amount;
            return this.balance;
        }

        //saving case
        private double updateInterest(){
            this.ROI = this.balance*0.04;
            this.balance+=this.balance*0.04;
            return this.ROI;
        }
        

    }

    interface Debitable{
        public double withdrawl(double amount);
    }

    static class FixedDepositAccount extends BankAccount{
        int lockinPeriod;

        private void FixedDepositAccountLocin(int locin){
            this.lockinPeriod = locin;
        }

        public void createFixedDepositAccount(long adno,String name,double bal,int locin){
            super.openAccount(adno,name,++countFixed);
            super.balance = bal;
            this.FixedDepositAccountLocin(locin);
        }

        private double updateInterest(){
            if(this.lockinPeriod>=1 && this.lockinPeriod<=2){
                super.ROI = this.balance*0.06;
                this.balance+=this.balance*0.06;
            }else if(this.lockinPeriod>=2 && this.lockinPeriod<=5){
                super.ROI = this.balance*0.065;
                this.balance+=this.balance*0.065;
            }else if(this.lockinPeriod>=5){
                super.ROI = this.balance*0.07;
                this.balance+=this.balance*0.07;
            }

            
            return super.ROI;

        }

        public double closeAccount(int year){
            if(this.lockinPeriod>year){
                double returning = 0.05*this.balance;
                System.out.println("Account is closed");
                this.balance-=returning;
                return this.balance;
            }
            System.out.println("Account is closed");
            double ba = this.balance;
            this.balance = 0;
            return ba;
        }

        public void display(){
            System.out.println();
            System.out.println();
            System.out.println("*****Fixed Account Details*****");
            System.out.println("Account Holder name: "+super.name);
            System.out.println("Account Number: "+super.accNo);
            System.out.println("Aadhar Number: "+super.aadharNo);
            System.out.println("Account balance: "+super.balance);
            System.out.println("Lockin Period: "+this.lockinPeriod);
            System.out.println("Updated interest: "+this.updateInterest());
        }

    }

    static class SavingAccount extends BankAccount implements Debitable{
        public void createSavingAccount(long adno,String name,double bal){
            super.openAccount(adno,name,++countsaving);
            super.balance = bal;
        }
        
        public double withdrawl(double amount){
            super.balance -= super.balance-amount;
            return super.balance;
        }

        public double closeAccount(){
            double ba = this.balance;
            System.out.println("Account Closed");
            this.balance = 0.0;
            return ba;  
        }

        public void display(){
            System.out.println();
            System.out.println();
            System.out.println("*****Saving's Account Details*****");
            System.out.println("Account Holder name: "+super.name);
            System.out.println("Account Number: "+super.accNo);
            System.out.println("Aadhar Number: "+super.aadharNo);
            System.out.println("Account balance: "+super.balance);
            System.out.println("Updated interest: "+super.updateInterest());
        }
    }



    public static void main(String args[]){
        FixedDepositAccount fd1 = new FixedDepositAccount();
        fd1.createFixedDepositAccount(12345678, "Saurabh", 50000, 3);
        fd1.display();
        System.out.println(fd1.closeAccount(1));
        SavingAccount sv1 = new SavingAccount();
        sv1.createSavingAccount(12345678, "Ajay",100000);
        sv1.display();
        sv1.deposit(100000);
        sv1.display();
        System.out.println(sv1.closeAccount());

        FixedDepositAccount fd2= new FixedDepositAccount();
        fd2.createFixedDepositAccount(12347698, "Ram", 40000, 1);
        fd2.display();

    }
}