package com.saurabh.dada.iq.impl.iq.quikr;

import java.util.HashSet;
import java.util.StringTokenizer;

public class RepeatedWords {

	public static void main(String[] args) {
		String s = "String	Tokenizer multiple del;imiter Exa,mple in Java del";
		System.out.println(repeat(s));
	}
	
	public static String repeat(String s){
		String str = new String("");
		StringTokenizer st = new StringTokenizer(s, " \t,;-.");
		HashSet<String> tokens = new HashSet<>();
        while (st.hasMoreTokens()) {
        	String token = st.nextToken();
            if(!tokens.add(token)){
            	str=token;
            	break;
            }
        }
		return str;
	}

}
