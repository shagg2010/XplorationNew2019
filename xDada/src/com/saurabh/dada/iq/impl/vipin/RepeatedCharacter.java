package com.saurabh.dada.iq.impl.vipin;

/**
 * To find out the first not repeated character in an array
 *
 */

public class RepeatedCharacter{
 
	private char[] array = { 'a', 'b', 'c', 'b', 'd', 'a', 'e', 'f', 'g', 'f' };
 
	public void check() {
		boolean[] bool = new boolean[150];
		for (int i = 0; i < array.length; i++) {
			int asciValue = array[i];
			if (bool[asciValue] == true) {
				bool[asciValue] = false;
			} else {
				bool[asciValue] = true;
			}
		}
		for (int i = 0; i < array.length; i++) {
			int asciValue = array[i];
			if (bool[asciValue] == true) {
				System.out.println("Element is " + array[i]);
				break;
			} else {
				// continue;
			}
		}
 
	}
 
	public static void main(String[] args) {
		new RepeatedCharacter().check();
	}
}