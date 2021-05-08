package com.saurabh.dada.iq.impl;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;

public class KeyPairGeneratorGenerator {

	public static void main(String[] args) {
		try {
			// creating the object of KeyPairGenerator 
			KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA"); 
            //KeyPairGenerator kpg = KeyPairGenerator.getInstance("DSA"); 
            // initializing with 1024 
            kpg.initialize(1024); //work without this as well
  
            // getting key pairs 
            // using generateKeyPair() method 
            KeyPair kp = kpg.generateKeyPair(); 
  
            // pritning the number of byte 
            System.out.println("Keypair : " + kp); 
            System.out.println("Keypair.privateKey : " + kp.getPrivate()); 
            System.out.println("Keypair.publicKey : " + kp.getPublic()); 
		}
		catch(NoSuchAlgorithmException e) {
			e.printStackTrace();
		}

	}

}
