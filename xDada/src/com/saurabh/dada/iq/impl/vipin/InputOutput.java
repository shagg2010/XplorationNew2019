package com.saurabh.dada.iq.impl.vipin;

/**
 *Given input Array [2,3,5] Output should be [15,10,6] without using division operation
 */

public class InputOutput {
 
Integer[] inputArray = {2,3,5};
Integer[] outputArray = new Integer[inputArray.length];
 
public void getOutput(){
    for(int i = 0;i<inputArray.length;i++){
        outputArray[i] = multiplyOthers(i);
    }
}
 
public int multiplyOthers(int k){
    int result = 1;
    for(int m =0;m<inputArray.length;m++){
        if(m ==k){
//do nothing;
        }else{
            result*=inputArray[m];
        }
    }
    return result;
    }
 
 
public static void main(String[] args) {
    new InputOutput().getOutput();
}
 
}