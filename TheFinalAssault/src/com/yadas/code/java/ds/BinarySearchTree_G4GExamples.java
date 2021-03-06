package com.yadas.code.java.ds;


public class BinarySearchTree_G4GExamples {
	/**				50
	 * 	   30						70
	 * 20		40			    60		 80
	 * 				45
	 * 
	 */
	public static void main(String[] args) {
		//basicOperations();
		//convertToSumTree();
		//convertToGreaterSumTree();
		//convertToSumOfSmallerKeys();
		//convertToMinHeap();
		//findTheLowestCommonAncestor();
		//isBST();
		hasDeadEnd();
		//findLargestNumberLessThanOrEqualToN();
		//shortestDistanceBetweenNodes();
		//removeNodeFromBST();
		//removeNode();
		//removeNodesOutsideTheRange();
		
	}
	
	private static void removeNodesOutsideTheRange() {
		XBinarySearchTree<Integer> bst5 = new XBinarySearchTree<>(false);
		bst5.insert(6); 
		bst5.insert(-13); 
		bst5.insert(14); 
		bst5.insert(-8); 
		bst5.insert(13); 
		bst5.insert(15); 
		bst5.insert(7);
		bst5.levelOrderTraversalOrBFSLineByLine();
		bst5.removeNodesOutsideTheRange(-10, 13);
	}
	
	private static void removeNode() {
		XBinarySearchTree<Integer> bst5 = new XBinarySearchTree<>(false);
		bst5.insert(6); 
		bst5.insert(-13); 
		bst5.insert(14); 
		bst5.insert(-8); 
		bst5.insert(13); 
		bst5.insert(15); 
		bst5.insert(7);
		bst5.levelOrderTraversalOrBFSLineByLine();
		bst5.remove(14);
		bst5.levelOrderTraversalOrBFSLineByLineMod();
	}
	
	private static void removeNodeFromBST() {
		XBinarySearchTree<Integer> bst5 = new XBinarySearchTree<>(false);
		bst5.insert(5); 
		bst5.insert(2); 
		bst5.insert(12); 
		bst5.insert(-4); 
		bst5.insert(3); 
		bst5.insert(9); 
		bst5.insert(21);
		bst5.insert(19);
		bst5.insert(25);
		bst5.levelOrderTraversalOrBFSLineByLine();
		bst5.remove(12);
		bst5.levelOrderTraversalOrBFSLineByLine();
	}
	
	private static void shortestDistanceBetweenNodes() {
		XBinarySearchTree<Integer> bst5 = new XBinarySearchTree<>(false);
		bst5.insert(5); 
		bst5.insert(2); 
		bst5.insert(12); 
		bst5.insert(3); 
		bst5.insert(1); 
		bst5.insert(9); 
		bst5.insert(21);
		bst5.insert(19);
		bst5.insert(25);
		bst5.levelOrderTraversalOrBFSLineByLine();
		bst5.findShortestDistanceBetweenNodes(9, 25);
		
	}
	
	private static void findLargestNumberLessThanOrEqualToN() {
		XBinarySearchTree<Integer> bst5 = new XBinarySearchTree<>(false);
		bst5.insert(5); 
		bst5.insert(2); 
		bst5.insert(12); 
		bst5.insert(3); 
		bst5.insert(1); 
		bst5.insert(9); 
		bst5.insert(21);
		bst5.insert(19);
		bst5.insert(25);
		bst5.levelOrderTraversalOrBFSLineByLine();
		bst5.findLargestNumberLessThanOrEqualToN(24);
	}
	
	private static void hasDeadEnd() {
		XBinarySearchTree<Integer> bt5 = new XBinarySearchTree<>(false);
		bt5.insert(8); 
		bt5.insert(5); 
		bt5.insert(2); 
		bt5.insert(3); 
		bt5.insert(7); 
		bt5.insert(11); 
		bt5.insert(4); 
		bt5.levelOrderTraversalOrBFSLineByLine();
		System.out.println("Has Dead End: " + bt5.hasDeadEnd());
	}
	
