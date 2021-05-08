package com.saurabh.dada.iq.impl.data_structures;

public class Heap_MaxHeap {

	private static int[] list = {5,10,11,13,21,7,6,25,81};
	
	public static void main(String[] args) {
		
		MaxHeap maxHeap = new MaxHeap(list.length);
		for(int i:list){
			maxHeap.insert(i);
		}
		maxHeap.printHeap();
		//maxHeap.maxHeap();
		System.out.println("Removing: " + maxHeap.remove());
		maxHeap.printHeap();

	}
	
	private static class MaxHeap{
		private int maxSize = 100;
		private int[] heap;
		private int size=0;
		private static final int FRONT = 1;
		
		public MaxHeap(int maxSize) {
			this.maxSize = maxSize;
			this.heap = new int[this.maxSize + 1];
			this.size = 0;
			//heap[size]=Integer.MAX_VALUE;
		}
		public int getLeftChild(int i) {
			return i*2;
		}
		public int getRightChild(int i) {
			return (i*2) + 1;
		}
		public int getParent(int i) {
			return i/2;
		}
		public boolean isLeaf(int i) {
			if(i>=size/2 && i<=size)
				return true;
			return false;
		}
		
		public void insert(int item) {
			heap[++size] = item;
			int curr = size;
			while(heap[curr]>heap[getParent(curr)] && getParent(curr)>0) {
				swap(curr, getParent(curr));
				curr = getParent(curr);
			}
		}
		public int remove() {
			int popped = heap[FRONT];
			heap[FRONT] = heap[size--];
			maxHeapify(FRONT);
			return popped;
		}
		
		private void maxHeapify(int i){
			if(!isLeaf(i)) {
				if(heap[i]<heap[getLeftChild(i)] || heap[i]<heap[getRightChild(i)]) {
					if(heap[getLeftChild(i)]>heap[getRightChild(i)]) {
						swap(i,getLeftChild(i));
						maxHeapify(getLeftChild(i));
					}
					else {
						swap(i,getRightChild(i));
						maxHeapify(getRightChild(i));
					}
				}
			}
		}
		
		/*public void maxHeap() {
			for(int i=size/2;i>1;i--) {
				maxHeapify(i);
			}
		}*/
		
		public void printHeap() {
			for (int i=1;i<=size/2;i++) {
				System.out.print(" Parent : " + heap[i] + "\t");
				if(2*i<=size)
					System.out.print("Left: " + heap[2 * i]);
				if(((2*i)+1)<=size)	
					System.out.print("   Right:" + heap[(2 * i) + 1]);
				System.out.println();
			} 
		}
		private void swap(int i,int j){
			heap[i]=heap[i]+heap[j];
			heap[j]=heap[i]-heap[j];
			heap[i]=heap[i]-heap[j];
		}
	}
}
