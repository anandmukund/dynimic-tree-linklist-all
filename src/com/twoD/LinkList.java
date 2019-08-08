package com.twoD;


public class LinkList {
	
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
	}
	
	
	
	
	
	public Node reveseGrps(Node head, int k){
		int x = k;
		Node head_next=null;
		Node h = head;
		Node head_prev = null;
		while(h!=null && x>0){
			head_next = h.next;
			h.next = head_prev;
			head_prev = h;
			h = head_next;
			x--;
		}
		if(head_next!=null){
			head.next = reveseGrps(head_next,k);
		}
		return head_prev;
		
	}
	
	public Node reverseDLL(Node head){
		Node current = head;
		Node temp = null;
		while(current!=null){
			temp = current.prev;   //swap the next and prev pointer
			current.prev = current.next;
			current.next = temp;
			current = current.prev;
		}
		return temp.prev;
	}
	
	
	 public static class Node{
	        private Node next;
	        private Node prev;// use only for doubley linklist
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
