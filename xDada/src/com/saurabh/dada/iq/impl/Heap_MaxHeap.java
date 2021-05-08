package com.saurabh.dada.iq.impl;

public class Heap_MaxHeap {

	private static int[] list = {5,10,11,13,21,7,6,25,81};
	public static void main(String[] args) {
		MaxHeap maxHeap = new MaxHeap(list.length);
		for(int i:list){
			maxHeap.insert(i);
		}
		maxHeap.printHeap();
		maxHeap.maxHeap();
		System.out.println("Removing: " + maxHeap.remove());
		maxHeap.printHeap();
		

	}

}
class MaxHeap{
	
	private int[] heap;
	private int size=0;
	private int maxSize=0;
	
	private static final int FRONT = 1;
	
	public MaxHeap(int maxSize){
		this.maxSize=maxSize;
		this.size=0;
		this.heap = new int[this.maxSize+1];
		heap[0]=Integer.MAX_VALUE;
	}
	
	public int getParent(int pos){
		return pos/2;
	}
	
	public int getLeftChild(int pos){
		return pos*2;
	}
	
	public int getRightChild(int pos){
		return (pos*2)+1;
	}
	
	public boolean isLeaf(int pos){
		if(pos>=size/2 && pos<=size)
			return true;
		return false;
	}
	
	public void insert(int item){
		heap[++size]=item;
		int curr=size;
		while(heap[curr]>heap[getParent(curr)]){
			swap(curr,getParent(curr));
			curr=getParent(curr); 
		}
	}
	
	public int remove(){
		int popped = heap[FRONT];
		heap[FRONT]=heap[size--];
		maxHeapify(FRONT);
		return popped;
	}
	private void maxHeapify(int pos){
		if(!isLeaf(pos)){
			if(heap[pos]<heap[getLeftChild(pos)] || heap[pos]<heap[getRightChild(pos)]){
				if(heap[getLeftChild(pos)]>heap[getRightChild(pos)]){
					swap(getLeftChild(pos),pos);
					maxHeapify(getLeftChild(pos));
				}
				else{
					swap(getRightChild(pos),pos);
					maxHeapify(getRightChild(pos));
				}
			}
		}
	}
	
	public void printHeap()
    {
		for (int i=1;i<=size/2;i++) {
			System.out.print(" PARENT : " + heap[i]);
			if(2*i<=size)
				System.out.print(" LEFT CHILD : " + heap[2 * i]);
			if(((2*i)+1)<=size)	
				System.out.print(" RIGHT CHILD :" + heap[(2 * i) + 1]);
			System.out.println();
		} 
    }
	
	public void maxHeap()
    {
        for (int pos = (size / 2); pos >= 1 ; pos--)
        {
            maxHeapify(pos);
        }
    }
	
	private void swap(int i,int j){
		heap[i]=heap[i]+heap[j];
		heap[j]=heap[i]-heap[j];
		heap[i]=heap[i]-heap[j];
	}
}
