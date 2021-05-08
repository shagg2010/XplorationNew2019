package com.saurabh.java.hfsj.ch08.tld.functions;

public class DiceRoller {
	
	public static String rollItByName(String name){
		return "Your number is " +((int) ((Math.random()*6)+1)) + " Mr/Ms/Mrs. " + name;
	}

	public static int rollDice(){
		return (int) ((Math.random()*6)+1);
	}
}
