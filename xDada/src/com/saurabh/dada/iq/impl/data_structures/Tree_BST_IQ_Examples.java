package com.saurabh.dada.iq.impl.data_structures;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;

import com.saurabh.dada.iq.impl.WorkerFileMain;

public class Tree_BST_IQ_Examples {

	public static void main(String[] args) {
		/**				50
		 * 	   30						70
		 * 20		40			    60		 80
		 * 				45
		 * 
		 */
		BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();
		bst.insert(50);
		bst.insert(30);
		bst.insert(20);
		bst.insert(40);
		bst.insert(70);
		bst.insert(60);
		bst.insert(80);
		bst.insert(45);
		System.out.println("In Order: ");
		bst.inOrderTraversal();
		System.out.println("Level Order: ");
		bst.levelOrderTraversalOrBFS();
		
		System.out.println("Level Order Line By Line: ");
		bst.levelOrderTraversalOrBFSLineByLine();
		System.exit(0);
		System.out.println("Max depth of Tree: " + bst.maxDepth());
		System.out.println("Min depth of Tree: " + bst.minDepth());
		
		System.out.println("Is Full Binary Tree: " + bst.isFullBinaryTree());
		
		//https://www.geeksforgeeks.org/bottom-view-binary-tree/
		System.out.println("Bottom nodes/view of tree: ");bst.getBottomViewOfTheTree();
		
		//https://www.geeksforgeeks.org/check-if-a-given-array-can-represent-preorder-traversal-of-binary-search-tree/
		int[] pre1 = new int[]{40, 30, 35, 80, 100};
        int n1 = pre1.length;
		System.out.println("Can represent BST [40, 30, 35, 80, 100]: " + bst.canRepresentBST(pre1, n1));
		pre1 = new int[]{40, 30, 35, 20, 80, 100};
        n1 = pre1.length;
        System.out.println("Can represent BST [40, 30, 35, 20, 80, 100]: " + bst.canRepresentBST(pre1, n1));
        
        //https://www.geeksforgeeks.org/lowest-common-ancestor-in-a-binary-search-tree/
        System.out.println("Lowest Common Ancestor (LCA) of 45 & 80: " + bst.lowestCommonAncestor(45, 80));
        System.out.println("Lowest Common Ancestor (LCA) of 40 & 45: " + bst.lowestCommonAncestor(40, 45));
        System.out.println("Lowest Common Ancestor (LCA) of 20 & 40: " + bst.lowestCommonAncestor(20, 40));
        System.out.println("Lowest Common Ancestor (LCA) of 20 & 80: " + bst.lowestCommonAncestor(20, 80));
        
        //Collections.indexOfSubList(Arrays.asList(array), Arrays.asList(subArray));
        
        System.out.println("Level of 45: " + bst.findLevelOfNode(45));
        System.out.println("Level of 60: " + bst.findLevelOfNode(60));
        System.out.println("Level of 70: " + bst.findLevelOfNode(70));
        
        System.out.println("Reverse Alternate Levels: "); bst.reverseAlternateLevels();
        
        //https://www.geeksforgeeks.org/check-binary-tree-subtree-another-binary-tree-set-2/
        BinarySearchTree<Integer> bst1 = new BinarySearchTree<Integer>();
        bst1.insert(30);
        bst1.insert(20);
		bst1.insert(40);
		bst1.insert(45);		
		System.out.println("Is SubTree: "  +bst.isSubtree(bst1));
		
		
		BinarySearchTree<Integer> bst2 = new BinarySearchTree<Integer>();
		bst2.insert(5);
		bst2.insert(3);
		bst2.insert(4);
		bst2.insert(2);
		bst2.insert(1);
		bst2.insert(6);
		bst2.insert(8);
		bst2.insert(7);
		bst2.insert(15);
		bst2.insert(10);
		bst2.insert(11);
		bst2.insert(12);
		bst2.levelOrderTraversalOrBFSLineByLine();
		
		//https://www.geeksforgeeks.org/print-nodes-top-view-binary-tree/
		System.out.println("Top view of the Tree is: "); 
		bst2.getTopViewOfTheBSTTree();
		
		//https://www.geeksforgeeks.org/print-binary-tree-vertical-order-set-2/
		System.out.println("Vertical Order Traversal: ");
		bst2.verticalOrderTraversal();
		
		//https://www.geeksforgeeks.org/diagonal-traversal-of-binary-tree/
		System.out.println("Diagonal Order Traversal: ");
		bst2.diagonalOrderTraversal();
		
		//https://www.geeksforgeeks.org/remove-nodes-root-leaf-paths-length-k/
		System.out.println("\n==== remove-nodes-root-leaf-paths-length-k === ");
		bst2.levelOrderTraversalOrBFSLineByLine();
		bst2.removeShortPathNodes(5);
		System.out.println("After removing all paths < 5: ");
		bst2.levelOrderTraversalOrBFSLineByLine();
		
		//https://www.geeksforgeeks.org/sorted-array-to-balanced-bst/
		System.out.println("\n==== sorted-array-to-balanced-bst === ");
		List<Integer> list = WorkerFileMain.generateRandomIntegerData(10);
		System.out.println("Unsorted Array: " + list);
		BinarySearchTree<Integer> bst3 = new BinarySearchTree<Integer>();
		System.out.println("Balanced Tree from sorted Array: ");
		bst3.createBalancedBSTFromSortedArray(list);
		System.out.println("Level Order Traversal: ");
		bst3.levelOrderTraversalOrBFSLineByLine();
		System.out.println("In Order: ");
		bst3.inOrderTraversal();
		
		//https://www.geeksforgeeks.org/convert-normal-bst-balanced-bst/
		System.out.println("\n==== convert-normal-bst-balanced-bst === ");
		BinarySearchTree<Integer> bst4 = new BinarySearchTree<Integer>();
		List<Integer> list1 = WorkerFileMain.generateRandomIntegerData(10);
		Collections.sort(list1);
		for(Integer i: list1) {
			bst4.insert(i);
		}
		System.out.println("Level Order Traversal: ");
		bst4.levelOrderTraversalOrBFSLineByLine();
		List<Integer> inOrderList = bst4.inOrderTraversalAsList();
		System.out.println("InOrder Traversal: " + inOrderList);
		BinarySearchTree<Integer> bst5 = new BinarySearchTree<Integer>();
		System.out.println("Balanced Tree from in order list: ");
		bst5.createBalancedBSTFromSortedArray(inOrderList);
		System.out.println("In Order: ");
		bst5.inOrderTraversal();
		
		//https://www.geeksforgeeks.org/transform-bst-sum-tree/
		System.out.println("\n==== transform-bst-sum-tree === ");
		BinarySearchTree<Integer> bst6 = new BinarySearchTree<Integer>();
		bst6.insert(11);
		bst6.insert(2);
		bst6.insert(1);
		bst6.insert(7);
		bst6.insert(29);
		bst6.insert(15);
		bst6.insert(40);
		bst6.insert(35);
		System.out.println("Level Order Traversal: ");
		bst6.levelOrderTraversalOrBFSLineByLine();
		
		List<Integer> inOrderList1 = bst6.inOrderTraversalAsList();
		Collections.reverse(inOrderList1);
		int sum = 0;
		for(int i: inOrderList1) {
			System.out.println("Replace: " + i + " -> " + sum);
			sum = sum + i;
		}
		//https://www.geeksforgeeks.org/print-ancestors-of-a-given-node-in-binary-tree/
		System.out.print("All Ancestors of 45 are: ");
		bst.getAllAncestorsOfANode(45);
		System.out.println();
		
		//https://www.geeksforgeeks.org/maximum-width-of-a-binary-tree/
		bst.maximumWidthOfTree();
		
		//https://www.geeksforgeeks.org/find-a-pair-with-given-sum-in-bst/
		bst6.findPairWithGivenSum(50);
		
	}

	
}

