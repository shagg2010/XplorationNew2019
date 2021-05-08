package com.saurabh.dada.ctci.impl.chapters.logic;

public class Chapter04_TreeAndGraphsProblems {
	
	public static int findLevelOfNode(BinarySearchTreeCTCI bst,int data){
		return bst.getLevelOfNode(data);
	}
	
	//find maxDepth and minDepth, the difference must not be more than 1
	public static boolean isBalanced(BinarySearchTreeCTCI bst){
		return bst.isBalanced();
	}
	
	public static BinarySearchTreeCTCI createBalancedTreeFromSortedArray(BinarySearchTreeCTCI bst,int[] items){
		bst.setRoot(bst.createMinimalBST(items));
		return bst;
	}
	
	public static Integer findCommonAncestor(BinarySearchTreeCTCI bst, Integer n1,Integer n2){
		java.util.Stack<Integer> st1 = bst.searchNodePath(n1);
		java.util.Stack<Integer> st2 = bst.searchNodePath(n2);
		return evaluatePathStackForCommonAncestor(st1, st2);
	}
	
	public static void findPathEqualToSum(BinarySearchTreeCTCI bst, int sum){
		bst.findSumPaths(sum);
	}
	
	public static boolean isSubTree(BinarySearchTreeCTCI tree, BinarySearchTreeCTCI subTree){
		boolean ans=false;
		if(subTree==null)
			return ans;
		BinarySearchTreeCTCI.Node node = tree.findNode(subTree.getRoot().getData());
		if(node==null)
			return ans;
		ans = tree.containsSubTree(node, subTree.getRoot());
		return ans;
	}
	
	private static Integer evaluatePathStackForCommonAncestor(java.util.Stack<Integer> st1,java.util.Stack<Integer> st2){
		
		System.out.print("\nStack1: ");
		if(st1!=null){
			System.out.println(st1);
		}
		System.out.print("\nStack2: ");
		if(st2!=null){
			System.out.println(st2);
		}
		if(st1==null||st2==null)
			return null;
		else{
			Integer ans=null;
			int i=0;
			while(true){
				if(st2.get(i)==st1.get(i)){
					ans=st2.get(i);
				}
				else{
					break;
				}
				if((i>=st1.size()-1)||(i>=st2.size()-1)){
					break;
				}
				i++;
			}
			return ans;
		}
	}

}