	private static void isBST() {
		XBinaryTree<Integer> bt1 = new XBinaryTree<Integer>();
		bt1.insert(3);
		bt1.insert(2);
		bt1.insert(5);
		bt1.insert(1);
		bt1.insert(4);
		bt1.levelOrderTraversalOrBFSLineByLine();
		System.out.println(bt1.isBinarySearchTree());
	}
	
	private static void findTheLowestCommonAncestor() {
		XBinarySearchTree<Integer> bst1 = new XBinarySearchTree<Integer>();
		bst1.insert(20);
		bst1.insert(8);
		bst1.insert(22);
		bst1.insert(4);
		bst1.insert(12);
		bst1.insert(10);
		bst1.insert(14);
		bst1.levelOrderTraversalOrBFSLineByLine();
		bst1.findLowestAncestor(10, 14);
		bst1.findLowestAncestor(14, 8);
		bst1.findLowestAncestor(10, 22);
		bst1.findLowestAncestor(14, 22);
		bst1.findLowestAncestor(4, 22);
	}
	
	private static void convertToMinHeap() {
		XBinarySearchTree<Integer> bst = new XBinarySearchTree<Integer>();
		bst.insert(8);
		bst.insert(4);
		bst.insert(12);
		bst.insert(2);
		bst.insert(6);
		bst.insert(10);
		bst.insert(14);
		
		bst.levelOrderTraversalOrBFSLineByLine();
		bst.updateToMinHeapTree();
		bst.levelOrderTraversalOrBFSLineByLine();
	}
	
	private static void convertToSumOfSmallerKeys() {
		XBinarySearchTree<Integer> bst = new XBinarySearchTree<Integer>();
		bst.insert(11);
		bst.insert(29);
		bst.insert(2);
		bst.insert(7);
		bst.insert(15);
		bst.insert(40);
		bst.insert(1);
		bst.insert(35);
		bst.levelOrderTraversalOrBFSLineByLine();
		bst.updateToSumOfSmallerKeys();
		bst.levelOrderTraversalOrBFSLineByLine();
	}

	private static void convertToGreaterSumTree() {
		XBinarySearchTree<Integer> bst = new XBinarySearchTree<Integer>();
		bst.insert(11);
		bst.insert(29);
		bst.insert(2);
		bst.insert(7);
		bst.insert(15);
		bst.insert(40);
		bst.insert(1);
		bst.insert(35);
		bst.levelOrderTraversalOrBFSLineByLine();
		bst.updateToGreaterSumTree();
		bst.levelOrderTraversalOrBFSLineByLine();
	}
	
	private static void convertToSumTree() {
		XBinarySearchTree<Integer> bst = new XBinarySearchTree<Integer>();
		bst.insert(50);
		bst.insert(30);
		bst.insert(20);
		bst.insert(40);
		bst.insert(70);
		bst.insert(60);
		bst.insert(80);
		bst.insert(45);
		bst.reverseLevelTraversalLineByLine();
		System.exit(0);
		bst.spiralFormTraversalLineByLine();
		bst.zigZagTraversalLineByLine();
		bst.levelOrderTraversalOrBFSLineByLine();
		bst.inOrderTraversal();
		bst.preOrderTraversal();
		bst.postOrderTraversal();
		bst.convertToSumTree();
		bst.convertToSumOfInOrderSuccessorAndPredecessor();
	}
	
	
	private static void basicOperations() {
		XBinarySearchTree<Integer> bst = new XBinarySearchTree<Integer>();
		bst.insert(50);
		bst.insert(30);
		bst.insert(20);
		bst.insert(40);
		bst.insert(70);
		bst.insert(60);
		bst.insert(80);
		bst.insert(45);
		bst.inOrderTraversal();
		bst.levelOrderTraversalOrBFSLineByLine();
	}
	
}