class BinarySearchTree<T extends Comparable<T>>{
	
	private Node<T> root = null;
	
	public boolean insert(T data) {
		if(root==null) {
			root=new Node<T>(data);
			return true;
		}
		else {
			return insertData(root, new Node<T>(data));
		}
	}
	private boolean insertData(Node<T> root,Node<T> node) {
		if(root.value.compareTo(node.value)>0) {
			if(root.left==null)
				root.left = node;
			else
				return insertData(root.left, node);
		}
		else if(root.value.compareTo(node.value)<0) {
			if(root.right==null)
				root.right = node;
			else
				return insertData(root.right, node);
		}
		return false;
	}
	
	public int maxDepth() {
		return maxHeightOfTree(root, 0);
	}
	private int maxHeightOfTree(Node<T> node, int maxDepth) {
		if(node!=null) {
			int leftDepth = maxHeightOfTree(node.left, maxDepth + 1);
			int rightDepth = maxHeightOfTree(node.right, maxDepth + 1);
			maxDepth = leftDepth>rightDepth?leftDepth:rightDepth;
		}
		return maxDepth;
	}
	
	public int minDepth() {
		return minHeightOfTree(root, 0);
	}
	private int minHeightOfTree(Node<T> node, int minDepth) {
		if(node!=null) {
			int leftDepth = minHeightOfTree(node.left, minDepth + 1);
			int rightDepth = minHeightOfTree(node.right, minDepth + 1);
			minDepth = Math.min(leftDepth, rightDepth);
		}
		return minDepth;
	}
	public int findLevelOfNode(T data) {
		return findLevelOfNode(root, data, 0);
	}
	private int findLevelOfNode(Node<T> node, T data, int level) {
		if(node!=null) {
			if(node.value==data)
				return level;
			else {
				int n = (int) node.value;
				int d = (int) data;
				if(n>d)
					return findLevelOfNode(node.left, data, level + 1);
				else
					return findLevelOfNode(node.right, data, level + 1);
			}
		}
		return -1;
	}
	
