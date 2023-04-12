/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaappstack;

public class Shape {
         public double volume(double r){
             return (4/3)*3.14*r*r*r;
         }
         
         public int volume(int a){
             return a*a*a;
         }
         
         public double volume(float l,float b,float h){
             return l*b*h;
         }
         
         public double volume(float r,float h){
             return 3.14*r*r*h;
         }
         
         
     }
    

