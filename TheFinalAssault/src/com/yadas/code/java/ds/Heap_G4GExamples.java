package com.yadas.code.java.ds;

public class Heap_G4GExamples {

	private static int[] list = {5,10,11,13,21,7,6,25,81};
	
	public static void main(String[] args) {
		
		
		XHeap maxHeap = new XHeap();
		
		for(int i=0;i<list.length;i++){
			maxHeap.insert(list[i]);
		}

		maxHeap.printHeap();
		maxHeap.buildHeap();
		System.out.println("Removing: " + maxHeap.remove());
		maxHeap.printHeap();
	}

}
