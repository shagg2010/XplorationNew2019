package com.saurabh.dada.iq.impl;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import com.saurabh.dada.iq.impl.BinarySearchTree.Node;

public class Tree_BST_AllTraversals {

	public static void main(String[] args) {
		
		//check tree structure is correct or not @ https://www.cs.usfca.edu/~galles/visualization/BST.html
		/**				100
		 * 	   75						150
		 * 20		95			    110		 170
		 * 				99
		 * 
		 */
		BinarySearchTree bst = new BinarySearchTree();
		bst.insert(new Node(100));
		bst.insert(new Node(75));
		bst.insert(new Node(150));
		bst.insert(new Node(95));
		bst.insert(new Node(20));
		bst.insert(new Node(99));
		bst.insert(new Node(110));
		bst.insert(new Node(170));
		
		bst.displayTree();
		bst.preOrderTraversal();
		bst.inOrderTraversal();
		bst.postOrderTraversal();
		bst.levelOrderTraversal();
		bst.depthOrderTraversal();
		Node node = new Node(95);
		System.out.println("Level of Node " + node.getValue() +": " + bst.levelOfTheNode(node));
		
		System.out.println(bst.maxDepthOfTree());
	}

}

class BinarySearchTree{
	private Node root;
	
	public Node getRoot(){
		return this.root;
	}
	public BinarySearchTree(){
		root=null;
	}
	public BinarySearchTree(Integer value){
		root=new Node(value);
	}
	public BinarySearchTree(Node node){
		root=node;
	}
	public boolean insert(Node node){
		if(root==null){
			root=node;
			return true;
		}
		else{
			return root.add(node);
		}
	}
	
	public void displayTree(){		
		displayNode(root,"root");
	}
	
	
	
	private void displayNode(Node node,String type){
		if(node!=null){			
			System.out.println(type+" "+ node.value);
			if(node.leftNode!=null){				
				displayNode(node.leftNode,"left");
			}
			if(node.rightNode!=null){
				displayNode(node.rightNode,"right");
			}
		}
	}
	
	public void preOrderTraversal() {
		System.out.println("\n--------- Pre-Order Traversal -----------");
		preOrder(getRoot());
	}
	
	public void postOrderTraversal() {
		System.out.println("\n--------- Post-Order Traversal -----------");
		postOrder(getRoot());
	}
	public void inOrderTraversal(){
		System.out.println("\n--------- In-Order Traversal -----------");
		inOrder(getRoot());
	}
	
	//BFS
	public void levelOrderTraversal(){
		System.out.println("\n--------- Level-Order/BFS Traversal -----------");
		levelOrder(getRoot());
	}
	//DFS
	public void depthOrderTraversal(){
		System.out.println("\n--------- Depth-Order/DFS Traversal -----------");
		Node root = getRoot();
		dfs(root);
	}
	
	public int levelOfTheNode(Node node){
		System.out.println("\n--------- Level of Node " + node.value + " -----------");
		Node root = getRoot();
		int level=1;
		return getLevel(root,node,level); 
	}
	
	private int getLevel(Node parent, Node node, int level){
		if(node==null||parent==null){
			return 0;
		}
		if(parent.value==node.value)
			return level;
		if(node.value>parent.value){
			level = getLevel(parent.rightNode, node, level+1);
		}
		if(node.value<parent.value){
			level = getLevel(parent.leftNode, node, level+1);
		}
		return level;
	}
	
	public int maxDepthOfTree(){
		System.out.println("\n--------- Maximum Level/Height of Tree -----------");
		Node root = getRoot();
		int level=0;
		return getMaxLevel(root,level); 
	}
	private int getMaxLevel(Node parent, int level){
		if(parent!=null){
			int maxDepthLeft = getMaxLevel(parent.leftNode, level+1);
			int maxDepthRight = getMaxLevel(parent.rightNode, level+1);
			level=maxDepthLeft>maxDepthRight?maxDepthLeft:maxDepthRight;
		}
		
		return level;
	}
	
	private void dfs(Node root){		
	     if(root == null)
	        return;
	     System.out.println(root.value);
	     dfs(root.leftNode);
	     dfs(root.rightNode);
	}
	
	private void inOrder(Node node) {
		if (node != null) {
			inOrder(node.leftNode);
			// Visit the node by Printing the node data
			System.out.printf("%d ", node.value);
			inOrder(node.rightNode);
		}
	}
	private void preOrder(Node node) {
		if (node != null) {
			// Visit the node by Printing the node data
			System.out.printf("%d ", node.value);
			preOrder(node.leftNode);			
			preOrder(node.rightNode);
		}
	}
	private void postOrder(Node node) {
		if (node != null) {
			postOrder(node.leftNode);			
			postOrder(node.rightNode);
			// Visit the node by Printing the node data
			System.out.printf("%d ", node.value);
		}
	}
	
	private  void levelOrder(Node node) {
		Queue<Node> queue=new LinkedList<Node>();
		queue.add(node);
		while(!queue.isEmpty())
		{
			Node tempNode=queue.poll();
			System.out.println(tempNode.value);
			if(tempNode.leftNode!=null)
				queue.add(tempNode.leftNode);
			if(tempNode.rightNode!=null)
				queue.add(tempNode.rightNode);
		}
		
	}
	
	public static class Node{
		private Integer value;
		private Node leftNode;
		private Node rightNode;
		
		public Node(Integer value){
			this.value = value;
		}
		
		public boolean add(Node node){
			if(this.value==node.value){
				System.out.println("[Insert] Duplicate value: " + node.getValue());
				return false;
			}
			else if(node.value<this.value){
				if(this.leftNode==null){
					leftNode=node;
					return true;
				}
				else{
					return leftNode.add(node);
				}
			}
			else if(node.value>this.value){
				if(this.rightNode==null){
					rightNode=node;
					return true;
				}
				else{
					return rightNode.add(node);
				}
			}
			return false;
		}
		public Integer getValue() {
			return value;
		}
		public void setValue(Integer value) {
			this.value = value;
		}
		public Node getLeftNode() {
			return leftNode;
		}
		public void setLeftNode(Node leftNode) {
			this.leftNode = leftNode;
		}
		public Node getRightNode() {
			return rightNode;
		}
		public void setRightNode(Node rightNode) {
			this.rightNode = rightNode;
		}
		
		
	}
}
