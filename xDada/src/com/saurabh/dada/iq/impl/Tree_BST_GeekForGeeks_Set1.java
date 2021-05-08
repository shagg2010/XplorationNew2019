package com.saurabh.dada.iq.impl;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.saurabh.dada.iq.impl.BinaryTreeG4G.Node;

public class Tree_BST_GeekForGeeks_Set1 {

	public static void main(String[] args) {
		BinaryTreeG4G btree = new BinaryTreeG4G();
		btree.add(new Node(50));
		btree.add(new Node(17));
		btree.add(new Node(12));
		btree.add(new Node(23));
		btree.add(new Node(9));
		btree.add(new Node(14));
		//btree.add(new Node(15));
		//btree.add(new Node(16));
		btree.add(new Node(19));
		btree.add(new Node(72));
		btree.add(new Node(54));
		btree.add(new Node(76));
		btree.add(new Node(67));

		btree.breadthFirstSearch();
		btree.rootToLeafAllPathsSum();
		btree.rootToLeafAllPaths();
		btree.levelOrderTraversal();
		btree.listOfNodesVisibleFromLeftView();
		btree.postOrderTraversal();
		
		BinaryTreeG4G btree1 = new BinaryTreeG4G();
		btree1.add(new Node(50));
		btree1.add(new Node(25));
		btree1.add(new Node(0));
		btree1.add(new Node(25));
		btree1.levelOrderTraversal();
		System.out.println("Sum Tree: "+btree1.isSumTree());

	}

}

class BinaryTreeG4G{
	
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
	
	public void listOfNodesVisibleFromLeftView(){
		System.out.println("---------- Tree Nodes Visible From Left View --------------");
		Queue<Node> queue = new LinkedList<>();
		queue.add(getRoot());
		System.out.println("left view visible node: " + queue.peek());
		viewOfTreeFromLeft(queue);
	}
	
	public void levelOrderTraversal(){
		System.out.println("---------- Level Order Traversal Line By Line --------------");
		Queue<Node> queue = new LinkedList<>();
		queue.add(getRoot());
		System.out.println(getRoot().data);
		int maxWidth = levelOrderTraversalPerLine(queue,1);
		System.out.println("\nMax Width: " + maxWidth);
	}
	
	private int levelOrderTraversalPerLine(Queue<Node> queue, int maxWidth){
		Queue<Node> childs = new LinkedList<>();
		int width=0;
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
		width = childs.size();
		System.out.println();
		if(width>0){
			maxWidth=width>maxWidth?width:maxWidth;
			maxWidth = levelOrderTraversalPerLine(childs,maxWidth);
		}
		return maxWidth;
	}
	
	private void viewOfTreeFromLeft(Queue<Node> queue){
		Queue<Node> childs = new LinkedList<>();
		while(!queue.isEmpty()){
			Node parent = queue.poll();
			if(parent!=null){
				if(parent.leftNode!=null){
					childs.add(parent.leftNode);
				}
				if(parent.rightNode!=null){
					childs.add(parent.rightNode);
				}
			}
		}
		if(childs.size()>0){
			System.out.println("left view visible node: " + childs.peek());
			viewOfTreeFromLeft(childs);
		}
		return;
	}
	
	public void breadthFirstSearch(){
		Queue<Node> queue = new LinkedList<>();
		queue.add(getRoot());
		while(!queue.isEmpty()){
			Node temp = queue.poll();
			System.out.println(temp.getData());
			if(temp.getLeftNode()!=null)
				queue.add(temp.getLeftNode());
			if(temp.getRightNode()!=null)
				queue.add(temp.getRightNode());
		}
	}
	
	public BinaryTreeG4G doubleTree(){
		
		return null;
	}
	
	public void postOrderTraversal() {
		System.out.println("\n--------- Post-Order Traversal -----------");
		postOrder(getRoot());
		System.out.println();
	}
	
	private void postOrder(Node node) {
		if (node != null) {
			postOrder(node.leftNode);			
			postOrder(node.rightNode);
			// Visit the node by Printing the node data
			System.out.printf("%d ", node.data);
		}
	}
	
	public void rootToLeafAllPaths(){
		System.out.println("---------- Root to leaf all Paths --------------");
		List<Node> path = new ArrayList<>();
		dfsPaths(getRoot(),path);
	}
	
	public void rootToLeafAllPathsSum(){
		System.out.println("---------- Root to leaf all Paths Sum --------------");
		dfsSum(getRoot(), 0);
	}
	
	public void dfsPaths(Node parent, List<Node> path){
		if(parent==null)
			return;
		path.add(parent);
		if(parent.leftNode==null&&parent.rightNode==null){
			System.out.println(path);
			return;
		}
		else{
			dfsPaths(parent.leftNode, new ArrayList<>(path));
			dfsPaths(parent.rightNode, new ArrayList<>(path));
		}
	}
	
	private void dfsSum(Node parent, int sum){
		if(parent!=null){
			sum=sum+parent.data;
			System.out.print(parent.data+"-> ");
			dfsSum(parent.leftNode,sum);
			dfsSum(parent.rightNode,sum);
			if(parent.leftNode==null&&parent.rightNode==null){
				System.out.println("\nSum: " + sum);
				sum=0;
			}
		}
	}
	
	public static class Node{
		private int data;
		private Node leftNode=null;
		private Node rightNode=null;
		
		public Node(int data){
			this.data=data;
		}
		
		public boolean add(Node node){
			if (node.data >= this.data) {
				if (this.rightNode == null) {
					this.rightNode = node;
					return true;
				} else
					return rightNode.add(node);
			}
			if (node.data < this.data) {
				if (this.leftNode == null) {
					this.leftNode = node;
					return true;
				} else
					return leftNode.add(node);
			}
			return false;
		}

		public int getData() {
			return data;
		}

		public void setData(int data) {
			this.data = data;
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
		
		public String toString(){
			return this.data+" ";
		}
		
	}
}