	public void createBalancedBSTFromSortedArray(List<T> list) {
		if(root!=null)
			System.out.println("Tree not empty!");
		else {
			Collections.sort(list);
			System.out.println("Sorted Array: " + list);
			root = createBalancedBST(list, 0, list.size()-1);
		}
	}
	private Node<T> createBalancedBST(List<T> list, int start, int end) {
		if(start>end)
			return null;
		int mid = (start + end)/2;
		Node<T> node = new Node<>(list.get(mid));
		node.left = createBalancedBST(list, start, mid-1);
		node.right = createBalancedBST(list, mid+1, end);
		return node;
		
	}
	
	public void getAllAncestorsOfANode(T data) {
		getAllAncestorsOfANode(root, data);
		System.out.println();
	}
	
	private boolean getAllAncestorsOfANode(Node<T> node,T data) {
		if(node==null)
			return false;
		if(node.value.compareTo(data)==0) {
			return true;
		}
		if(getAllAncestorsOfANode(node.left, data) || getAllAncestorsOfANode(node.right, data)) {
			System.out.print(node.value + "  ");
			return true;
		}
		return false;
	}
	
	public void getTopViewOfTheBSTTree() {
		HashMap<Integer, List<Node<T>>> map = new HashMap<>();
		verticalOrderTraversal(root, 0, map);
		Set<Integer> distances = new TreeSet<>(map.keySet());
		for(int i: distances) {
			System.out.println(map.get(new Integer(i)).get(0));
		}
	}
	
	public void verticalOrderTraversal() {
		HashMap<Integer, List<Node<T>>> map = new HashMap<>();
		verticalOrderTraversal(root, 0, map);
		Set<Integer> distances = new TreeSet<>(map.keySet());
		for(int i: distances) {
			System.out.println("At Distance " + i + ": " + map.get(new Integer(i)));
		}
	}
	
	private void verticalOrderTraversal(Node<T> node, int dis, HashMap<Integer, List<Node<T>>> map) {
		if(node!=null) {
			List<Node<T>> list = map.get(dis);
			if(list==null)
				list = new ArrayList<>();
			list.add(node);
			map.put(new Integer(dis), list);
			verticalOrderTraversal(node.left, dis-1, map);
			verticalOrderTraversal(node.right, dis+1, map);
		}
	}
	
	public void diagonalOrderTraversal() {
		HashMap<Integer, List<Node<T>>> map = new HashMap<>();
		diagonalOrderTraversal(root, 0, map);
		for(Entry<Integer, List<Node<T>>> entry: map.entrySet()) {
			System.out.println(entry.getValue());
		}
	}
	
