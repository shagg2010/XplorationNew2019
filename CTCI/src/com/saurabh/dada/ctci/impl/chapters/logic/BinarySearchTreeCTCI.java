package com.saurabh.dada.ctci.impl.chapters.logic;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

//not using generics for simplicity
public class BinarySearchTreeCTCI {
	
	private Node root=null;
	
	public boolean insert(int data){
		if(root==null){
			root = new Node(data);
			return true;
		}
		return root.add(data);
	}
	
	public Node getRoot(){
		return this.root;
	}
	
	public void setRoot(Node root){
		this.root=root;
	}
	
	public int getLevelOfNode(int data){
		if(data==root.data)
			return 1;
		else
			return findLevel(root,data, 1);
	}
	
	private int findLevel(Node root, int data,int level){
		if(root==null)
			return 0;
		else{
			if(root.getData()==data)
				return level;
			if(root.getData()>data)
				level = findLevel(root.getLeftKid(), data, level+1);
			if(root.getData()<data)
				level = findLevel(root.getRightKid(), data, level+1);
		}
		return level;
	}
	
	public boolean isBalanced(){
		System.out.println("maxDepth: " + maxDepth(root));
		System.out.println("minDepth: " + minDepth(root));
		if(root==null)
			return true;
		return maxDepth(root)-minDepth(root)<=1?true:false;
	}
	
	public int maxDepth(Node root){
		if(root==null)
			return 0;
		//add 1 for current node or every level of node 
		return 1 + Math.max(maxDepth(root.getLeftKid()), maxDepth(root.getRightKid()));
	}
	
	public int minDepth(Node root){
		if(root==null)
			return 0;
		//add 1 for root node
		return 1 + Math.min(maxDepth(root.getLeftKid()), maxDepth(root.getRightKid()));
	}
	
	public Node createMinimalBST(int[] items){
		return addChildToTreeNode(items,0,items.length-1);
	}
	
	private Node addChildToTreeNode(int[] items,int start,int end){
		if(end<start)
			return null;
		int mid = (start+end)/2;
		Node node = new Node(items[mid]);
		node.setLeftKid(addChildToTreeNode(items,start,mid-1));
		node.setRightKid(addChildToTreeNode(items,mid+1,end));
		return node;
	}
	
	public void levelOrderTraversal(){
		bfs(getRoot());
	}

	private void bfs(Node node){
		Queue<Node> queue = new java.util.LinkedList<>();
		queue.add(node);
		while(!queue.isEmpty()){
			Node n = queue.poll();
			System.out.println(n.getData());
			if(n.getLeftKid()!=null)
				queue.add(n.getLeftKid());
			if(n.getRightKid()!=null)
				queue.add(n.getRightKid());
		}
	}
	
	public void levelOrderTraversalModified(){
		Queue<Node> current = new java.util.LinkedList<>();
		current.add(root);
		bfsModified(current);
	}
	
	private void bfsModified(Queue<Node> current){
		
		if(current==null||current.size()==0)
			return;
		System.out.println();
		Queue<Node> next = new java.util.LinkedList<>();
		while(!current.isEmpty()){
			Node n = current.poll();
			if(n.leftKid!=null)
				next.add(n.leftKid);
			if(n.rightKid!=null)
				next.add(n.rightKid);
			System.out.print(n.getData()+" ");
		}
		current=next;
		bfsModified(current);
	}
	
	public Stack<Integer> searchNodePath(int data){
		Stack<Integer> stack = new Stack<Integer>();
		Node curr = getRoot();
		while(curr!=null){
			if(curr.getData()==data)
				break;
			if(data>curr.getData()){
				stack.push(curr.getData());
				curr=curr.getRightKid();
			}
			else{
				stack.push(curr.getData());
				curr=curr.getLeftKid();
			}
		}
		return stack;
	}
	
	public Node findNode(int data){
		Node node = null;
		Node curr = getRoot();
		while(curr!=null){
			if(curr.getData()==data){
				node=curr;
				break;
			}
			if(data>curr.getData()){
				curr=curr.getRightKid();
			}
			else{
				curr=curr.getLeftKid();
			}
		}
		return node;
	}
	
