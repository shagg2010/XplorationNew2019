package com.yadas.code.java.ds;

import java.util.ArrayList;
import java.util.List;

public class XHeap {
	
	private List<Integer> heap = null;
	private int size = 0;
	private static final int FRONT = 1;
	private boolean minHeap = false;
	
	public XHeap(){
		this(false);
	}
	
	public XHeap(boolean minHeap){
		this.heap = new ArrayList<Integer>();
		heap.add(Integer.MAX_VALUE);
		this.size = heap.size() -1;
		this.minHeap = minHeap;
	}
	
	public int getParent(int pos) {
		return pos/2;
	}
	public int getLeftChild(int pos) {
		return pos*2;
	}
	public int getRightChild(int pos) {
		return (pos*2)+1;
	}
	public boolean isLeaf(int pos) {
		return pos>=(this.size/2) && pos<=size?true:false;
	}
	
	public void insert(int item) {
		this.heap.add(item);
		this.size = heap.size() -1;
		int child = size;
		if(!minHeap) {//it is maxHeap
			while(heap.get(child)>heap.get(getParent(child))) {
				swap(child, getParent(child));
				child = getParent(child);
			}
		}
		else {//it's minHeap
			while(heap.get(child)<heap.get(getParent(child))) {
				swap(child, getParent(child));
				child = getParent(child);
			}
		}
	}
	
	public int remove() {
		int res = heap.get(FRONT);
		heap.set(FRONT, heap.remove(size));
		this.size = this.heap.size() - 1;
		heapify(FRONT);
		return res;
	}
	
	private void heapify(int pos) {
		
		if(!isLeaf(pos)) {
			if(!minHeap) {//it is maxHeap
				if(heap.get(pos)<heap.get(getLeftChild(pos)) || heap.get(pos)<heap.get(getRightChild(pos))) {
					if(heap.get(getLeftChild(pos))>=heap.get(getRightChild(pos))){
						swap(pos,getLeftChild(pos));
						heapify(getLeftChild(pos));
					}
					else {
						swap(pos,getRightChild(pos));
						heapify(getRightChild(pos));
					}
				}
			}
			else {//it's minHeap
				if(heap.get(pos)>heap.get(getLeftChild(pos)) || heap.get(pos)>heap.get(getRightChild(pos))) {
					if(heap.get(getLeftChild(pos))>=heap.get(getRightChild(pos))){
						swap(pos,getLeftChild(pos));
						heapify(getLeftChild(pos));
					}
					else {
						swap(pos,getRightChild(pos));
						heapify(getRightChild(pos));
					}
				}
			}
		}
	}
	
	public void buildHeap() {
		for(int i=size/2;i>=1;i--) {//heapify all non-leaf nodes
			heapify(i);
		}
	}
	
	private void swap(int i,int j){
		int t = heap.get(i);
		heap.set(i, heap.get(j));
		heap.set(j, t);
	}
	
	public void printHeap() {
		for (int i=FRONT;i<=size/2;i++) {
			System.out.println("\tParent : " + heap.get(i));
			if(2*i<=size)
				System.out.print("Left Child: " + heap.get(getLeftChild(i)));
			if(((2*i)+1)<=size)	
				System.out.print("\tRight Child: " + heap.get(getRightChild(i)));
			System.out.println();
		}
		
	}
}
