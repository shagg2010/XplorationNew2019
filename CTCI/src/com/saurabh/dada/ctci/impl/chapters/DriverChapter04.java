package com.saurabh.dada.ctci.impl.chapters;

import java.util.Stack;

import com.saurabh.dada.ctci.impl.chapters.logic.BinarySearchTreeCTCI;
import com.saurabh.dada.ctci.impl.chapters.logic.Chapter04_TreeAndGraphsProblems;

public class DriverChapter04 {
	
	private static int[] TREE_ITEMS = {100,75,150,95,20,99,110,170};
	private static int[] TREE_ITEMS_SORTED = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18};
	private static int[] TREE_ITEMS_SUBTREE = {11,10,12,13};
	private static int[] TREE_ITEMS_NOT_SUBTREE = {11,10,9,12,13};
	//check tree structure is correct or not @ https://www.cs.usfca.edu/~galles/visualization/BST.html
			/**				100
			 * 	   75						150
			 * 20		95			    110		 170
			 * 				99
			 * 
			 */
	public static void main(String[] args) {
		
		BinarySearchTreeCTCI bst = createTree(TREE_ITEMS);
		bst.displayTree();
		
		//find the level of a node, root is 1 and if node is not found then return 0
		int ans = Chapter04_TreeAndGraphsProblems.findLevelOfNode(bst, 99);
		System.out.println("Level of 99: " + ans);
		System.out.println("Level of 98 (not a tree node): " + bst.getLevelOfNode(98));
		
		
		//find if the tree is balanced or not, that is the level of leaf-nodes are not more than 1
		boolean ans1 = Chapter04_TreeAndGraphsProblems.isBalanced(bst);
		System.out.println("Is this tree balanced: " + ans1);
		
		BinarySearchTreeCTCI bst1 = Chapter04_TreeAndGraphsProblems.createBalancedTreeFromSortedArray(new BinarySearchTreeCTCI(), TREE_ITEMS_SORTED);
		bst1.displayTree();
		System.out.println("Is balanced: " + bst1.isBalanced());
		System.out.println("Level order traversal, line by line: ");
		bst1.levelOrderTraversalModified();
		
		Integer ans2 = Chapter04_TreeAndGraphsProblems.findCommonAncestor(bst1, 5, 8);
		System.out.println("Common ancestor for 5 and 8: " + ans2);

		BinarySearchTreeCTCI bst2Sub = createTree(TREE_ITEMS_SUBTREE);
		BinarySearchTreeCTCI bst3Sub = createTree(TREE_ITEMS_NOT_SUBTREE);
	
		boolean ans3_1 = Chapter04_TreeAndGraphsProblems.isSubTree(bst1, bst2Sub);
		System.out.println("Is subtree: " + ans3_1);
		boolean ans3_2 = Chapter04_TreeAndGraphsProblems.isSubTree(bst1, bst3Sub);
		System.out.println("Is subtree: " + ans3_2);
		
		System.out.println("All possible path from root ");
		bst1.allPathsFromRoot();
		
		System.out.println("Paths leading to sum of 10: ");
		Chapter04_TreeAndGraphsProblems.findPathEqualToSum(bst1, 10);
		
		
		
		
	}

	public static BinarySearchTreeCTCI createTree(int[] items){
		BinarySearchTreeCTCI bst = new BinarySearchTreeCTCI();
		for(int data:items){
			bst.insert(data);
		}
		return bst;
	}
}