	private void diagonalOrderTraversal(Node<T> node, int dis, HashMap<Integer, List<Node<T>>> map) {
		if(node!=null) {
			List<Node<T>> list = map.get(dis);
			if(list==null)
				list = new ArrayList<>();
			list.add(node);
			map.put(new Integer(dis), list);
			diagonalOrderTraversal(node.left, dis+1, map);
			diagonalOrderTraversal(node.right, dis, map);
		}
	}
	
	public void removeShortPathNodes(int k) {
        root = removeShortPathNodes(root, k, 1);
	}
	private Node<T> removeShortPathNodes(Node<T> node, int k, int level) {
		if(node==null)
			return null;
		else {
			node.left = removeShortPathNodes(node.left, k, level+1);
			node.right = removeShortPathNodes(node.right, k, level+1);
			if (node.left == null && node.right == null && level < k)
				return null;
			return node;
		}
	}
	
	public boolean isSubtree(BinarySearchTree<T> bst) {
		Node<T> newHead = serachNode(bst.root.value);
		if(newHead!=null)
			return compareTree(newHead, bst.root);
		else
			return false;
	}
	
	public boolean compareTree(Node<T> node1, Node<T> node2) {
		
		if(node1==null && node2==null) {
			return true;
		}
		if(node1!=null&&node2!=null) {
			System.out.println("Comparing: " + node1.value + "  |   " + node2.value);
			return (node1.value == node2.value && compareTree(node1.left, node2.left) && compareTree(node1.right, node2.right));
		}
		return false;
	}
	
	public Node<T> serachNode(T data){
		return serach(data, root);
	}
	private Node<T> serach(T data, Node<T> node){
		if(node!=null && data!=null) {
			int item = (int) data;
			int curr = (int) node.value;
			if(item==curr)
				return node;
			else if(item<curr)
				return serach(data, node.left);
			else
				return serach(data, node.left);
		}
		else
			return null;
	}
	
	public void reverseAlternateLevels() {
		LinkedList<T> queue = new LinkedList<>();
		if(root!=null)
			levelOfNodeMod(root, 0, queue);
		System.out.println("queue: " + queue);
	}
	private void levelOfNodeMod(Node<T> node, int level, LinkedList<T> queue) {
		if(node!=null) {
			if(node.left!=null)
				levelOfNodeMod(node.left, level + 1, queue);
			if(node.left!=null)
				levelOfNodeMod(node.right, level + 1, queue);
			if(level%2!=0) {
				//odd level
				queue.addFirst(node.value);
			}
			queue.addLast(node.value);
		}
	}
	
	public boolean isFullBinaryTree() {
		return isFullBST(root);
	}
	private boolean isFullBST(Node<T> node) {
		// if empty tree
        if(node == null)
        	return true;
     // if leaf node
        if(node.left == null && node.right == null )
            return true;
     // if both left and right subtrees are not null they are full
        if((node.left!=null) && (node.right!=null))
            return (isFullBST(node.left) && isFullBST(node.right));
        return false;
	}
	
	public void getBottomViewOfTheTree() {
		Queue<Node<T>> queue = new LinkedList<>();
		if(root!=null) {
			queue.add(root);
			while(!queue.isEmpty()) {
				Node<T> node = queue.poll();
				if(node.left!=null)
					queue.add(node.left);
				if(node.right!=null)
					queue.add(node.right);
				if(node.left==null && node.right==null)
					System.out.print(node.getValue() + "  ");
			}
		}
		System.out.println();
	}
	
	public boolean canRepresentBST(int pre[], int n) {
        // Create an empty stack
        Stack<Integer> s = new Stack<Integer>();
 
        // Initialize current root as minimum possible value
        int root = Integer.MIN_VALUE;
 
        // Traverse given array
        for (int i = 0; i < n; i++) {
            // If we find a node who is on right side and smaller than root, return false
            if (pre[i] < root) {
                return false;
            }
 
            // If pre[i] is in right subtree of stack top, keep removing items smaller than pre[i]
            // and make the last removed item as new root.
            while (!s.empty() && s.peek() < pre[i]) {
                root = s.pop();
            }
            
            // At this point either stack is empty or pre[i] is smaller than root, push pre[i]
            s.push(pre[i]);
        }
        return true;
    }
	
