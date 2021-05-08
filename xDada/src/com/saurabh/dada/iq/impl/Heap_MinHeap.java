package com.saurabh.dada.iq.impl;

public class Heap_MinHeap {
	
	public static void main(String[] args) {
		
		System.out.println("The Min Heap is ");
        MinHeap minHeap = new MinHeap(15);
        minHeap.insert(5);
        minHeap.insert(3);
        minHeap.insert(17);
        minHeap.insert(10);
        minHeap.insert(84);
        minHeap.insert(19);
        minHeap.insert(6);
        minHeap.insert(22);
        minHeap.insert(9);
        minHeap.minHeap();
 
        minHeap.printHeap();
        System.out.println("The Min val is " + minHeap.remove());
        minHeap.minHeap();
        minHeap.printHeap();
        System.out.println("The Min val is " + minHeap.remove());

	}

}

class MinHeap{
	
	private int[] heap;
	private int size=0;
	private int maxSize=0;
	
	private static final int FRONT = 1;
	
	public MinHeap(int maxSize){
		this.maxSize=maxSize;
		this.size =0;
		this.heap = new int[this.maxSize+1];
		heap[0]=Integer.MIN_VALUE;
	}
	
	private int getParent(int pos){
		return pos/2;
	}
	
	private int getLeftChild(int pos){
		return pos*2;
	}
	
	private int getRightChild(int pos){
		return (pos*2)+1;
	}
	
	private boolean isLeaf(int pos){
		if(pos>=size/2 && pos <= size){
			return true;
		}
		return false;
	}
	
	private void swap(int i,int j){
		heap[i]=heap[i]+heap[j];
		heap[j]=heap[i]-heap[j];
		heap[i]=heap[i]-heap[j];
	}
	
	private void minHeapify(int pos){
		if (!isLeaf(pos))
        { 
            if ( heap[pos] > heap[getLeftChild(pos)]  || heap[pos] > heap[getRightChild(pos)])
            {
                if (heap[getLeftChild(pos)] < heap[getRightChild(pos)])
                {
                    swap(pos, getLeftChild(pos));
                    minHeapify(getLeftChild(pos));
                }else
                {
                    swap(pos, getRightChild(pos));
                    minHeapify(getRightChild(pos));
                }
            }
        }
	}
	
	public void insert(int item){
		heap[++size]=item;
		int curr = size;
		while(heap[curr]<heap[getParent(curr)]){
			swap(curr,getParent(curr));
			curr = getParent(curr);
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
	
	public void minHeap()
    {
        for (int pos = (size / 2); pos >= 1 ; pos--)
        {
            minHeapify(pos);
        }
    }
	
	public int remove()
    {
        int popped = heap[FRONT];
        heap[FRONT] = heap[size--]; 
        minHeapify(FRONT);
        return popped;
    }

}