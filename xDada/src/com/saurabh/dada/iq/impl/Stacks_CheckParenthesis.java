package com.saurabh.dada.iq.impl;

import java.util.Collection;
import java.util.HashMap;
import java.util.Set;
import java.util.Stack;

public class Stacks_CheckParenthesis {
	
	HashMap<Character, Character> mappedSpecialCharacters = new HashMap<>();
	Set<Character> opens = null; // Open Parenthesis
	Collection<Character> closes = null; // Close Parenthesis
	Stack<Character> stringParenthesis = null;// Parenthesis inside string

	public Stacks_CheckParenthesis() {
		mappedSpecialCharacters.put('{', '}');
		mappedSpecialCharacters.put('(', ')');
		mappedSpecialCharacters.put('[', ']');
		opens = mappedSpecialCharacters.keySet();
		closes = mappedSpecialCharacters.values();
	}
	
	public static void main(String[] args) {
		Stacks_CheckParenthesis scp = new Stacks_CheckParenthesis();
		
		System.out.println(scp.checkParenthesisInCharArray("[{()}()][]{}".toCharArray()));
		
	}
	
	public boolean checkParenthesis(final char ch) throws NullPointerException {
		boolean passed = true;
		if (ch != ' ') {
			//
			if (opens.contains(ch)) {
				stringParenthesis.push(ch);
			} else if (closes.contains(ch)) {
				if (!stringParenthesis.isEmpty() && ch == mappedSpecialCharacters.get(stringParenthesis.peek())) {
					stringParenthesis.pop();
				} else {
					stringParenthesis.push(ch);
					passed = false;
					return false;
				}
			}
		}
		return passed && stringParenthesis.isEmpty();
	}
	
	public boolean checkParenthesisInCharArray(char[] array) {
		stringParenthesis = new Stack<>();
		boolean result = false;
		for(char c: array) {
			result = checkParenthesis(c); // Read character by character and check it
		}
		return result;
	}

}
