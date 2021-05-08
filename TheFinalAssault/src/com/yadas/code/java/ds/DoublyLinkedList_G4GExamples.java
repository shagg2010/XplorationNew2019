package com.yadas.code.java.ds;

public class DoublyLinkedList_G4GExamples {

	public static void main(String[] args) {
		//basicOperations();
		pairsOfGivenSum();
		sortBiotonicDoublyLinkedList();
		
	}
	private static void sortBiotonicDoublyLinkedList(){
		XDoublyLinkedList<Integer> dll1 = initializeLinkedList("2->5->7->12->10->8->6->4->1->NULL", "->", false);
		sortBiotonic(dll1);
		dll1.traverse();
	}
	private static void sortBiotonic(XDoublyLinkedList<Integer> dll1) {
		XDoublyLinkedList.Node<Integer> curr = dll1.getHeadNode();
		
		while(curr.getNext()!=null) {
			if(curr.getData()>=curr.getNext().getData())
				break;
			curr=curr.getNext();
		}
		dll1.setTailNode(curr);//curr=12
		XDoublyLinkedList.Node<Integer> newCurr =curr.getNext();//newCurr=10
		curr.setNext(null);
		
		XDoublyLinkedList.Node<Integer> prev = curr.getPrev();//prev=7
		XDoublyLinkedList.Node<Integer> newHead = dll1.getHeadNode();
		while(newCurr!=null) {
			System.out.println("newCurr: " + newCurr);
			if(curr.getPrev()==null) { //2->5->7->12->10->8->6->4->1->NULL
				//add as a head node
				XDoublyLinkedList.Node<Integer> t1 = newCurr.getNext();
				newHead = newCurr;
				newCurr.setNext(curr);
				curr.setPrev(newCurr);
				curr = newCurr;
				newCurr = t1;
				newHead.setPrev(null);
				continue;
			}
			if(newCurr.getData()>prev.getData() && newCurr.getData()<=curr.getData()) {
				//compare with sliding window, and insert after prev
				XDoublyLinkedList.Node<Integer> t1 = newCurr.getNext();//t1=8
				System.out.println("curr: " + curr + " prev: " + prev + " t1: " + t1);
				curr.setPrev(newCurr);//10<-12
				newCurr.setNext(curr);//10->12
				prev.setNext(newCurr);//7->10
				newCurr.setPrev(prev);//7<-10
				curr=newCurr;//curr=10					//update the sliding window
				newCurr = t1;//newCurr=8
				System.out.println("curr: " + curr + " prev: " + prev + " t1: " + t1);
			}
			else {//move the sliding window
				curr=prev;
				prev=curr.getPrev();
				System.out.println("curr: " + curr + " prev: " + prev);
			}
		}
		dll1.setHeadNode(newHead);
	}
	
	private static void pairsOfGivenSum() {
		XDoublyLinkedList<Integer> dll1 = initializeLinkedList("-2->1->2->4->5->6->8->9->NULL", "->", false);
		pairsOfGivenSum(dll1, 7);
	}
	
	private static void pairsOfGivenSum(XDoublyLinkedList<Integer> dll1,int sum) {
		XDoublyLinkedList.Node<Integer> head = dll1.getHeadNode();
		XDoublyLinkedList.Node<Integer> tail = dll1.getTailNode();
		while(head!=tail) {
			if(head.getData()+tail.getData()==sum) {
				System.out.println("[" + head.getData() + ", " + tail.getData() + "]");
				head=head.getNext();
				tail=tail.getPrev();
			}
			else if(head.getData()+tail.getData()>0) {
				tail=tail.getPrev();
			}
			else {
				head=head.getNext();
			}
		}
	}
	
	private static void basicOperations() {
		XDoublyLinkedList<Integer> dll1 = initializeLinkedList("17->15->8->12->10->5->4->1->7->6->NULL", "->", false);
		dll1.traverse();
		dll1.traverseReverse();
	}

	public static XDoublyLinkedList<Integer> initializeLinkedList(String itemsStr, String delimiter, boolean sorted){
		XDoublyLinkedList<Integer> dll = new XDoublyLinkedList<Integer>();
		String[] itemArray = itemsStr.split(delimiter);
		for(int i=0;i<itemArray.length;i++) {
			if(!itemArray[i].equalsIgnoreCase("null"))
				if(!sorted)
					dll.add(Integer.valueOf(itemArray[i]));
				else
					dll.addSorted(Integer.valueOf(itemArray[i]));
		}
		return dll;
	}
}
