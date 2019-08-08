package com.ola;

public class CircularLinkedList {

    public int size =0;
    public Node9 head=null;
    public Node9 tail=null;

    //add a new Node9 at the start of the linked list
    public void addNode9AtStart(int data){
        System.out.println("Adding Node9 " + data + " at start");
        Node9 n = new Node9(data);
        if(size==0){
            head = n;
            tail = n;
            n.next = head;
        }else{
            Node9 temp = head;
            n.next = temp;
            head = n;
            tail.next = head;
        }
        size++;
    }

    public void addNode9AtEnd(int data){
        if(size==0){
            addNode9AtStart(data);
        }else{
            Node9 n = new Node9(data);
            tail.next =n;
            tail=n;
            tail.next = head;
            size++;
        }
        System.out.println("\nNode9 " + data + " is added at the end of the list");
    }

    public void deleteNode9FromStart(){
        if(size==0){
            System.out.println("\nList is Empty");
        }else{
            System.out.println("\ndeleting Node9 " + head.data + " from start");
            head = head.next;
            tail.next=head;
            size--;
        }
    }

    public int elementAt(int index){
        if(index>size){
            return -1;
        }
        Node9 n = head;
        while(index-1!=0){
            n=n.next;
            index--;
        }
        return n.data;
    }
// find kth element from last in a link list
    public int kthByIteration(Node9 head, int k){
		if(head==null){
			return 0;
		}
		Node9 curr = head;
		while(k>0){
			curr=curr.next;
			k--;
		}
		Node9 sec = head;
		while(curr!=null){
			curr = curr.next;
			sec = sec.next;
		}
		int i  = sec.data;
		return i;
	}
    //print the linked list
    public void print(){
        System.out.print("Circular Linked List:");
        Node9 temp = head;
        if(size<=0){
            System.out.print("List is empty");
        }else{
            do {
                System.out.print(" " + temp.data);
                temp = temp.next;
            }
            while(temp!=head);
        }
        System.out.println();
    }

    //get Size
    public int getSize(){
        return size;
    }

    public static void main(String[] args) {
        CircularLinkedList c = new CircularLinkedList();
        c.addNode9AtStart(3);
        c.addNode9AtStart(2);
        c.addNode9AtStart(1);
        c.print();
        c.deleteNode9FromStart();
        c.print();
        c.addNode9AtEnd(4);
        c.print();
        System.out.println("Size of linked list: "+ c.getSize());
        System.out.println("Element at 2nd position: "+ c.elementAt(2));
    }

}

class Node9{
    int data;
    Node9 next;
    public Node9(int data){
        this.data = data;
    }
}