import Que4.arithematic;
public class Que4main{
    public static void main(String args[]){
        int n1,n2;
        
        arithematic A = new arithematic();
        System.out.print("Enter number 1: ");
        n1 = A.sc.nextInt();
        System.out.print("Enter number 1: ");
        n2 = A.sc.nextInt();
        A = new arithematic(n1, n2);
        System.out.println("Addition of n1 and n2: "+A.add());
        System.out.println("Substraction of n1 and n2: "+A.substract());


    }
}