	public void inOrderTraversal() {
		inOrder(root);
	}
	
	private void inOrder(Node<T> root) {
		if(root!=null) {
			inOrder(root.left);
			System.out.print(root.value + ", ");
			inOrder(root.right);
		}
	}
	
	public List<T> inOrderTraversalAsList(){
		List<T> list = new ArrayList<>();
		inOrder(root, list);
		return list;
	}
	
	private void inOrder(Node<T> root, List<T> inOrderNodes) {
		if(root!=null) {
			inOrder(root.left, inOrderNodes);
			inOrderNodes.add(root.value);
			inOrder(root.right, inOrderNodes);
		}
	}
	
	public void levelOrderTraversalOrBFS() {
		if(root!=null)
			breadthFirstSearch(root);
	}
	
	private void breadthFirstSearch(Node<T> node) {
		Queue<Node<T>> queue = new LinkedList<Node<T>>();
		queue.add(node);
		while(!queue.isEmpty()) {
			Node<T> curr = queue.poll();
			System.out.println(curr.value);
			if(curr.left!=null)
				queue.add(curr.left);
			if(curr.right!=null)
				queue.add(curr.right);
		}
	}

	public void levelOrderTraversalOrBFSLineByLine() {
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
					System.out.print(curr.value + "\t");
					if (curr.left != null)
						queue.add(curr.left);
					if (curr.right != null)
						queue.add(curr.right);
			}
		}
	}
	
	public void findPairWithGivenSum(int sum) {
		List<T> list =  inOrderTraversalAsList();
		Set set = new HashSet<>(list);
		for(int i=0;i<list.size();i++) {
			int itemToSearchFor = sum - (int) list.get(i);
			if(set.contains(itemToSearchFor)) {
				set.remove(itemToSearchFor);
				System.out.println("Pair is: {" + itemToSearchFor + ", " + list.get(i) + "}");
			}
		}
	}
	
	public void maximumWidthOfTree() {
		if(root!=null)
			System.out.println("Maximum width of the Tree is: " + maximumWidthOfTree(root, 1));
		System.out.println();
	}
	
	private int maximumWidthOfTree(Node<T> node, int width) {
		int maxWidth = width;
		Queue<Node<T>> queue = new LinkedList<Node<T>>();
		queue.add(node);
		queue.add(null);
		while (!queue.isEmpty()) {
			Node<T> curr = queue.poll();
			if (curr == null) {
				if (!queue.isEmpty()) {
					System.out.println();
					queue.add(null);
					maxWidth = Math.max(width, maxWidth);
					width = 0;
				}
			} 
			else {
					System.out.print(curr.value + "\t");
					if (curr.left != null) {
						queue.add(curr.left);
						width++;
					}
					if (curr.right != null) {
						queue.add(curr.right);
						width++;
					}
			}
		}
		return maxWidth;
	}
	
	public T lowestCommonAncestor(int v1, int v2) {
		Node<T> result = null;
		if(root!=null)
			result = getLowestCommonAncestor(root, v1, v2);
		return result==null?null:result.value;
	}
	
	private Node<T> getLowestCommonAncestor(Node<T> node, int v1, int v2) {
		if(node!=null) {
			int value = (int) node.value;
			if(value>v1 && value<v2)
				return node;
			else if(value==v1 || value==v2)
				return node;
			else {
				if(value>v1 && value>v2) {
					return getLowestCommonAncestor(node.left, v1, v2);
				}
				else {
					return getLowestCommonAncestor(node.right, v1, v2);
				}
			}
		}
		return null;
	}
	
	public static class Node<T extends Comparable<T>> {
        private T value;
        private Node<T> left;
        private Node<T> right;
        
        public Node(T value) {
            this.value = value;
        }

		public T getValue() {
			return value;
		}
		public void setValue(T value) {
			this.value = value;
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

		@Override
		public String toString() {
			return "Node [value=" + value + "]";
		}
	}
	
}