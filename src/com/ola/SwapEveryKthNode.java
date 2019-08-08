package com.ola;

public class SwapEveryKthNode {	
	public static void main (String[] args) throws java.lang.Exception
	{
		LinkedListT a = new LinkedListT();
		a.addAtBegin(10);
		a.addAtBegin(9);
		a.addAtBegin(8);
		a.addAtBegin(7);
		a.addAtBegin(6);
		a.addAtBegin(5);
		a.addAtBegin(4);
		a.addAtBegin(3);
		a.addAtBegin(2);
		a.addAtBegin(1);
		System.out.print("Original Link List 1 : ");
		a.display(a.head);
		int k = 4;
		NodeLink n1 = a.swapNodeLinkRecursive(a.head);
		NodeLink n = a.reverseNodeLinks(a.head, k);
		System.out.println("\n Swap Every " + k + "th NodeLink : ");
		a.display(n);
	}
}
class NodeLink{
	public int data;
	public NodeLink next;
	public NodeLink(int data){
		this.data = data;
		this.next = null;
	}
}
class LinkedListT{
	public NodeLink head;
	public LinkedListT(){
		head=null;
	}
	public NodeLink reverseNodeLinks(NodeLink head, int k){
		int x =k;
		NodeLink ptrOne = head;
		NodeLink ptrTwo_prev = head;
		NodeLink ptrTwo = null;
		if(k<2)return head;
 		if(ptrOne!=null){
 			 ptrTwo = head.next;
 		}else return null;
 		while((x-2)>0){
			if(ptrTwo!=null){
				ptrTwo_prev = ptrTwo;
				ptrTwo = ptrTwo.next;
				x--;
			}else{
				return head;
			}			
		}
		NodeLink newHead = ptrTwo.next;
		ptrTwo_prev.next=ptrOne;
		ptrTwo.next = ptrOne.next;
		ptrOne.next = reverseNodeLinks(newHead, k);
		return ptrTwo;
	}
	
	//  alternate swap in link list
	public static NodeLink swapNodeLinkRecursive(NodeLink head){
		if(head==null || head.next==null){
			return head;
		}
			//change the link for first 2 NodeLinks and
			//make a recursive call to rest of the list.
			NodeLink ptrOne = head;
			NodeLink ptrTwo = head.next;
			NodeLink ptrTwoNext = ptrTwo.next;
			ptrTwo.next = head;
			NodeLink newhead = ptrTwo;
			ptrOne.next = swapNodeLinkRecursive(ptrTwoNext);
			return newhead;
	}
	public void addAtBegin(int data){
		NodeLink n = new NodeLink(data);
		n.next = head;
		head = n;
	}	
	public void display(NodeLink head){
		NodeLink currNodeLink = head;
		while(currNodeLink!=null){
			System.out.print("->" + currNodeLink.data);
			currNodeLink=currNodeLink.next;
		}		
	}
}