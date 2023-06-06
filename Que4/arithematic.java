package Que4;
import java.util.Scanner;

public class arithematic{
    private double n1,n2;
    public Scanner sc = new Scanner(System.in);
    public arithematic(){
        this.n1 = this.n2 = 0.0;
    }
    public arithematic(double n1,double n2){
        this.n1 = n1;
        this.n2 = n2;
    }
    public double add(){
        return this.n1+this.n2;
    }
    public double substract(){
        if(this.n1>=this.n2)
            return this.n1-this.n2;
        else{
            return this.n2-this.n1;
        }    
    }
}