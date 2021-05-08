package com.saurabh.dada.iq.impl;

import java.util.Stack;

public class QueueUsingStack_Optimized {

	public static void main(String[] args) {

		QueueOptimized<Integer> ds = new QueueOptimized<Integer>();
		ds.queue(2);
		ds.queue(3);
		ds.queue(4);
		ds.queue(5);
		System.out.print(ds.dequeue() + " ");
		System.out.print(ds.dequeue() + " ");
		ds.queue(6);
		ds.queue(7);
		ds.queue(8);
		System.out.print(ds.dequeue() + " ");
		System.out.print(ds.dequeue() + " ");
		System.out.print(ds.dequeue() + " ");
		System.out.print(ds.dequeue() + " ");
		System.out.print(ds.dequeue() + " ");

	}

}

class QueueOptimized<E>
{

    private Stack<E> inbox = new Stack<E>();
    private Stack<E> outbox = new Stack<E>();

    public void queue(E item) {
        inbox.push(item);
    }

    public E dequeue() {
        if (outbox.isEmpty()) {
            while (!inbox.isEmpty()) {
               outbox.push(inbox.pop());
            }
        }
        return outbox.pop();
    }

}


