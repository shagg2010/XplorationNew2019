package com.yadas.code.java.ds;

import java.util.HashMap;
import java.util.Map;

public class XTrie {
	
	private TrieNode root = null;

	public XTrie() {
		root = new TrieNode();
	}
	
	public static class TrieNode{
		private boolean isEndOfWord = false;
		private Map<Character, TrieNode> childs = null;
		
		public TrieNode() {
			this.childs = new HashMap<Character, XTrie.TrieNode>(255);
		}
	}
	
	public java.lang.String insert(java.lang.String key) {		
		if(key!=null&&key.length()>0) {
			TrieNode curr = root;
			for(int i=0;i<key.length();i++) {
				if(curr.childs.get(key.charAt(i))==null) {
					curr.childs.put(key.charAt(i), new TrieNode());
				}
				curr = curr.childs.get(key.charAt(i));
			}
			curr.isEndOfWord = true;
		}
		return key;
	}
	
	public boolean contains(java.lang.String key) {
		TrieNode curr = root;
		if(key!=null&&key.length()>0) {			
			for(int i=0;i<key.length();i++) {
				if(curr.childs.get(key.charAt(i))==null) {
					return false;
				}
				curr = curr.childs.get(key.charAt(i));
			}
		}
		return (curr!=null && curr.isEndOfWord==true);
	}
	
}
