package com.yadas.code.java.ds;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BinaryTree_G4GExamples {

	public static void main(String[] args) {
		//basicOperations();
		//otheOperations1();
		//otheOperations2();
		//otheOperations3();
		//otheOperations4();
		//otheOperations5();
		//otheOperations6();
		//otheOperations7();
		//otheOperations8();
		otheOperations9();
	}
	
	private static void otheOperations9() {
		XBinaryTree<Integer> bt5 = new XBinaryTree<>(false);
		bt5.insert(10); 
		bt5.insert(20); 
		bt5.insert(30); 
		bt5.insert(40); 
		bt5.insert(50); 
		bt5.insert(60); 
		bt5.insert(70); 
		bt5.levelOrderTraversalOrBFSLineByLine();
		System.out.println("Is Perfect Tree: " + bt5.isPerfect());
	}
	
	private static void otheOperations7() {
		XBinaryTree<Integer> bt5 = new XBinaryTree<>(false);
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
	
	private static void otheOperations8() {
		
	}
	
	private static void otheOperations6() {
		XBinaryTree<Integer> bt5 = new XBinaryTree<>(false);
		bt5.insert(10);
		bt5.insert(5);
		bt5.insert(15);
		bt5.insert(3);
		bt5.insert(7);
		bt5.insert(9);
		bt5.insert(18);
		bt5.inOrderTraversal();
		bt5.kThSmallestElement(5);
	}
	
	private static void otheOperations5() {
		XBinaryTree<Integer> bt5 = new XBinaryTree<>(false);
		bt5.insert(10);
		bt5.insert(5);
		bt5.insert(15);
		bt5.insert(3);
		bt5.insert(7);
		bt5.insert(9);
		bt5.insert(18);
		bt5.levelOrderTraversalOrBFSLineByLine();
		System.out.println("Is Binary Tree: " + bt5.isBinarySearchTree());
	}
	private static void otheOperations4() {
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);list.add(2);list.add(3);list.add(4);list.add(5);list.add(6);list.add(7);list.add(8);list.add(9);list.add(10);
		list.add(11);list.add(12);list.add(13);list.add(14);list.add(15);
		XBinaryTree<Integer> bt5 = new XBinaryTree<>(false);
		bt5.createBalancedTreeFromSortedList(list);
		bt5.levelOrderTraversalOrBFSLineByLine();
		bt5.inOrderTraversal();
		
	}
	private static void otheOperations3() {
		XBinaryTree<Integer> bt5 = new XBinaryTree<>(false);
		bt5.insert(8);
		bt5.insert(3);
		bt5.insert(10);
		bt5.insert(11);
		bt5.insert(5);
		bt5.insert(7);
		bt5.insert(2);
		bt5.insert(1);
		bt5.insert(9);
		bt5.insert(4);
		bt5.insert(6);
		bt5.insert(12);
		bt5.insert(13);
		bt5.insert(14);
		bt5.insert(15);
		
		List<Integer> list = bt5.inOrderTraversalAsList();
		//System.out.println("list:" + list);
		bt5.levelOrderTraversalOrBFSLineByLine();
		bt5.updateTreeFromSortedInoderTraversal(list);
		bt5.inOrderTraversal();
	}
	
	private static void otheOperations2() {
		//diagonalTraversal
		displayTree();
		XBinaryTree<String> bt5 = new XBinaryTree<>(false);
		bt5.insert("8");
		bt5.insert("3");
		bt5.insert("10");
		bt5.insert("11");
		bt5.insert("5");
		bt5.insert("7");
		bt5.insert("2");
		bt5.insert("1");
		bt5.insert("9");
		bt5.insert("4");
		bt5.insert("6");
		bt5.insert("12");
		bt5.insert("13");
		bt5.insert("14");
		bt5.insert("15");
		bt5.diagonalOrderTraversal();
		bt5.boundaryTraversal();
		
		List<String> list = bt5.inOrderTraversalAsList();
		System.out.println("list:" + list);
		
		bt5.updateTreeFromSortedInoderTraversal(list);
		bt5.inOrderTraversal();
	}
	
	private static XBinaryTree<String> displayTree() {
		XBinaryTree<String> bt5 = new XBinaryTree<>(false);
		bt5.insert("\t\t\t    8");
		bt5.insert("\t\t3");
		bt5.insert("\t\t\t10");
		bt5.insert("\t11");
		bt5.insert("\t5");
		bt5.insert("\t7");
		bt5.insert("\t2");
		bt5.insert("    1");
		bt5.insert("    9");
		bt5.insert("    4");
		bt5.insert("    6");
		bt5.insert("   12");
		bt5.insert("   13");
		bt5.insert("   14");
		bt5.insert("   15");
		bt5.levelOrderTraversalOrBFSLineByLine();
		return bt5;
	}
	
	private static void otheOperations1() {
		//https://www.geeksforgeeks.org/reverse-alternate-levels-binary-tree/
		XBinaryTree<Character> bt5 = new XBinaryTree<>(true);
		bt5.insert('a');
		bt5.insert('b');
		bt5.insert('c');
		bt5.insert('d');
		bt5.insert('e');
		bt5.insert('f');
		bt5.insert('g');
		bt5.insert('h');
		bt5.insert('i');
		bt5.insert('j');
		bt5.insert('k');
		bt5.insert('l');
		bt5.insert('m');
		bt5.insert('n');
		bt5.insert('o');
		bt5.levelOrderTraversalOrBFSLineByLine();
		bt5.reverseAlternativeLevels();
		bt5.levelOrderTraversalOrBFSLineByLine();
	}

	private static void basicOperations() {
		XBinaryTree<String> bt1 = new XBinaryTree<String>();
		bt1.insert("6");
		bt1.insert("24");
		bt1.insert("19");
		bt1.insert("94");
		bt1.insert("5");
		bt1.insert("1");
		bt1.insert("10");
		bt1.insert("3");
		bt1.insert("8");
		
		bt1.postOrderTraversal();
		bt1.preOrderTraversal();
		bt1.inOrderTraversal();
		bt1.levelOrderTraversalOrBFSLineByLine();
		
		XBinaryTree<Integer> bt2 = new XBinaryTree<Integer>();
		bt2.insert(3);
		bt2.insert(2);
		bt2.insert(4);
		bt2.insert(1);
		bt2.insert(3);
		bt2.insert(5);
		bt2.levelOrderTraversalOrBFSLineByLine();
		System.out.println("\nIs Continuous Tree: " + bt2.isContinuousTree());
		
		XBinaryTree<Integer> bt3 = new XBinaryTree<Integer>();
		bt3.insert(3);
		bt3.insert(2);
		bt3.insert(4);
		bt3.insert(1);
		bt3.insert(3);
		bt3.insert(5);
		bt3.insert(8);
		bt3.levelOrderTraversalOrBFSLineByLine();
		System.out.println("\nIs Mirror Tree: " + bt3.isMirror());
		bt3.mirror();
		System.out.println("Mirror Tree: ");bt3.levelOrderTraversalOrBFSLineByLine();
		
		XBinaryTree<Integer> bt4 = new XBinaryTree<Integer>(true);
		bt4.insert(1);
		bt4.insert(2);
		bt4.insert(2);
		bt4.insert(3);
		bt4.insert(4);
		bt4.insert(4);
		bt4.insert(3);
		bt4.levelOrderTraversalOrBFSLineByLine();
		System.out.println("\nIs Symmetric Tree: " + bt4.isSymmetric());
		
		
		
	}
}
