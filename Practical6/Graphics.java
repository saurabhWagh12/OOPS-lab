import java.util.*;

abstract class Figure{
    abstract void display();
    abstract double length();
}

abstract class Open extends Figure{

}

abstract class Closed extends Figure{
    abstract double area();
}

 class Point{
    double x,y;
}
 class Line extends Open{
    private Point p1 = new Point();
    private Point p2 = new Point();
    public Line(double xdash,double ydash,double x1,double y1){
        p1.x = xdash;
        p1.y = ydash;
        p2.x = x1;
        p2.y = y1;
    }

    void display(){
        System.out.println("***** Details of points in Line *****");
        System.out.println("P1 details: ");
        System.out.println("x: "+p1.x+" , "+"y: "+p1.y);
        System.out.println("P2 details: ");
        System.out.println("x: "+p2.x+" , "+"y: "+p2.y);
    }

    double length(){
        return Math.sqrt((p2.x-p1.x)*(p2.x-p1.x) + (p2.y-p1.y)*(p2.y-p1.y));
    }
}

 class Polygon extends Closed{
    double s,n;
    public Polygon(double s,double n){
        this.s = s;
        this.n = n;
    }

    void display(){
        System.out.println("***** Details of Polygon *****");
        System.out.println("Number of sides of polygon "+this.n);
        System.out.println("Length of sides of polygon "+this.s);
    }

    double length(){
        return this.s;
    }

    double area(){
        double a =(this.s*this.s*n)/(4*Math.tan(Math.PI/n)); 
        return a;
    }
}
 class Ellipse extends Closed{
    double a,b;
    public Ellipse(double major,double minor){
        a = major;
        b = minor;
    }
    void display(){
        System.out.println("***** Details of Ellipse *****");
        System.out.println("Major axis of ellipse: "+a);
        System.out.println("Minor axis of ellipse: "+b);
    }

    double length(){
        return 0.0;
    }

    double area(){
        double a = Math.PI*this.a*this.b;
        return a;
    }
}



public class Graphics {
    public static void main(String args[]){

        Ellipse e = new Ellipse(10f, 5f);
        e.display();
        System.out.println("Area of ellipse: "+e.area());
        System.out.println();

        Polygon p = new Polygon(10f, 4);
        p.display();
        System.out.println("Area of Polygon: "+p.area());
        System.out.println();

        Line l = new Line(4f, 4f, 2f, 2f);
        l.display();
        System.out.println("Length of Line: "+l.length());
        System.out.println();

   
    }
}
