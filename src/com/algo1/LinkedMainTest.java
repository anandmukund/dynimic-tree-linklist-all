package com.algo1;



public class LinkedMainTest {
	public static void main(String args[]) { //creating LinkedList with 5 elements including head
		/*LinkedList linkedList = new LinkedList(); 
		linkedList.appendIntoTail(new LinkedList.Node("101"));
		linkedList.appendIntoTail(new LinkedList.Node("201")); 
		linkedList.appendIntoTail(new LinkedList.Node("301"));
		linkedList.appendIntoTail(new LinkedList.Node("401")); 
		System.out.println("Linked List : " + linkedList); 
		if(linkedList.isCyclic()){ 
			System.out.println("Linked List is cyclic as it contains cycles or loop");
			}else{ 
				
				System.out.println("LinkedList is not cyclic, no loop or cycle found"); } } 
	
	*/
	
	LinkedList1 linkedList = new LinkedList1(); 
	linkedList.appendIntoTail(new LinkedList1.Node("101"));
	LinkedList1.Node cycle = new LinkedList1.Node("201");
	linkedList.appendIntoTail(cycle);
	linkedList.appendIntoTail(new LinkedList1.Node("301"));
	linkedList.appendIntoTail(new LinkedList1.Node("401")); 
	linkedList.appendIntoTail(cycle); //don't call toString method in case of cyclic linked list, it will throw OutOfMemoryError //
	System.out.println("Linked List : " + linkedList); 
	if(linkedList.isCyclic()){
		System.out.println("Linked List is cyclic as it contains cycles or loop");
		
	}else{ System.out.println("LinkedList is not cyclic, no loop or cycle found"); } 
	}
	}


