/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaappstack;
import java.util.*;
public class JavaAppStack {
    public static void main(String[] args) {
        //Stack Implementation:
        Stack s = new Stack(5);
        s.peek();
        s.push(12);
        System.out.println(s.peek());
        s.push(13);
        System.out.println(s.peek());
        s.push(14);
        System.out.println(s.peek());
        s.push(15);
        System.out.println(s.peek());
        s.push(16);
        System.out.println(s.peek());
        s.push(17);
        s.pop();
        System.out.println(s.peek());
        s.pop();
        System.out.println(s.peek());        
       
        //Function OverLoading:
        Shape cube = new Shape();
        Shape sphere = new Shape();
        Shape cylinder = new Shape();
        Shape cuboid = new Shape();
        
        System.out.println("Volume of Cube: "+cube.volume(2));
        System.out.println("Volume of Sphere:"+sphere.volume(100.0));
        System.out.println("Volume of Cuboid:"+cuboid.volume(2,2,2));
        System.out.println("Volume of Cylinder:"+cylinder.volume(2,100));
     
    }
    
}

