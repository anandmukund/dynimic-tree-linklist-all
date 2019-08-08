package com.dp;

public class ReverseLinkedList {
	public static void main (String[] args) throws java.lang.Exception
	{
		LinkedListT a = new LinkedListT();
		a.addAtBegin(5);
		a.addAtBegin(10);
		a.addAtBegin(15);
		a.addAtBegin(20);
		a.addAtBegin(25);
		a.addAtBegin(30);
//		System.out.print("Original Link List 1 : ");
		a.display(a.head);
		a.reverseIterative(a.head);
		LinkedListT b = new LinkedListT();
		b.addAtBegin(31);
		b.addAtBegin(32);
		b.addAtBegin(33);
		b.addAtBegin(34);
		b.addAtBegin(35);
		b.addAtBegin(36);
		System.out.println("");
		System.out.println("___________________");
		System.out.print("Original Link List 2 : ");
		b.reverseList(b.head);
		b.display(b.head);
		/*
		b.reverseRecursion(b.head,b.head.next,null);
		System.out.println("");*/
		//b.display(x);
	}
}
class Node{
	public int data;
	public Node next;
	public Node(int data){
		this.data = data;
		this.next = null;
	}
}
class LinkedListT{
	public Node head;
	public LinkedListT(){
		head=null;
	}

	public void addAtBegin(int data){
		Node n = new Node(data);
		n.next = head;
		head = n;
	}
	
	public Node reverseList(Node input){
		Node n = null;
		Node head= input;
		if(input != null){
		Node next = input.next;
		n = input.next;
		n.next = head;
		if(next.next != null){
		head.next = reverseList(next.next);
		}
		}
		return n;


		}
	public void reverseIterative(Node head){
		Node currNode = head;
		Node nextNode = null;
		Node prevNode = null;

		while(currNode!=null){
			nextNode = currNode.next;
			currNode.next = prevNode;
			prevNode = currNode;
			currNode = nextNode;
		}
		head = prevNode;
		System.out.println("\n Reverse Through Iteration");
		display(head);
	}
/// merge two link list in alternate position
	public void alterMerge(Node a, Node b) {
		Node temp = a;// it will be needed to get the head of the new list
		while (a != null && b != null) {
			Node a1 = a.next;
			Node b1 = b.next;
			a.next = b;
			b.next = a1;
			a = a1;
			b = b1;
		}
		System.out.println("\nAlternate Mergred List");
		display(temp);
		System.out.println("\nRemaining Second List");
		display(b);// b will be pointing to the ahead of the remaining list

	}
	
	
	
	
	//// merge two sorted linklist
	
	public LinkedListT mergeWithOutRecur(Node a , Node b) {
		LinkedListT result = new LinkedListT();
		while (a != null && b != null) {
			// System.out.println(a.head.data + " " + b.head.data);
			if (a.data < b.data) {
				result.addAtBegin(a.data);
				a = a.next;
			} else {
				result.addAtBegin(b.data);
				b = b.next;
			}
		}
		while (a != null) {
			result.addAtBegin(a.data);
			a = a.next;
		}
		while (b != null) {
			result.addAtBegin(b.data);
			b = b.next;
		}
		return result;
	}

	public void reverseRecursion(Node ptrOne,Node ptrTwo, Node prevNode){
		if(ptrTwo!=null){
				if(ptrTwo.next!=null){
					Node t1 = ptrTwo;
					Node t2 = ptrTwo.next;
					ptrOne.next = prevNode;
					prevNode = ptrOne;
					reverseRecursion(t1,t2, prevNode);
				}
				else{
					ptrTwo.next = ptrOne;
					ptrOne.next = prevNode;
					System.out.println("\n Reverse Through Recursion");
					display(ptrTwo);
				}
		}
		else if(ptrOne!=null){
			System.out.println("\n Reverse Through Recursion");
			display(ptrOne);
		}
	}

	public void display(Node head){
		//
		Node currNode = head;
		while(currNode!=null){
			System.out.print("->" + currNode.data);
			currNode=currNode.next;
		}
	}
}
