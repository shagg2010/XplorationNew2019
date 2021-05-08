package com.saurabh.dada.iq.impl.iq.symantec;

import java.util.Iterator;
import java.util.LinkedList;

public class LongNumbersAdditionUsingLinkList {

	public static void main(String[] args) {
		LinkedList<Byte> ll1 = new LinkedList<Byte>();
		LinkedList<Byte> ll2 = new LinkedList<Byte>();
		//ll1 = 8175899
		ll1.addFirst(new Byte("8"));ll1.addFirst(new Byte("1"));ll1.addFirst(new Byte("7"));ll1.addFirst(new Byte("5"));ll1.addFirst(new Byte("8"));ll1.addFirst(new Byte("9"));ll1.addFirst(new Byte("9"));
		//ll2 = 8718
		ll2.addFirst(new Byte("8"));ll2.addFirst(new Byte("7"));ll2.addFirst(new Byte("1"));ll2.addFirst(new Byte("8"));
		System.out.println();
		// ans = 8184617
		display(addNumbers(ll1, ll2));
		for(long i=0;i<Long.MAX_VALUE;i++){
			
		}
	}
	
	public static LinkedList<Byte> addNumbers(LinkedList<Byte> ll1, LinkedList<Byte> ll2){
		LinkedList<Byte> ans = new LinkedList<Byte>();
		byte overflow = 0;
		while(true){
			final Byte item1 = ll1.poll();
			final Byte item2 = ll2.poll();
			if(item1==null&&item2==null)
				break;
			if(item1==null&&item2!=null){
				int sum = item2+overflow;
				if(sum>=10)
					overflow=1;
				else
					overflow=0;
				if(overflow==1){
					sum = sum%10;					
				}
				ans.addFirst(new Byte(String.valueOf(sum)));
			}
			if(item1!=null&&item2==null){
				int sum = item1+overflow;
				if(sum>=10)
					overflow=1;
				else
					overflow=0;
				if(overflow==1){
					sum = sum%10;					
				}
				ans.addFirst(new Byte(String.valueOf(sum)));
			}
			if(item1!=null&&item2!=null){
				int sum = item1+item2+overflow;
				if(sum>=10)
					overflow=1;
				else
					overflow=0;
				if(overflow==1){
					sum = sum%10;					
				}
				ans.addFirst(new Byte(String.valueOf(sum)));
			}
			System.out.print(item1 + "+" + item2 + " ");
		}
		System.out.println();
		return ans;
	}
	
	public static void display(LinkedList<Byte> linkedList){
		Iterator<Byte> it = linkedList.iterator();
		while(it.hasNext()){
			System.out.print(it.next()+" ");
		}
	}

}
