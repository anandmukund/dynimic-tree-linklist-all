package com.ola;

public class DoublyLinkedList {

    int size =0;
    Node6 head = null;
    Node6 tail = null;

    public Node6 addAtStart(int data){
        System.out.println("Adding Node6 " + data + " at the start");
        Node6 n = new Node6(data);
        if(size==0){
            head = n;
            tail = n;
        }else{
            n.next = head;
            head.previous = n;
            head = n;
        }
        size++;
        return n;
    }

    public Node6 addAtEnd(int data){
        System.out.println("Adding Node6 " + data + " at the End");
        Node6 n = new Node6(data);
        if(size==0){
            head = n;
            tail = n;
        }else{
            tail.next = n;
            n.previous = tail;
            tail =n;
        }
        size++;
        return n;
    }

    public Node6 addAfter(int data, Node6 prevNode6){
        if(prevNode6==null){
            System.out.println("Node6 after which new Node6 to be added cannot be null");
            return null;
        }else if(prevNode6==tail){//check if it a last Node6
            return addAtEnd(data);
        }else{
            System.out.println("Adding Node6 after "+ prevNode6.data);
            //create a new Node6
            Node6 n = new Node6(data);

            //store the next Node6 of prevNode6
            Node6 nextNode6 = prevNode6.next;

            //make new Node6 next points to prevNode6
            n.next = nextNode6;

            //make prevNode6 next points to new Node6
            prevNode6.next = n;

            //make nextNode6 previous points to new Node6
            nextNode6.previous = n;

            //make  new Node6 previous points to prevNode6
            n.previous = prevNode6;
            size++;
            return n;
        }
    }

    public void deleteFromStart(){
        if(size==0){
            System.out.println("\nList is Empty");
        }else{
            System.out.println("\ndeleting Node6 " + head.data + " from start");
            head = head.next;
            size--;
        }
    }

    public void deleteFromEnd(){
        if(size==0){
            System.out.println("\nList is Empty");
        }else if(size==1){
            deleteFromStart();
        }else{
            //store the 2nd last Node6
            int x = tail.data;
            Node6 prevTail = tail.previous;

            //detach the last Node6
            tail = prevTail;
            tail.next=null;
            System.out.println("\ndeleting Node6 " + x + " from end");
            size--;
        }
    }
//
    public Node6 reverseDLL(){
		Node6 current = head;
		Node6 temp = null;
		while(current!=null){
			temp = current.previous;   //swap the next and prev pointer
			current.previous = current.next;
			current.next = temp;
			current = current.previous;
		}
		return temp.previous;
	}
    public int elementAt(int index){
        if(index>size){
            return -1;
        }
        Node6 n = head;
        while(index-1!=0){
            n=n.next;
            index--;
        }
        return n.data;
    }

    //get Size
    public int getSize(){
        return size;
    }

    public void print(){
        Node6 temp = head;
        System.out.print("Doubly Linked List: ");
        while(temp!=null){
            System.out.print(" " + temp.data);
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        DoublyLinkedList d = new DoublyLinkedList();
        Node6 x = d.addAtStart(2);
        d.addAtStart(1);
        d.print();
        d.addAtEnd(3);
        d.print();
        d.addAfter(4,x);
        d.print();
        d.deleteFromStart();
        d.print();
        d.reverseDLL();
        System.out.println("Element at index 2: "+d.elementAt(2));
        d.addAtStart(1);
        d.print();
        d.deleteFromEnd();
        d.print();
        System.out.println("Size of the Linked List: " + d.getSize());
    }
}
class Node6{
    int data;
    Node6 next;
    Node6 previous;
    public Node6(int data){
        this.data = data;
        next = null;
        previous = null;
    }
}
