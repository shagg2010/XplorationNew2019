package com.saurabh.dada.iq.impl;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import com.saurabh.dada.iq.impl.BST.Node;

public class Tree_BinarySearchTree_SubTreeEqual {
	
	private static int[] arr1 = {5,7,3,8,2,1,9,6};
	private static int[] arr2 = {7,6,8,9};

	public static void main(String[] args) {

		BST bst1 = new BST();
		for(int i=0;i<arr1.length;i++){
			bst1.add(new Node(arr1[i]));
		}
		
		BST bst2 = new BST();
		for(int i=0;i<arr2.length;i++){
			bst2.add(new Node(arr2[i]));
		}
		
		bst1.displayTree();
		bst2.displayTree();
		
		System.out.println(bst1.searchNode(new Node(9)));
		System.out.println(bst1.searchNode(new Node(19)));
		
		System.out.println("Tree Comparison: "+bst1.compareIfSubTree(bst2));
		
		Integer prev=null;
		Stack<Integer> stack = bst1.inOrderTraversal();
		while(!stack.isEmpty()){
			int item = stack.pop();
			if(prev!=null){
				if(prev<=item)
					System.out.println("Not a valid Binary Tree");
				else
					System.out.print(item+" ");
			}
			prev = new Integer(item);
		}
		
	}
	
}
class BST{
	
	public Node root=null;
	public int totalSize=0;
	
	public boolean add(Node node){
		if(root==null){
			root=node;
			totalSize++;
			return true;
		}
		else{
			boolean val = root.add(node);
			if(val)
				totalSize++;
			return val;
		}
	}
	
	public void displayTree(){		
		displayNode(root,"root");
	}
	
	public Stack<Integer> inOrderTraversal(){
		Stack<Integer> stack = new Stack<>();
		return inOrder(root, stack);
	}
	
	private Stack<Integer> inOrder(Node node,Stack<Integer> stack){
		if(node!=null){
			inOrder(node.left,stack);
			stack.push(node.data);
			System.out.println("adding: " + node.data);
			inOrder(node.right, stack);
		}
		return stack;
	}
	
	public Node searchNode(Node node){
		return root.search(root,node);
	}
	
	public boolean compareIfSubTree(BST tree){
		Node start = root.search(root, tree.root);
		if(start==null){
			System.out.println("Not sub tree");
			return false;
		}else{
			System.out.println("Sub tree possible!");
			System.out.println("Main tree start node: " + start);
			System.out.println("Child tree start node: " + tree.root);
			return compareChildNodes(start, tree.root);
		}
		//return "NA";
	}
	
	public boolean compareChildNodes(Node tree1Node, Node tree2Node){
		
		Queue<Node> queueSub = new LinkedList<Node>();
		Queue<Node> queueMain = new LinkedList<Node>();
		queueSub.add(tree2Node);
		queueMain.add(tree1Node);
		while(!queueSub.isEmpty()){
			Node nodeSub = queueSub.poll();
			Node nodeMain = queueMain.poll();
			System.out.println("Comapring: " + nodeSub + " = " + nodeMain);
			if(nodeMain==null||nodeSub.data!=nodeMain.data){
				return false;
			}
			if(nodeSub.left!=null){
				queueSub.add(nodeSub.left);
				queueMain.add(nodeMain.left);
				System.out.println("Going left: M-" + nodeMain.left + " S-" + nodeSub.left);
			}
			if(nodeSub.right!=null){
				queueSub.add(nodeSub.right);
				queueMain.add(nodeMain.right);
				System.out.println("Going left: M-" + nodeMain.right + " S-" + nodeSub.right);
			}
		}
		
		return true;
	}
	
	private void displayNode(Node node,String type){
		if(node!=null){			
			System.out.println(type+" "+ node.data);
			if(node.left!=null){
				displayNode(node.left,"left");
			}
			if(node.right!=null){
				displayNode(node.right,"right");
			}
		}
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
