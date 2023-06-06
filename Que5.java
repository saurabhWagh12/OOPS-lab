import java.util.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Que5{
    private static class userDefinedExceptions extends Exception{
        public userDefinedExceptions(){
            super();
        }
        public userDefinedExceptions(String s){
            super(s);
        }
    }

    static class Vehicle{
        private String name,regNo;
        private String pattern = "[A-Z]{2}-\\d{2} [A-Z]{2}-\\d{4}";
        public Vehicle(String n,String r){
            this.name = n;
            this.regNo = r;
        }

        private void display(){
            System.out.println();
            System.out.println("***** Car Details *****");
            System.out.println("Name of CAR: "+this.name);
            System.out.println("Registration Number of Car: "+this.regNo);
            System.out.println();
        }

        public void checker(){
            int numCount=0;
            for(int i=this.regNo.length()-1;i>=0;i--){
                if(this.regNo.charAt(i)=='-'){
                    break;
                }
                    numCount++;
            }

            String arr[] = {"MH","MP","AP","DL","GJ"};
            String checkingReg = this.regNo.substring(0,2);
            boolean checking = false;
            for(int i=0;i<arr.length;i++){
                if(arr[i].equals(checkingReg)){
                    checking = true;
                    break;
                }
            } 

            Pattern regex = Pattern.compile(pattern);
            Matcher matcher = regex.matcher(this.regNo);

            try{
                if(checking && matcher.matches() && numCount==4){
                    // System.out.println("Everything is good");
                    this.display();
                    return;
                }else{
                    throw new userDefinedExceptions("Not a valid Registration Number");
                }
            }catch(userDefinedExceptions e){
                System.out.println(e.getMessage());
            }
        }

        

    }

    public static void main(String args[]){
        Vehicle v = new Vehicle("Audi-R8", "MH-31 AL-8207");
        v.checker();
    }
}
