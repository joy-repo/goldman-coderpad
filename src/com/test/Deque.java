package com.test;

/**
 * Deque implementation using doubly linked list.
 *
 * A deque (double-ended queue) is a data structure that allows insertion and
 * deletion of elements from both ends.
 *
 * This implementation provides methods to insert and remove elements from both
 * the front and back of the deque.
 *
 */
public class Deque {

	Node head;
	Node tail;

	Deque() {
		this.head = null;
		this.tail = null;
	}

	static class Node {
		int data;
		Node prev;
		Node next;

		Node(int data) {
			this.data = data;
		}
	}

	public boolean isEmpty() {
		return head == null;
	}

	public void insertFront(int data) {
		Node n = new Node(data);
		if(head==null) { insertFirst(n); return;}
		n.next = head;
		head.prev=n;
		head =n;
	}

	private void insertFirst(Node n) {
		head =tail=n;
	}

	public void insertLast(int data) {
		Node n = new Node(data);
		if(tail==null){ insertFirst(n); return;}
		tail.next=n;
		n.prev=tail;
		tail=tail.next;
		
	}

	public Node removeLast() {
		if(tail==null) return null;
		Node n = tail;
		if(head==tail) { tail=null; head =null;return n;}
		
		tail=tail.prev;
		tail.next=null;
		return n;
	}

	public Node removeFront() {
		if(head==null) return null;
		Node n =head;
		if(head==tail) { tail=null; head =null;return n;}
		
		head=head.next;
		head.prev=null;
		return n;
	}
	
	public String toString() {
		Node n = head;
		String str = "-";
		while(n!=null) {
			str=str+"-"+n.data;
			n=n.next;
		}
		return str;
	}

	public static void main(String[] s) {
		
		Deque d = new Deque();
		d.insertFront(1);
		System.out.println(d.head.data);
		System.out.println(d.tail.data);
		d.insertLast(10);
		System.out.println(d.removeLast().data);
		System.out.println(d.head.data);
		System.out.println(d.tail.data);
		d.insertFront(5);
		System.out.println(d.head.data);
		System.out.println(d.tail.data);
		System.out.println("-----");
		System.out.println(d.removeLast().data);
		System.out.println(d.removeLast().data);
		
		System.out.println(d.removeLast());
		
		
//		d.insertLast(10);
//		System.out.println(d.removeFront());
//		System.out.println(d.isEmpty());
		

	}

}