	public boolean containsSubTree(Node treeNode, Node subTreeRootNode){
		boolean ans = true;
		Queue<Node> queue = new LinkedList<>();
		Queue<Node> subQueue = new LinkedList<>();
		queue.add(treeNode);
		subQueue.add(subTreeRootNode);
		while(!subQueue.isEmpty()||!queue.isEmpty()){
			Node tNode = queue.poll();
			Node subTNode = subQueue.poll();
			//System.out.println("comparing: " + tNode + " & " + subTNode);
			if(tNode.getData()!=subTNode.getData())
				return false;
			if(subTNode.getLeftKid()!=null){
				if(tNode.getLeftKid()==null)
					return false;
				else{
					queue.add(tNode.getLeftKid());
					subQueue.add(subTNode.getLeftKid());
				}
			}
			if(subTNode.getRightKid()!=null){
				if(tNode.getRightKid()==null)
					return false;
				else{
					queue.add(tNode.getRightKid());
					subQueue.add(subTNode.getRightKid());
				}
			}
		}
		return ans;
	}
	
	public void allPathsFromRoot(){
		List<Node> path = new ArrayList<>();
		dfsPaths(root, path);
	}
	
	private void dfsPaths(Node parent, List<Node> path){
		if(parent==null)
			return;
		path.add(parent);
		if(parent.leftKid==null&&parent.rightKid==null){
			System.out.println(path);
			return;
		}
		else{
			dfsPaths(parent.leftKid, new ArrayList<>(path));
			dfsPaths(parent.rightKid, new ArrayList<>(path));
		}
	}
	
	public void findSumPaths(int sum){
		//do level order traversal and for each node find all paths, and also calculate sum in the meantime
		Queue<Node> queue = new java.util.LinkedList<>();
		queue.add(getRoot());
		while(!queue.isEmpty()){
			Node node = queue.poll();
			List<Node> path = new ArrayList<>();
			//System.out.println("\nStart node: " + node);
			dfsPathsSum(node,path,sum,0);
			if(node.getLeftKid()!=null)
				queue.add(node.getLeftKid());
			if(node.getRightKid()!=null)
				queue.add(node.getRightKid());
		}
		return;
	}
	
	private void dfsPathsSum(Node parent, List<Node> path, int sum,int currVal){
		if(parent==null)
			return;
		if(currVal<sum){
			path.add(parent);
			currVal=currVal+parent.data;
		}
		if(currVal==sum){
			System.out.println(path);
			return;
		}
		if(parent.leftKid==null&&parent.rightKid==null||currVal>sum){
			//System.out.println(path);
			return;
		}
		else{
			dfsPathsSum(parent.leftKid, new ArrayList<>(path),sum,currVal);
			dfsPathsSum(parent.rightKid, new ArrayList<>(path),sum,currVal);
		}
	}
	
	public static class Node{
		private int data;
		private Node leftKid=null;
		private Node rightKid=null;
		
		public Node(int data){
			this.data = data;
		}
		
		public boolean add(int val){
			if(val==this.data){
				return false;
			}
			if(val>data){
				if(rightKid==null){
					rightKid=new Node(val);
					return true;
				}
				else{
					return rightKid.add(val);
				}
			}
			else{
				if(leftKid==null){
					leftKid=new Node(val);
					return true;
				}
				else{
					return leftKid.add(val);
				}
			}
		}
		
		public boolean addNode(Node node){
			return add(node.getData());
		}
		
		public int getData() {
			return data;
		}
		public void setData(int data) {
			this.data = data;
		}
		public Node getLeftKid() {
			return leftKid;
		}
		public void setLeftKid(Node leftKid) {
			this.leftKid = leftKid;
		}
		public Node getRightKid() {
			return rightKid;
		}
		public void setRightKid(Node rightKid) {
			this.rightKid = rightKid;
		}
		
		public String toString(){
			return ""+this.getData();
		}
	}
	
	public void displayTree(){		
		displayNode(root,"root");
	}

	private void displayNode(Node node,String type){
		if(node!=null){			
			System.out.println(type+" "+ node.data);
			if(node.leftKid!=null){				
				displayNode(node.leftKid,"left");
			}
			if(node.rightKid!=null){
				displayNode(node.rightKid,"right");
			}
		}
	}
	
	public void displayTree(Node root){
		displayNode(root, "root");
	}
	
}
