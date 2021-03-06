package com.yadas.code.java.ds;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

import com.yadas.code.java.ds.XBinaryTree.Node;

public class XBinarySearchTree<T extends Comparable<T>> {

	private Node<T> root = null;
	private boolean debug = false;
	
	public XBinarySearchTree() {
		super();
	}
	public XBinarySearchTree(boolean debug) {
		super();
		this.debug = debug;
	}
	
	public void remove(T data) {
		remove2(searchNode(root, data));
	}

	public void removeNodesOutsideTheRange(int min, int max) {
		
		boolean containsItemsOutsideTheRange = false;		
		do{
			List<Node<T>> list = inOrderTraversalAsList2(root, new ArrayList<XBinarySearchTree.Node<T>>());
			containsItemsOutsideTheRange = false;
			for(Node<T> node: list) {
				int nodeVal = (Integer) node.data;
				if(nodeVal<min||nodeVal>max) {
					containsItemsOutsideTheRange = true;
				}
			}
			removeNodesOutsideTheRange(root, min, max);
		}while(containsItemsOutsideTheRange);
		
	}
	
	private void removeNodesOutsideTheRange(Node<T> node, int min, int max) {
		if(node!=null) {
			removeNodesOutsideTheRange(node.left,min,max);
			int nodeVal = (Integer) node.data;
			System.out.println("---> Current Node: " + nodeVal);
			if(nodeVal<min||nodeVal>max) {
				remove2(node);
				System.out.println("After removal:");
				breadthFirstSearchLineByLineMod(root);
			}
			removeNodesOutsideTheRange(node.right,min,max);
		}
	}
	
	public void remove2(Node<T> node) {
		if(node!=null) {
			System.out.println("\nRemoving: " + node);
			//Node<T> successor = findInOrderSuccessorOptimized(node,null);
			//case 1: node to be removed has no child
			if(node.left==null&&node.right==null) {
				searchAndDeleteNode(this.root, node);
			}
			//case 2: node to be removed has one child
			else if(node.right!=null && node.left==null) {
				Node<T> parent = searchParent(root, node);
				if(parent.right!=null&&parent.right==node) {
					parent.setRight(node.right);
				}
				if(parent.left!=null&&parent.left==node) {
					parent.setLeft(node.right);
				}
			}
			else if(node.left!=null && node.right==null) {
				Node<T> parent = searchParent(root, node);
				if(parent.right!=null&&parent.right==node) {
					parent.setRight(node.left);
				}
				if(parent.left!=null&&parent.left==node) {
					parent.setLeft(node.left);
				}
			}
			else {
				//case 3: node to be removed has two childs
				//replace node with successor on parent node
				Node<T> successor = findInOrderSuccessorOptimized(node,null);
				if(successor!=null) {
					Node<T> root1 =root;
					T sData = successor.data;
					remove2(successor);
					node.setData(sData);
					root1 =root;
				}
			}
						
		}
		
	}
	
	
	public Node<T> findInOrderSuccessorOptimized(Node<T> node,Node<T> successor) {
		if(node!=null) {
			//if node has right sub-tree, find smallest in right sub-tree
			if(node.right!=null) {
				successor = findSmallestInRightSubTree(node);
			}
			//if node doesn't have right sub-tree, 
			//find lowest of all the highest values we found during search of this node
			if(node.right==null) {
				successor = findLowestInAllBiggerNodesDuringSearchOfThisNode(root, node.data);				
			}
			System.out.println("successor: " + successor);
		}
		return successor;
	}
	public Node<T> findSmallestInRightSubTree(Node<T> node){
		Node<T> curr = node.right;
		while(curr.left!=null)
			curr=curr.left;
		return curr;
	}
	
	public Node<T> findLowestInAllBiggerNodesDuringSearchOfThisNode(Node<T> node, T value) {
		Node<T> curr = node;
		Node<T> result = null;
		int max = Integer.MIN_VALUE;
		while(curr!=null) {
			int val = (Integer) value;
			int currVal = (Integer) curr.data;
			if(val==currVal)
				break;
			if(currVal>val) {
				if(result==null) {
					result = curr;
					max = (Integer) curr.data;
				}
				else {
					if(currVal<max) {
						result = curr;
						max = (Integer) curr.data;
					}
				}
				curr = curr.left;
			}
			else {
				curr = curr.right;
			}
		}
		return result;
	}
	
