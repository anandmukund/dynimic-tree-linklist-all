package com.ola;

public class StackUsingLinkedList {
    Node5 head= null;
    int size =0;

    public void push(int data){
        Node5 x = new Node5(data);
        if(getSize()==0){
            head = x;
        }else{
            //add the Node5 at the start of a Linked List
            Node5 temp = head;
            x.next = temp;
            head = x;
        }
        System.out.println("Element "+ data + " is pushed into Stack");
        size++;
    }

    public int pop(){
        if(getSize()==0){
            System.out.println("Stack is Empty");
            return -1;
        }else{
            Node5 temp = head;
            head = head.next;
            size--;
            return temp.data;
        }

    }

    public void printStack(){
        Node5 curr = head;
        while(curr!=null){
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println();
    }
    public int getSize(){
        return size;
    }

    public static void main(String[] args) {
        StackUsingLinkedList stck = new StackUsingLinkedList();
        stck.push(1);
        stck.push(2);
        stck.push(4);
        stck.printStack();
        System.out.println("Pop out element " + stck.pop());
        stck.printStack();
    }
}
class Node5{
    int data;
    Node5 next;
    public Node5(int data){
        this.data = data;
    }
}