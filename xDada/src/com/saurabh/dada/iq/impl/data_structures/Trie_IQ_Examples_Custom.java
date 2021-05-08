package com.saurabh.dada.iq.impl.data_structures;

import java.util.HashMap;
import java.util.Map;

public class Trie_IQ_Examples_Custom {

	public static void main(String[] args) {
		String[] dictonary = {"milan","london","new york","san francisco", "milano"};
		Trie trie = new Trie();
		for(String key: dictonary)
			trie.insert(key);
		
		System.out.println("milan: " + trie.search("milan"));
		System.out.println("delhi: " + trie.search("delhi"));
		System.out.println("london: " + trie.search("london"));
		System.out.println("new york: " + trie.search("new york"));
		System.out.println("milano: " + trie.search("milano"));
	}

	//https://www.geeksforgeeks.org/boggle-set-2-using-trie/
		
}

class Trie{
	
	private static TrieNode root = null;
	
	public static class TrieNode{
		private Map<Character, TrieNode> childrens = null;
		boolean isEndOfWord = false;
		
		public TrieNode() {
			childrens = new HashMap<>(255);
		}
	}
	
	public Trie() {
		root = new TrieNode();
	}
	
	public String insert(String key) {
		if(key==null||key.length()==0)
			return null;
		TrieNode crawl = root;
		
		for(int i=0;i<key.length();i++) {
			if(crawl.childrens.get(key.charAt(i)) == null)
				crawl.childrens.put(key.charAt(i), new TrieNode());
			crawl = crawl.childrens.get(key.charAt(i));
		}
		crawl.isEndOfWord = true;
		return key;
	}
	
	public boolean search(String key) {
		if(key==null||key.length()==0)
			return false;
		TrieNode crawl = root;
		
		for(int i=0;i<key.length();i++) {
			if(crawl.childrens.get(key.charAt(i)) == null)
				return false;
			else
				crawl = crawl.childrens.get(key.charAt(i));
		}
		return (crawl!=null && crawl.isEndOfWord);
	}
}

class Trie_Array{
	private static int ALPHABETS = 26;
	private static TrieNode root = null;
	public static class TrieNode{
		TrieNode[] children = new TrieNode[ALPHABETS];
		boolean isEndOfWord = false;
		
		public TrieNode() {
			for(int i=0;i<ALPHABETS;i++) {
				children[i] = null; 
			}
		}
	}
	
	public Trie_Array() {
		root = new TrieNode();
	}
	
	public boolean insert(String key) {
		if(key==null||key.length()==0)
			return false;
		TrieNode crawl = root;
		
		for(int i=0;i<key.length();i++) {
			int index = key.charAt(i) - 'a';
			/*if(index<0)
				index = key.charAt(i) - 'a';*/
			if(crawl.children[index] == null)
				crawl.children[index] = new TrieNode();
			crawl = crawl.children[index];
		}
		crawl.isEndOfWord = true;
		return true;
	}
	
	public boolean search(String key) {
		if(key==null||key.length()==0)
			return false;
		TrieNode crawl = root;
		
		for(int i=0;i<key.length();i++) {
			int index = key.charAt(i) - 'a';
			if(crawl.children[index] == null)
				return false;
			else
				crawl = crawl.children[index];
		}
		return (crawl!=null && crawl.isEndOfWord);
	}
}