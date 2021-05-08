package com.saurabh.dada.iq.impl.vipin;

/**
 * Given two input string check if anyone is 
 * substring of other <Don't use any internal string library>
 **/

class SubstringPresent{
    private String largerString = "aaabcdedfd";
    private String smallerString = "cdf";
    
    public boolean isSubString(String largerString, String smallerString){
        int temp=0;
        for(int k = 0; k < largerString.length(); k++){
            if(largerString.charAt(k)==smallerString.charAt(temp)){
                temp = k;
                break;
            }
        }
 
        int temp_1 = 0;
        for(int m = temp; m<largerString.length(); m++){
        	if(largerString.charAt(m)!=smallerString.charAt(temp_1))
        		return false;
        	temp_1++;
        if(temp_1 == smallerString.length()){
                return true;
            }	
        }
        
        
        return false;
    }
    
    public static void main(String[] args){
        SubstringPresent test = new SubstringPresent();
        System.out.println(test.isSubString(test.largerString, test.smallerString));
    }
    
}