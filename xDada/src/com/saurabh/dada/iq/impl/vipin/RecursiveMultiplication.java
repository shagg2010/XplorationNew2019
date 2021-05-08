package com.saurabh.dada.iq.impl.vipin;

/**
 *Write a recursive method to get the multiplication of two numbers 
 *such that there are minimum number of addition operations.
 **/

class RecursiveMultiplication{
 
 public static int recMultiply(int num1, int num2){
    if(num2 == 1){
        return num1;
    }
    if(num2 == 0){
        return 0;
    }
        return num1 + recMultiply(num1, num2-1);
 }
 public static void main(String[] args){
     recMultiply(15,15);
 }    
    
}