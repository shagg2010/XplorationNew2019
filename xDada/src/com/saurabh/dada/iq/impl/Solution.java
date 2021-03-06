package com.saurabh.dada.iq.impl;

import java.io.*;
import java.util.*;
public class Solution {
       public static void main(String[] args) {
    	   
    	   maxNutrients(2,2);
    	   
    	   List<Integer> sales = new ArrayList<Integer>();
    	   sales.add(1);sales.add(2);sales.add(3);sales.add(3);
    	   
    	   System.out.println(balancedSum(sales));
    	   System.exit(0);
    	   String output = firstRepeatingLetter("abcba");
    	   System.out.println(output);
    	   
    	   System.exit(0);
    	   Scanner scan = new Scanner(System.in);
			int codeFromDB = scan.nextInt();
			try {
                System.out.println(EmpCode.getEnum(codeFromDB));
            } catch(IllegalArgumentException e) {
                System.out.println(e.toString());
            }
           scan.close();
       }
       
       public static int maxNutrients(int n, long k) {
    	    // Write your code here
    	   long sum = 0;
    	   	for(int i=1;i<=n;i++) {
    	   		sum+= i;
    	   	}
    	   	return 0;
    	    }
       
       //[1,2,3,4,6]
       //[0,1,2,3,4]
	public static int balancedSum(List<Integer> sales) {
		int result = -1;
		int sum = 0;
		for (Integer i : sales) {
			sum += i;
		}
		int leftSum = sales.get(0);
		int rightSum = sum - leftSum;
		for (int i = 1; i < sales.size(); i++) {
			// here i is the pivot
			rightSum = rightSum - sales.get(i);
			if (leftSum == rightSum) {
				result = i;
				break;
			}
			leftSum = leftSum + sales.get(i);
		}

		return result;

	}

       public static String firstRepeatingLetter(String s) {
   	    // Write your code here
    	   List<Character> rep = new ArrayList<Character>();
   	   Set<Character> set = new HashSet<Character>();
   	   String result = null;
   	   for(char c: s.toCharArray()) {
   		   if(!set.add(c)) {
   		   	//result = new String(c+"");
   		   	rep.add(c);
   		   }
   	   }
   	   System.out.println(rep);
   	 for(char c: s.toCharArray()) {
   		 if(rep.contains(c)) {
   			result = new String(c+"");
   			 break;
   		 }
   	 }
   	   
   	   	return result;
   	    }


// complete the enum definition 
public enum EmpCode {
    ASSOCIATE, SENIOR_ASSOCIATE, MANAGER, SENIOR_MANAGER, INVALID;

   // also implement this method properly
   public static EmpCode getEnum(int code) {
         switch(code){
            case 10001: return ASSOCIATE; 
            case 10002: return SENIOR_ASSOCIATE; 
            case 10003: return MANAGER;
            case 10004: return SENIOR_MANAGER;
            default: throw new IllegalArgumentException("Invalid Input");
         }

     
   }

    } // end of public enum EmpCode
}// end of public class Solution