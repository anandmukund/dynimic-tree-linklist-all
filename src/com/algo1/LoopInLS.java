package com.algo1;


public class LoopInLS {

	boolean hasLoop(Node first) {
	    Node slow = first;
	    Node fast = first;

	    while(fast != null && fast.next != null) {
	        slow = slow.next;          // 1 hop
	        fast = fast.next.next;     // 2 hops 

	        if(slow == fast)  // fast caught up to slow, so there is a loop
	            return true;
	    }
	    return false;  // fast reached null, so the list terminates
	}
	//loop Length
	public void findLoopLength(Node one, Node two){
		one = one.next;
		int loopLength = 1;
		while(one!=two){
			one = one.next;
			loopLength++;
		}
		System.out.println("Loop length is " + loopLength);
	}
	
	//  break loop
	
	public void breakLoop(Node one, Node two){
		one = one.next;
		while(one.next!=two){
			one = one.next;
		}
		one.next = null;
		System.out.println("Loop breaks");
	}
	public static class Node{
		private Node next;
		private String data;

		public Node(String data){
			this.data = data;
		}

		public String data() {
			return data;
		}

		public void setData(String data) {
			this.data = data;
		}

		public Node next() {
			return next;
		}

		public void setNext(Node next) {
			this.next = next;
		}

		public String toString(){
			return this.data;
		}
	}
}
