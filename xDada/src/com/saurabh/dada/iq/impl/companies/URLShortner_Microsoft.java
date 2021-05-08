package com.saurabh.dada.iq.impl.companies;

import java.util.HashMap;
import java.util.Map;

public class URLShortner_Microsoft {

	public static void main(String[] args) {
		int id = 'a';
		//id= id*62 + "abcdefghi".charAt(6) - 'a';
		System.out.println("id:" +id);
		
		Map<Integer, String> database = new HashMap<Integer, String>();
		String URL = "https://www.google.com/";
		int hashkey = 535687810;
		database.put(hashkey, URL);//database primary key for google.com URL is 1000001010
		//when user request for short URL, generate using this key and pass it customer
	    String shorturl = hashkeyToShortURL(hashkey);
	    System.out.println("Generated short url is " + shorturl);
	    //and when customer hits the short URL, convert it back to primary key and get the actual URL from database using that key
	    //and use HTTP redirect 302 to transfer the HTTP request
	    int result = shortURLtoID(shorturl);
	    System.out.println("Id from url is: " + result);
	    String fullURL = database.get(result);
	    System.out.println("fullURL: " + fullURL);

	}
	
	// Function to generate a short url from intger ID
	public static String hashkeyToShortURL(int n)
	{
	    // Map to store 62 possible characters
	    char map[] = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();
	 
	    StringBuffer shorturl = new StringBuffer();
	    
	    int base = map.length;
	 
	    // Convert given integer id to a base 62 number
	    while (n>0){
	        // use above map to store actual character in short url
	    	int a = n%base;
	        shorturl.append(map[a]);
	        n = n/base;
	        System.out.println("a: " + a + "\tn: " + n) ;
	    }
	 
	    // Reverse shortURL to complete base conversion
	    shorturl.reverse();
	 
	    return shorturl.toString();
	}

	public static int shortURLtoID(String shortURL){
	    int id = 0; // initialize result
	 
	    // A simple base conversion logic
	    for (int i=0; i < shortURL.length(); i++){
	        if (shortURL.charAt(i) >= 'a' && shortURL.charAt(i) <= 'z')
	          id = id*62 + shortURL.charAt(i) - 'a';
	        if (shortURL.charAt(i) >= 'A' && shortURL.charAt(i) <= 'Z')
	          id = id*62 + shortURL.charAt(i) - 'A' + 26;
	        if (shortURL.charAt(i) >= '0' && shortURL.charAt(i) <= '9')
	          id = id*62 + shortURL.charAt(i) - '0' + 52;
	        System.out.println("id: " + id);
	    }
	    return id;
	}
	
}