	public Node<T> searchParent(Node<T> node, Node<T> child){
		if(node!=null) {
			if(node.left!=null&&node.left.data.compareTo(child.data)==0)
				return node;
			if(node.right!=null&&node.right.data.compareTo(child.data)==0)
				return node;
			int nodeVal = (Integer) node.data;
			int childVal = (Integer) child.data;
			if(nodeVal>childVal)
				return searchParent(node.left, child);
			else
				return searchParent(node.right, child);
		}
		return null;
	}
	
	public void searchAndDeleteNode(Node<T> curr, Node<T> node){
		if(curr!=null) {
			if(node==this.root) {
				this.root = null;
				return;
			}
			if(curr.left!=null&&curr.left.data.compareTo(node.data)==0) {
				curr.setLeft(null);
			}
			if(curr.right!=null&&curr.right.data.compareTo(node.data)==0) {
				curr.setRight(null);
			}
			int nodeVal = (Integer) curr.data;
			int childVal = (Integer) node.data;
			if(nodeVal>childVal)
				searchAndDeleteNode(curr.left, node);
			else
				searchAndDeleteNode(curr.right, node);
		}
	}

	private void remove(Node<T> node, T n) {
		Node<T> res = searchNode(root, n);
		System.out.println("res: " + res);
		//in order successor in right sub-tree
		Node<T> successor = findNextInorderSuccessor(res.right, new ArrayList<XBinarySearchTree.Node<T>>());
		if(successor!=null) {
			System.out.println("successor: " + successor);
			//Node<T> parent = getParent(root,successor);
			Node<T> parent = getParentAndDeleteChild(root,successor);
			System.out.println("parent: " + parent);
			res.setData(successor.data);
			//parent.setLeft(null);
		}
		else {
			System.out.println("No successor!");
			Node<T> parent = findParent(res.data, root, null);
			System.out.println("parent: " + parent);
		}
	}
	
	
	private Node<T> findNextInorderSuccessor(Node<T> node, List<Node<T>> list) {
		if(node!=null) {
			findNextInorderSuccessor(node.left, list);			
			list.add(node);
			findNextInorderSuccessor(node.right, list);
			if(list.size()==1)
				return list.get(0);
		}
		return list.size()>0?list.get(0):null;
	}
	
	private Node<T> findNextInorderSuccessor_Old(Node<T> node) {
		//Node<T> curr = node.right;
		Node<T> curr = node;
		Node<T> successor = null;
		if(curr==null)
			return successor;
		while(curr.left!=null) {
			successor = curr.left;
			curr = curr.left;
		}
		return successor;
		//return inOrderTraversalToFindNextInOrderNode(node.right);
	}
	
	public Node<T> searchNode(Node<T> curr, T data) {
		if(curr!=null) {
			if(curr.data.compareTo(data)==0)
				return curr;
			int currVal = (Integer) curr.data;
			int d = (Integer) data;
			if(currVal<d)
				return searchNode(curr.right, data);
			if(currVal>d)
				return searchNode(curr.left, data);
		}
		return null;
	}

	public Node<T> findParent(T x, Node<T> node, Node<T> parent)
	{
	    if (node == null) {
	        return null;
	    } else if (!node.getData().equals(x)) {
	        parent = findParent(x, node.getLeft(), node);
	        if (parent == null) {
	            parent = findParent(x, node.getRight(), node);
	        }
	    }
	    return parent;
	}
	
	public Node<T> findParentAndDeleteThisChild(T x, Node<T> node, Node<T> parent)
	{
	    if (node == null) {
	        return null;
	    } else if (!node.getData().equals(x)) {
	        parent = findParent(x, node.getLeft(), node);
	        if (parent == null) {
	            parent = findParent(x, node.getRight(), node);
	        }
	    }
	    return parent;
	}
	
	public Node<T> getParentAndDeleteChild(Node<T> node, Node<T> child){
		if(node!=null) {
			int nodeVal = (Integer) node.data;
			int childVal = (Integer) child.data;
			if(node.left!=null) {
				if(node.left.data.compareTo(child.data)==0) {
					node.setLeft(null);
					return node;
				}
			}
			if(node.right!=null) {
				if(node.right.data.compareTo(child.data)==0) {
					node.setRight(null);
					return node;
				}
			}
			if(nodeVal>childVal) {
				return getParentAndDeleteChild(node.left, child);
			}
			else {
				return getParentAndDeleteChild(node.right, child);
			}
		}
		return null;
	}

	
	public Map<Node<T>,Node<T>> findNode(Node<T> node, int n, Map<Node<T>,Node<T>> map, Node<T> parent){
		if(node!=null) {
			int nodeVal = (Integer) node.data;
			if(n==nodeVal) {
				map.put(node, parent);
				return map;
			}
			if(n>nodeVal) {
				parent = node;
				findNode(node.right, n, map, parent);
			}
			else if(n<nodeVal) {
				parent = node;
				findNode(node.left, n, map, parent);
			}
		}
		return map;
	}

	
	public void findShortestDistanceBetweenNodes(int n1, int n2) {
		shortestDistanceBetweenNodes(root, n1, n2);
	}
	
