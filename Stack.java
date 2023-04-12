/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaappstack;
public class Stack {
       int size;
       int top;
       int arr[];
       
       public Stack(int n){
           this.size=n;
           this.top = -1;
           arr = new int[this.size];
       }
        
       
       public boolean isEmpty(){
                if(this.top==-1){
                return true;
           }
                return false;
       }
       public boolean isFull(){
           if(this.top==this.size-1){
               return true;
           }
           return false;
       }
       
       public void push(int e){
           if(isFull()){
               System.out.println("Stack is Full!!!");
                return;
           }
           this.top++;
           this.arr[this.top] = e;
       }
       
       public int pop(){
           if(isEmpty()){
               System.out.println("Stack is Empty!!!");
               return -1;
           }
           int n = this.arr[this.top];
//           this.arr[top] = 0;
           this.top--;
           return n;
       }
       public int peek(){
           if(isEmpty()){
              System.out.println("Stack is Empty!!!");
               return -1; 
           }
           return this.arr[this.top];
       }           
}
