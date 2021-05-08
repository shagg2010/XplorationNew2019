package com.saurabh.dada.iq.impl;

import java.util.Stack;

import com.saurabh.dada.iq.impl.BST1.Node;

public class Tree_BST_FirstCommonParent {

	private static int[] arr1 = {5,7,3,8,2,1,9,6};
	
	public static void main(String[] args) {
		
		BST1 bst1 = new BST1();
		for(int i=0;i<arr1.length;i++){
			bst1.add(new Node(arr1[i]));
		}
		
		Stack<Integer> stack1 = bst1.depthFirstSearch(new Node(9));
		System.out.println("Path size: " + stack1.size());
		/*while(!stack1.isEmpty()){
			System.out.print(stack1.pop()+ " -> ");
		}*/
		
		Stack<Integer> stack2 = bst1.depthFirstSearch(new Node(6));
		System.out.println("\nPath size: " + stack2.size());
		/*while(!stack2.isEmpty()){
			System.out.print(stack2.pop()+ " -> ");
		}*/
		int common=Integer.MIN_VALUE;
		
		for(int i=0,j=0;i<stack1.size()||j<stack2.size();i++,j++){
			System.out.println("Comparing: " + stack1.get(i) + " & " +stack2.get(j));
			if(stack1.get(i)==stack2.get(j))
				common=stack1.get(i);
			else
				break;
		}
		if(common!=Integer.MIN_VALUE){
			System.out.println("Common parent: " + common);
		}
		else{
			System.out.println("No common parent");
		}
	}

}

class BST1{
	
	public Node root=null;

	public boolean add(Node node){
		if(root==null){
			root=node;
			return true;
		}
		else{
			return root.add(node);
		}
	}
	
	public Stack<Integer> depthFirstSearch(Node node){
		Stack<Integer> stack = new Stack<>();
		return dfs(node, stack);
	}
	
	private Stack<Integer> dfs(Node node,Stack<Integer> stack){
		boolean found=false;
		Node curr = root;
		while(curr!=null){
			//System.out.println(curr.data);
			stack.push(curr.data);
			if(node.data==curr.data){
				found=true;
				return stack;
			}
			if(node.data>=curr.data)
				curr=curr.right;
			else
				curr=curr.left;
		}
		if(found)
			return stack;
		else
			return new Stack<Integer>();
	}
	
	public static class Node{
		public int data;
		public Node left=null;
		public Node right=null;
		
		public Node(int data){
			this.data=data;
		}
		
		public boolean add(Node node){
			if(this.data==node.data)
				return false;
			else if(node.data>this.data){
				if(this.right==null){
					this.right=node;					
					return true;
				}
				else{
					return this.right.add(node);
				}
			}
			else{
				if(this.left==null){
					this.left=node;
					return true;
				}
				else{
					return this.left.add(node);
				}
			}
		}
		
		public Node search(Node parent,Node node){
			Node n=null;
			while(parent!=null){
				if(node.data==parent.data){
					n=parent;
					break;
				}
				else if(node.data>parent.data){
					parent=parent.right;
					search(parent, node);
				}
				else if(node.data<parent.data){
					parent=parent.left;
					search(parent, node);
				}
			}
			return n;
		}
		public String toString(){
			return " :["+this.data + "]: ";
		}
	}
}