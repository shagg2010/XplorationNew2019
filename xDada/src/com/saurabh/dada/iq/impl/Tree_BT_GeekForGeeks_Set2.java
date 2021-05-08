package com.saurabh.dada.iq.impl;

import java.util.LinkedList;
import java.util.Queue;

import com.saurabh.dada.iq.impl.BinaryTreeG4G_S2.Node;

public class Tree_BT_GeekForGeeks_Set2 {

	public static void main(String[] args) {
		BinaryTreeG4G_S2 tree = new BinaryTreeG4G_S2();
		tree.add(new Node(10));
		tree.add(new Node(20));
		tree.add(new Node(30));
		tree.add(new Node(40));
		tree.add(new Node(50));
		tree.add(new Node(60));
		tree.add(new Node(70));
		tree.add(new Node(80));
		tree.add(new Node(81));
		tree.add(new Node(82));
		tree.add(new Node(83));
		tree.add(new Node(84));
		tree.add(new Node(85));
		tree.add(new Node(86));
		tree.add(new Node(87));
		tree.levelOrderTraversal();
		System.out.println("Is Sum tree:  "+tree.isSumTree());
		
		BinaryTreeG4G_S2 tree1 = new BinaryTreeG4G_S2();
		tree1.add(new Node(26));
		tree1.add(new Node(10));
		tree1.add(new Node(3));
		tree1.add(new Node(4));
		tree1.add(new Node(6));
		tree1.add(new Node(3));
		tree1.levelOrderTraversal();
		System.out.println("Is Sum tree:  "+tree1.isSumTree());

	}

}
class BinaryTreeG4G_S2{
	
	private Node root;
	
	public Node getRoot(){
		return this.root;
	}
	
	public boolean add(Node node){
		if(root==null){
			root=node;
			return true;
		}
		else{
			return root.add(node);
		}
	}
	
	public void levelOrderTraversal(){
		System.out.println("---------- Level Order Traversal Line By Line --------------");
		Queue<Node> queue = new LinkedList<>();
		queue.add(getRoot());
		System.out.println(getRoot().data);
		levelOrderTraversalPerLine(queue,1);
	}
	
	private void levelOrderTraversalPerLine(Queue<Node> queue, int maxWidth){
		Queue<Node> childs = new LinkedList<>();
		while(!queue.isEmpty()){
			Node parent = queue.poll();
			if(parent!=null){
				if(parent.leftNode!=null){
					childs.add(parent.leftNode);
					System.out.print(parent.leftNode + " ");
				}
				if(parent.rightNode!=null){
					childs.add(parent.rightNode);
					System.out.print(parent.rightNode + " ");
				}
			}
		}
		System.out.println();
		if(childs.size()>0){
			levelOrderTraversalPerLine(childs,maxWidth);
		}
		return;
	}
	
	public boolean isSumTree(){
		System.out.println("---------- Verifying if Sum Tree --------------");
		int sum = dfsParentChildSum(getRoot(), 0);
		System.out.println("Total sum: " + (sum+getRoot().data));
		return sum==getRoot().data?true:false;
	}
	
	private int dfsParentChildSum(Node parent, int totalVal){

		if(parent!=null){
			int valLeft = dfsParentChildSum(parent.leftNode,parent.leftNode!=null?parent.leftNode.data:0);
			int valRight = dfsParentChildSum(parent.rightNode,parent.rightNode!=null?parent.rightNode.data:0);
			totalVal=totalVal+valLeft+valRight;
			//System.out.println("Parent: " + parent.data +", totalVal: " + totalVal + ", vleft: " + valLeft + " vRight: " + valRight);
		}
		//System.out.println("Returning totalVal: " + totalVal);
		return totalVal;
	}
	
	public static class Node{
		private int data;
		private Node leftNode=null;
		private Node rightNode=null;
		
		public Node(int data){
			this.data=data;
		}
		
		public boolean add(Node node){
			Queue<Node> queue = new LinkedList<>();
			queue.add(this);
			while(!queue.isEmpty()){
				Node tmp = queue.poll();
				if(tmp.leftNode==null){
					tmp.leftNode=node;
					return true;
				}
				else{
					queue.add(tmp.leftNode);
				}
				if(tmp.rightNode==null){
					tmp.rightNode=node;
					return true;
				}
				else{
					queue.add(tmp.rightNode);
				}
			}
			return true;
		}
		public String toString(){
			return this.data+" ";
		}
		
	}
	
}