	private void shortestDistanceBetweenNodes(Node<T> node,int n1, int n2) {
		Node<T> lca = findLCA(node, n1, n2);
		System.out.println("LCA: " + lca);
		if(lca!=null) {
			int d1 = findNodeDistanceFromCurrentNode(lca, n1, 0);
			int d2 = findNodeDistanceFromCurrentNode(lca, n2, 0);
			System.out.println("d1: " + d1 + ", d2: " + d2);
			System.out.println("Shortest Distance: " + (d1+d2));
		}
	}
	
	private Node<T> findLCA(Node<T> node,int n1, int n2){
		if(node!=null) {
			int nodeVal = (Integer) node.data;
			if(n1<=nodeVal&&nodeVal<=n2) {
				return node;
			}
			else if(n1>nodeVal && n2>nodeVal)
				return findLCA(node.right, n1, n2);
			else if(n1<nodeVal && n2<nodeVal) {
				return findLCA(node.left, n1, n2);
			}
		}		
		return null;
	}
	
	private int findNodeDistanceFromCurrentNode(Node<T> node, int n, int distance){
		if(node!=null) {
			int nodeVal = (Integer) node.data;
			if(nodeVal==n)
				return distance;
			else if(nodeVal>n) {
				distance = distance + 1;
				return findNodeDistanceFromCurrentNode(node.left, n, distance);
			}
			else if(nodeVal<n) {
				distance = distance + 1;
				return findNodeDistanceFromCurrentNode(node.right, n, distance);
			}
		}
		return -1;
	}
	
	public void findLargestNumberLessThanOrEqualToN(int n) {
		int nodeVal = (Integer)root.data;
		largestNumberLessThanOrEqualToN(root, n, nodeVal);
	}
	
