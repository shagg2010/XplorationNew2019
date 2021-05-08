package com.saurabh.dada.iq.impl.iq.symantec;

import java.util.LinkedList;
import java.util.Queue;

public class BST_LevelOrderTraversal {

	
	public static void main(String[] args) {
		BST bst = new BST();
		bst.insert(new com.saurabh.dada.iq.impl.iq.symantec.BST.Node(100));
		bst.insert(new com.saurabh.dada.iq.impl.iq.symantec.BST.Node(75));
		bst.insert(new com.saurabh.dada.iq.impl.iq.symantec.BST.Node(150));
		bst.insert(new com.saurabh.dada.iq.impl.iq.symantec.BST.Node(95));
		bst.insert(new com.saurabh.dada.iq.impl.iq.symantec.BST.Node(20));
		bst.insert(new com.saurabh.dada.iq.impl.iq.symantec.BST.Node(99));
		bst.insert(new com.saurabh.dada.iq.impl.iq.symantec.BST.Node(110));
		bst.insert(new com.saurabh.dada.iq.impl.iq.symantec.BST.Node(170));
		bst.levelOrderTraversal();

	}

}
class BST{
	
	public Node root;
	public boolean insert(Node node){
		if(root==null){
			root=node;
			return true;
		}
		else
			return root.add(node);
	}
	
	public void levelOrderTraversal(){
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		while(!queue.isEmpty()){
			Node n = queue.poll();
			System.out.print(n.value + " ");
			if(n.leftNode!=null)
				queue.add(n.leftNode);
			if(n.rightNode!=null)
				queue.add(n.rightNode);
		}
	}
	
	public static class Node{
		public int value;
		public Node leftNode;
		public Node rightNode;
		
		public Node(int value){
			this.value = value;
		}
		
		public boolean add(Node node){
			if(this.value==node.value)
				return false;
			if(node.value<this.value){
				if(this.leftNode==null)
					leftNode=node;
				else
					leftNode.add(node);			
			}
			if(node.value>this.value){
				if(this.rightNode==null)
					rightNode=node;
				else
					rightNode.add(node);			
			}
			return true;
		}
		
	}
}