package com.yadas.code.java.ds;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class XBinaryTree<T extends Comparable<T>> {
	
	private Node<T> root = null;
	private boolean debug = false;
	
	public XBinaryTree() {
		super();
	}
	public XBinaryTree(boolean debug) {
		super();
		this.debug = debug;
	}
	
	public boolean isPerfect() {
		int d = findADepthForPerfectTree(root);
		return isPerfectTreeRecursive(root, d, 0);
	}  
	
	public int findADepthForPerfectTree(Node<T> node) {
		int d = 0;
		while (node != null) {
			d++;
			node = node.left;
		}
		return d;
	} 
	
	public boolean isPerfectTreeRecursive(Node<T> root, int d, int level) {
		// An empty tree is perfect
		if (root == null)
			return true;

		// If leaf node, then its depth must be same as
		// depth of all other leaves.
		if (root.left == null && root.right == null)
			return (d == level + 1);

		// If internal node and one child is empty
		if (root.left == null || root.right == null)
			return false;

		// Left and right subtrees must be perfect.
		return isPerfectTreeRecursive(root.left, d, level + 1) && isPerfectTreeRecursive(root.right, d, level + 1);
	} 
	
	
	
	public boolean hasDeadEnd() {
		return hasDeadEnd(root, 1, 
                Integer.MAX_VALUE);
	}
	
	private boolean hasDeadEnd(Node<T> node, int min, int max) {
		if(node==null)
			return false;
		int nodeData = (Integer) node.data;
		System.out.println("node: " + nodeData + ", min: " + min + ", max: " + max);
		if (min==max) 
            return true;
		return (hasDeadEnd(node.left, min, nodeData-1) || hasDeadEnd(node.right, nodeData + 1, max));
	}
	
	public void kThSmallestElement(int k) {
		List<T> list = new ArrayList<T>(k+1);
		kThSmallestElement(root,list,k);
	}
	
	private void kThSmallestElement(Node<T> node, List<T> list, int k) {
		if(node==null)
			return;
		kThSmallestElement(node.left,list, k);
		list.add(node.data);
		if(list.size()==k) {
			System.out.println(list.get(k-1));
			return;
		}
		kThSmallestElement(node.right,list, k);
	}
	
	public boolean isBinarySearchTree() {
		return isBinarySearchTree(root, Integer.MIN_VALUE, 
                Integer.MAX_VALUE);
	}
	
	private boolean isBinarySearchTree(Node<T> node, int min, int max) {
		if(node==null)
			return true;
		int nodeData = (Integer) node.data;
		//System.out.println("node: " + nodeData + ", min: " + min + ", max: " + max);
		if (nodeData < min || nodeData > max) 
            return false;
		return (isBinarySearchTree(node.left, min, nodeData-1) && isBinarySearchTree(node.right, nodeData + 1, max));
	}
	
	public void createBalancedTreeFromSortedList(List<T> list) {		
		root = createBalancedTreeFromSortedList(list, 0,list.size()-1);
	}

	private Node<T> createBalancedTreeFromSortedList(List<T> list, int start, int end) {
		if(start>end) 
			return null;
		int mid = (end + start) / 2;
		System.out.println("start: " + start + "\tmid: " + mid + "\tend: " + end);
		Node<T> left = createBalancedTreeFromSortedList(list, start, mid - 1);
		Node<T> node = new Node<>(list.get(mid));
		System.out.println("Set Node: " + node);
		Node<T> right = createBalancedTreeFromSortedList(list, mid + 1, end);
		node.setLeft(left);
		node.setRight(right);
		System.out.println("Returning node: " + node);
		return node;

	}
	
	public void updateTreeFromSortedInoderTraversal(List<T> list) {
		Collections.sort(list);
		//System.out.println("list: " + list);
		updateTreeFromInoderTraversal(root, list);
		System.out.println();
	}
	private void updateTreeFromInoderTraversal(Node<T> node, List<T> list) {
		if(node!=null) {
			updateTreeFromInoderTraversal(node.left,list);
			node.setData(list.remove(0));
			updateTreeFromInoderTraversal(node.right,list);
		}
	}
	
	public void boundaryTraversal() {
		boundaryTraversal(root);
		System.out.println();
	}
	
	private void boundaryTraversal(Node<T> node) {
		LinkedList<Node<T>> ll = new LinkedList<Node<T>>();
		LinkedList<Node<T>> llR = new LinkedList<Node<T>>();
		Queue<Node<T>> queue = new LinkedList<Node<T>>();
		queue.add(node);
		queue.add(null);
		ll.add(null);
		int lastNullAt = -1;
		int i = 0;
		while (!queue.isEmpty()) {
			Node<T> curr = queue.poll();
			if (curr == null) {
				if(ll.get(ll.size()-1)!=null) {
					llR.add(ll.get(ll.size()-1));
				}
				if (!queue.isEmpty()) {
					//System.out.println();
					queue.add(null);
					ll.add(null);					
					i++;
					lastNullAt = i;
				}
			} 
			else {
				if(ll.get(ll.size()-1)==null && curr!=null) {
					System.out.print(curr.data + "~   ");
				}
				ll.add(curr);
				i++;
				if (curr.left != null)
					queue.add(curr.left);
				if (curr.right != null)
					queue.add(curr.right);
			}
			//System.out.println("\nbQueue1.1: " + ll);
		}
		//System.out.println("\nllR: " + llR);
		//System.out.println("\nbQueue1: " + ll);
		//System.out.println("lastNullAt: " + lastNullAt);
		for(int j=lastNullAt+2;j<ll.size();j++) {
			System.out.print(ll.get(j).data + "~   ");
		}
		for(int j=llR.size()-2;j>=1;j--) {
			System.out.print(llR.get(j).data + "~   ");
		}
		
	}
	
	public void diagonalOrderTraversal() {
		Map<Integer, List<T>> diagonalLevelMap = new HashMap<Integer, List<T>>();
		diagonalOrderTraversal(root, diagonalLevelMap, 0);
		for(Integer key: diagonalLevelMap.keySet()) {
			System.out.println("@ slope " + key + ":\t" + diagonalLevelMap.get(key).toString().trim());
		}
		
	}
	private void diagonalOrderTraversal(Node<T> node, Map<Integer, List<T>> diagonalLevelMap ,int slope) {
		if(node!=null) {
			List<T> list = diagonalLevelMap.get(slope);
			if(list==null) {
				list = new ArrayList<T>();
				list.add(node.data);
				diagonalLevelMap.put(new Integer(slope), list);
			}
			else {
				list.add(node.data);
			}
			
			diagonalOrderTraversal(node.right, diagonalLevelMap, slope);
			diagonalOrderTraversal(node.left, diagonalLevelMap, slope-1);
		}
	}
	
	public void reverseAlternativeLevels() {
		reverseAlternativeLevels(root,0);
	}
	private void reverseAlternativeLevels(Node<T> node, int level) {
		Queue<Node<T>> queue = new LinkedList<Node<T>>();
		queue.add(node);
		queue.add(null);
		Queue<Node<T>> evenLevelQueue = new LinkedList<Node<T>>();
		Queue<Node<T>> oddLevelQueue = new LinkedList<Node<T>>();
		while (!queue.isEmpty()) {
			Node<T> curr = queue.poll();
			if (curr == null) {
				if (!queue.isEmpty()) {
					System.out.println();
					queue.add(null);
					if(level%2!=0) //odd level
						oddLevelQueue.add(null);
					else
						evenLevelQueue.add(null);
					level++;
				}
			} 
			else {
				if(level%2!=0) //odd level
					oddLevelQueue.add(curr);
				else
					evenLevelQueue.add(curr);
				if (curr.left != null)
					queue.add(curr.left);
				if (curr.right != null)
					queue.add(curr.right);
			}
			
		}
		oddLevelQueue.add(null);
		evenLevelQueue.add(null);
		//List<Node<T>> eList = new ArrayList<XBinaryTree.Node<T>>();
		while(!evenLevelQueue.isEmpty()) {
			List<Node<T>> listEven = getLevelNodesAsList(evenLevelQueue, false);
			List<Node<T>> listOdd = getLevelNodesAsList(oddLevelQueue, true);
			int j=0;
			for(int i=0;i<listEven.size();i++) {
				Node<T> currE = listEven.get(i);
				Node<T> currO1 = listOdd.get(j);
				currE.setLeft(currO1);
				j=j+1;
				Node<T> currO2 = listOdd.get(j);
				currE.setRight(currO2);
				j=j+1;
			}
			List<Node<T>> listEven2 = getLevelNodesAsListWithoutRemoving(evenLevelQueue);
			j=0;
			for(int i=0;i<listOdd.size()&&listEven2.size()>0;i++) {
				Node<T> currO = listOdd.get(i);
				Node<T> currE1 = listEven2.get(j);
				currO.setLeft(currE1);
				j=j+1;
				Node<T> currE2 = listEven2.get(j);
				currO.setRight(currE2);
				j=j+1;
			}
		}
		
//		System.out.println("Even Level: ");
//		while(!evenLevelQueue.isEmpty()) {
//			Node<T> n1 = evenLevelQueue.poll();
//			if(n1!=null)
//				System.out.print(n1.data + "  ");
//			else
//				System.out.println();
//		}
//		System.out.println("\nOdd Level: ");
//		Stack<Node<T>> stack = new Stack<>();
//		while(!oddLevelQueue.isEmpty()) {
//			Node<T> n1 = oddLevelQueue.poll();
//			if(n1!=null) {
//				stack.add(n1);
//				System.out.print(n1.data + "  ");
//			}
//			else
//				System.out.println();
//		}
//		System.out.println();
		
		
	}
	
	private List<Node<T>> getLevelNodesAsListWithoutRemoving(Queue<Node<T>> levelQueue){
		List<Node<T>> list = new ArrayList<XBinaryTree.Node<T>>();
		for(Node<T> item: levelQueue) {
			if(item==null)
				break;
			else
				list.add(item);
		}
		return list;
	}
	private List<Node<T>> getLevelNodesAsList(Queue<Node<T>> levelQueue, boolean reverse){
		List<Node<T>> list = new ArrayList<XBinaryTree.Node<T>>();
		while(!levelQueue.isEmpty()) {
			Node<T> n1 = levelQueue.poll();
			if(n1!=null) {
				list.add(n1);
			}
			else
				break;
		}
		if(reverse) {
			Collections.reverse(list);
		}
		return list;
	}
	
	public boolean isSymmetric() {
		return isSymmetric(root,root);
	}
	private boolean isSymmetric(Node<T> left,Node<T> right) {
		if(left==null&&right==null)
			return true;
		else if(left!=null && right!=null) {
			System.out.println("comparing1 " + left.left + " & " + right.right);
			System.out.println("comparing2 " + left.right + " & " + right.left);
			if(isSymmetric(left.left,right.right) && isDataSame(left.left, right.right) && isSymmetric(left.right, right.left) && isDataSame(left.right, right.left)) {
				return true;
			}
			else
				return false;
		}
		else
			return false;
	}
	private boolean isDataSame(Node<T> n1, Node<T> n2) {
		if(n1==null&&n2==null)
			return true;
		if(n1!=null && n2!=null && n1.data.compareTo(n2.data)==0)
			return true;
		else
			return false;
	}
	
	public void mirror() {
		mirror(root);
	}
	private void mirror(Node<T> node) {
		if(node==null)
			return;
		else {
			swapLeftAndRightNodes(node);
			mirror(node.left);
			mirror(node.right);
		}
	}
	public void swapLeftAndRightNodes(Node<T> node) {
		if(node!=null) {
			Node<T> temp = node.left;
			node.left = node.right;
			node.right = temp;
		}
	}
	
	public boolean isMirror() {
		return isMirror(root);
	}
	private boolean isMirror(Node<T> node) {
		if(node==null)
			return true;
		if(isStructureSame(node.left, node.right))
			return true;
		else
			return false;
	}
	private boolean isStructureSame(Node<T> n1, Node<T> n2) {
		if(n1==null && n2==null)
			return true;
		if(n1!=null && n2!=null && isStructureSame(n1.left, n2.right) && isStructureSame(n1.right, n2.left)) {
			return true;
		}
		else
			return false;
	}
	public boolean isContinuousTree() {
		return isContinuous(root);
	}
	private boolean isContinuous(Node<T> node) {
		if(node.left!=null && node.right==null) {
			return true;
		}
		if(node.left==null) {
			return (Math.abs(Integer.parseInt(node.data.toString())-Integer.parseInt(node.right.data.toString())) == 1)&& isContinuous(node.right);
		}
		if(node.right==null) {
			return (Math.abs(Integer.parseInt(node.data.toString())-Integer.parseInt(node.left.data.toString())) == 1)&& isContinuous(node.left);
		}
		return (Math.abs(Integer.parseInt(node.data.toString())-Integer.parseInt(node.left.data.toString())) == 1) && (Math.abs(Integer.parseInt(node.data.toString())-Integer.parseInt(node.right.data.toString())) == 1);
	}
	
	public void insert(T data) {
		if(root==null) {
			root = new Node<>(data, debug);
			if(debug)
				System.out.println("Added: " + root);
		}
		else {
			//do level order traversal and find the correct place to insert
			Queue<Node<T>> q = new LinkedList<>();
			q.add(root);
			while(!q.isEmpty()) {
				Node<T> t = q.poll();
				if(t.left==null) {
					t.left = new Node<T>(data, debug);
					if(debug)	
						System.out.println("Added: " + t.left);
					break;
				}
				else
					q.add(t.left);
				if(t.right==null) {
					t.right = new Node<T>(data, debug);
					if(debug)
						System.out.println("Added: " + t.right);
					break;
				}
				else
					q.add(t.right);
			}
		}
	}
	
	public void insert2(T data) {
		root = insert2(root, data);
	}
	private Node<T> insert2(Node<T> node, T data) {
		if(node==null)
			node = new Node<>(data);
		else {
			if(node.left==null)
				node.left=insert2(node.left, data);
			else
				node.right=insert2(node.right, data);
		}
		return node;
	}
	public void levelOrderTraversalOrBFSLineByLine() {
		System.out.println("Level Order Traversal: ");
		if(root!=null)
			breadthFirstSearchLineByLine(root);
		System.out.println();
	}
	
	private void breadthFirstSearchLineByLine(Node<T> node) {
		Queue<Node<T>> queue = new LinkedList<Node<T>>();
		queue.add(node);
		queue.add(null);
		while (!queue.isEmpty()) {
			Node<T> curr = queue.poll();
			if (curr == null) {
				if (!queue.isEmpty()) {
					System.out.println();
					queue.add(null);
				}
			} 
			else {
					System.out.print(curr.data + "\t");
					if (curr.left != null)
						queue.add(curr.left);
					if (curr.right != null)
						queue.add(curr.right);
			}
		}
	}
	public List<T> inOrderTraversalAsList() {
		List<T> list = new ArrayList<>();
		System.out.print("Inoder Traversal: \t");
		inOrderTraversal(root, list);
		System.out.println();
		return list;
	}
	private List<T> inOrderTraversal(Node<T> node, List<T> list) {
		if(node!=null) {
			inOrderTraversal(node.left, list);
			System.out.print(node);
			list.add(node.data);
			inOrderTraversal(node.right, list);
		}
		return list;
	}
	
	public void inOrderTraversal() {
		System.out.print("Inoder Traversal: \t");
		inOrderTraversal(root);
		System.out.println();
	}
	public void preOrderTraversal() {
		System.out.print("Preorder Traversal: \t");
		preOrderTraversal(root);
		System.out.println();
	}
	public void postOrderTraversal() {
		System.out.print("Postorder Traversal: \t");
		postOrderTraversal(root);
		System.out.println();
	}
	private void inOrderTraversal(Node<T> node) {
		if(node!=null) {
			inOrderTraversal(node.left);
			System.out.print(node);
			inOrderTraversal(node.right);
		}
	}
	private void preOrderTraversal(Node<T> node) {
		if(node!=null) {
			System.out.print(node);
			preOrderTraversal(node.left);
			preOrderTraversal(node.right);
		}
	}
	private void postOrderTraversal(Node<T> node) {
		if(node!=null) {
			postOrderTraversal(node.left);
			postOrderTraversal(node.right);
			System.out.print(node);
		}
	}
	
	public static class Node<T extends Comparable<T>>{
		private Node<T> left = null;
		private Node<T> right = null;
		private T data = null;
		private boolean debug = false;
		
		public Node() {
			super();
		}
		public Node(T data) {
			super();
			this.data = data;
		}
		public Node(T data, boolean debug) {
			super();
			this.data = data;
			this.debug = debug;
		}
		
		public Node<T> getLeft() {
			return left;
		}
		public void setLeft(Node<T> left) {
			this.left = left;
		}
		public Node<T> getRight() {
			return right;
		}
		public void setRight(Node<T> right) {
			this.right = right;
		}
		public T getData() {
			return data;
		}
		public void setData(T data) {
			this.data = data;
		}
		@Override
		public java.lang.String toString() {
			if(debug)
				return "" + data + " @ " + this.hashCode() + "";
			else
				return "" + data + "\t";
		}
	}

}