	private void largestNumberLessThanOrEqualToN(Node<T> node,int n, int max) {
		//search for n
		if(node==null || (node!=null && (Integer)node.data > n)) {
			System.out.println("Max Value: " + max);
			return;
		}
		int nodeVal = (Integer)node.data;
			
		if(n==nodeVal) {
			System.out.println("Max Value: " + n);
		}
		else if(nodeVal<n) {
			//max = nodeVal>max?nodeVal:max;
			max=nodeVal;
			largestNumberLessThanOrEqualToN(node.right, n, max);
		}
		else {
			//max = nodeVal>max?nodeVal:max;
			max=nodeVal;
			largestNumberLessThanOrEqualToN(node.left, n, max);
		}
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
	
	public void findLowestAncestor(T n1, T n2) {
		if(n1.compareTo(n2)<=0)
			findLowestAncestor(root, n1, n2);
		else
			findLowestAncestor(root, n2, n1);
	}
	private void findLowestAncestor(Node<T> node, T n1, T n2) {
		if(node!=null) {
			if(node.getData().compareTo(n1)>=0 && node.getData().compareTo(n2)<=0) {
				System.out.println("LCA: " + node + "\tof: " + n1 + " & " + n2);
				return;
			}
			if(node.getData().compareTo(n1)>0)
				findLowestAncestor(node.left, n1, n2);
			if(node.getData().compareTo(n2)<0)
				findLowestAncestor(node.right, n1, n2);
		}
	}
	
	public void updateToMinHeapTree() {
		updateToMinHeapTree(root);
	}
	private void updateToMinHeapTree(Node<T> node) {
		List<T> list = inOrderTraversalAsList();
		updateNodesLevelByLevel(root, list);
	}
	
	private void updateNodesLevelByLevel(Node<T> node, List<T> list) {
		Queue<Node<T>> queue = new LinkedList<Node<T>>();
		queue.add(node);
		int i = 0;
		while (!queue.isEmpty()) {
			Node<T> curr = queue.poll();
			curr.setData(list.get(i));
			i++;
			if (curr.left != null)
				queue.add(curr.left);
			if (curr.right != null)
				queue.add(curr.right);
		}
	}
	
	public void updateToSumOfSmallerKeys() {
		List<Integer> sum = new ArrayList<>(1);
		sum.add(new Integer(0));
		updateToSumOfSmallerKeys(root, sum);
	}
	
	private void updateToSumOfSmallerKeys(Node<T> node, List<Integer> sum) {
		if(node==null)
			return;		
		updateToSumOfSmallerKeys(node.left, sum);
		sum.set(0, sum.get(0) + Integer.valueOf(node.data.toString()));
		Object x = sum.get(0) - Integer.valueOf(node.getData().toString());		
		node.setData((T)x);
		updateToSumOfSmallerKeys(node.right, sum);
	}
	
	public void updateToGreaterSumTree() {
		List<Integer> sum = new ArrayList<>(1);
		sum.add(new Integer(0));
		updateToGreaterSumTree(root, sum);
	}
	
	private void updateToGreaterSumTree(Node<T> node, List<Integer> sum) {
		if(node==null) {
			return;
		}
		updateToGreaterSumTree(node.right,sum);
		sum.set(0, sum.get(0) + Integer.valueOf(node.data.toString()));
		//System.out.print(node.data + ",\t" + sum + ",\t");
		Object x = sum.get(0) - Integer.valueOf(node.getData().toString());		
		node.setData((T)x);
		//System.out.print(node.data + "\n");
		updateToGreaterSumTree(node.left,sum);
	}
	
	public void reverseLevelTraversalLineByLine() {
		System.out.println("Reverse Level Traversal: ");
		if(root!=null)
			reverseLevelTraversalLineByLine(root);
		System.out.println();
	}
	private void reverseLevelTraversalLineByLine(Node<T> node) {
		Queue<Node<T>> queue = new LinkedList<Node<T>>();
		queue.add(node);
		queue.add(null);
		//Queue<Node<T>> q1 = new LinkedList<>();
		Stack<Node<T>> stack = new Stack<>();
		while(!queue.isEmpty()) {
			Node<T> curr = queue.poll();
			if(curr==null) {
				if(!queue.isEmpty()) {
					queue.add(null);					
					stack.add(null);
					System.out.println();
				}
			}
			else {
				stack.add(curr);
				if(curr.left!=null)
					queue.add(curr.left);
				if(curr.right!=null)
					queue.add(curr.right);
			}
		}
		Stack<Node<T>> s1 = new Stack<>();
		while(!stack.isEmpty()) {
			Node<T> item = stack.pop();
			if(item!=null) {
				//System.out.print(item.data + "~\t");
				s1.add(item);
			}
			else {
				while(!s1.isEmpty()) {
					System.out.print(s1.pop().data + "~\t");
				}
				s1.clear();
				System.out.println();
			}
		}
		while(!s1.isEmpty()) {
			System.out.print(s1.pop().data + "~\t");
		}
		s1.clear();
	}
	
	public void spiralFormTraversalLineByLine() {
		System.out.println("Spiral Traversal: ");
		if(root!=null)
			spiralFormTraversalLineByLine(root);
		System.out.println();
	}
	private void spiralFormTraversalLineByLine(Node<T> node) {
		Queue<Node<T>> queue = new LinkedList<Node<T>>();
		queue.add(node);
		queue.add(null);
		boolean oddLevel = true;
		Stack<Node<T>> stack = new Stack<XBinarySearchTree.Node<T>>();
		while (!queue.isEmpty()) {
			Node<T> curr = queue.poll();
			if(curr==null) {
				if(!queue.isEmpty()) {
					queue.add(null);
					if(oddLevel) {
						while(!stack.isEmpty()) {
							System.out.print(stack.pop().data + "~\t");
						}
						System.out.println();
						oddLevel=false;
					}
					else {
						oddLevel=true;
					}
					System.out.println();
				}				
			}
			else {
				if(oddLevel)
					stack.add(curr);
				else
					System.out.print(curr.data + "\t");
				if(curr.left!=null)
					queue.add(curr.left);
				if(curr.right!=null)
					queue.add(curr.right);
			}
		}
		while(!stack.isEmpty()) {
			System.out.print(stack.pop().data + "~\t");
		}
		System.out.println();
	}
	
	
	public void zigZagTraversalLineByLine() {
		System.out.println("ZigZag Traversal: ");
		if(root!=null)
			zigZagTraversalLineByLine(root);
		System.out.println();
	}
	
	private void zigZagTraversalLineByLine(Node<T> node) {
		Queue<Node<T>> queue = new LinkedList<Node<T>>();
		queue.add(node);
		queue.add(null);
		boolean useStack = false;
		Stack<Node<T>> stack = new Stack<XBinarySearchTree.Node<T>>();
		while (!queue.isEmpty()) {
			Node<T> curr = queue.poll();
			if(curr==null) {
				if(!queue.isEmpty()) {
					queue.add(null);
					if(useStack==false) 
						useStack = true;
					else {
						useStack = false;
						while(!stack.isEmpty()) {
							System.out.print(stack.pop().data + "\t");
						}
					}
					System.out.println();
				}
			}
			else {
				if(useStack==true)
					stack.add(curr);
				else
					System.out.print(curr.data + "\t");
				if(curr.left!=null)
					queue.add(curr.left);
				if(curr.right!=null)
					queue.add(curr.right);
			}
		}
		while(!stack.isEmpty()) {
			System.out.print(stack.pop().data + "~\t");
		}
		System.out.println();
	}
	
	public void convertToSumOfInOrderSuccessorAndPredecessor() {
		convertToSumOfInOrderSuccessorAndPredecessor(root);
	}
	private void convertToSumOfInOrderSuccessorAndPredecessor(Node<T> node) {
		System.out.println(inOrderTraversalNonRecursive(root));
	}
	private List<T> inOrderTraversalNonRecursive(Node<T> node) {
		List<T> list = new ArrayList<>();
		Stack<Node<T>> stack = new Stack<>();
		Node<T> curr = root;
		while(!stack.isEmpty() || curr!=null) {
			while(curr!=null) {
				stack.push(curr);
				curr=curr.left;
			}
			curr = stack.pop();
			list.add(curr.data);
			curr=curr.right;
		}
		return list;
	}
	
	public void convertToSumTree() {
		System.out.print("SumOrder Traversal:\t");
		convertToSumTree(root, 0);
		System.out.println();
	}
	private int convertToSumTree(Node<T> node, int sum) {
		if(node!=null) {
			sum = convertToSumTree(node.left, sum);
			sum = sum + convertToSumTree(node.right, sum);
			sum = sum + Integer.valueOf(node.data.toString());
			System.out.print(node.data + " [" + sum  + "]\t");
			return sum;
		}
		else
			return 0;
	}
	/*
	 * private int sumOfLeftSubTreeAndRightSubTree(Node<T> node, int sum) {
	 * if(node!=null) { sumOfTreeNode(node.left, sum); sumOfTreeNode(node.right,
	 * sum); sum = sum + Integer.valueOf(node.data.toString()); } return sum; }
	 */
	
	public void insert(T data) {
		if(root==null) {
			root = new Node<>(data);
		}
		else {
			insert(root, data);
		}
	}
	public void insert(Node<T> node,T data) {
		if(data.compareTo(node.data)<0) {
			//new node to be added is lesser than current node
			if(node.left==null)
				node.left = new Node<>(data);
			else
				insert(node.left, data);
		}
		else {
			if(node.right==null)
				node.right = new Node<>(data);
			else
				insert(node.right, data);
		}
	}
	
	public void levelOrderTraversalOrBFSLineByLine() {
		System.out.println("Level Order Traversal: ");
		if(root!=null)
			breadthFirstSearchLineByLine(root);
		System.out.println();
	}
	
	public void levelOrderTraversalOrBFSLineByLineMod() {
		System.out.println("Level Order Traversal: ");
		if(root!=null)
			breadthFirstSearchLineByLineMod(root);
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
	
	public void breadthFirstSearchLineByLineMod(Node<T> node) {
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
					if (curr.left != null) {
						queue.add(curr.left);
						System.out.print("[L: " + curr.left.data + "\t");
					}
					if (curr.right != null) {
						queue.add(curr.right);
						if(curr.left!=null)
							System.out.print(",R: " + curr.right.data + "\t");
						else
							System.out.print("[R: " + curr.right.data + "\t");
					}
					if(curr.right!=null || curr.left!=null) {
						System.out.print("]\n");
					}
			}
		}
	}
	
	public List<T> inOrderTraversalAsList() {
		List<T> list = new ArrayList<>();
		System.out.print("Inoder Traversal: \t");
		inOrderTraversalAsList(root, list);
		System.out.println();
		return list;
	}
	private List<T> inOrderTraversalAsList(Node<T> node, List<T> list) {
		if(node!=null) {
			inOrderTraversalAsList(node.left, list);
			System.out.print(node);
			list.add(node.data);
			inOrderTraversalAsList(node.right, list);
		}
		return list;
	}
	
	private List<Node<T>> inOrderTraversalAsList2(Node<T> node, List<Node<T>> list) {
		if(node!=null) {
			inOrderTraversalAsList2(node.left, list);
			//System.out.print(node);
			list.add(node);
			inOrderTraversalAsList2(node.right, list);
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
		private T data;
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
				return "data: " + data + "@" + this.hashCode() + "";
			else
				return "" + data + "\t";
		}
	}
}
