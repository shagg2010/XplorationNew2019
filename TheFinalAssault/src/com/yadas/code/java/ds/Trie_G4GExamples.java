package com.yadas.code.java.ds;

public class Trie_G4GExamples {

	public static void main(String[] args) {
		java.lang.String[] dictonary = {"mil","milan","london","new york","san francisco", "milano"};
		XTrie trie = new XTrie();
		for(java.lang.String key: dictonary)
			trie.insert(key);
		
		System.out.println("milan: " + trie.contains("milan"));
		System.out.println("delhi: " + trie.contains("delhi"));
		System.out.println("london: " + trie.contains("london"));
		System.out.println("new york: " + trie.contains("new york"));
		System.out.println("milano: " + trie.contains("milano"));

	}

}
