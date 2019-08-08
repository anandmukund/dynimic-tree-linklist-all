package com.eim.dh.solrsearch;

import java.util.LinkedList;
import java.util.Queue;

class Node {
	 
    int data;
    Node left, right;
 
    Node(int item) {
        data = item;
        left = right = null;
    }
}
 
// class to access maximum level by reference
class Max_level {
 
    int max_level;
}
 
class BinaryTree {
 
    Node root;
    Max_level max = new Max_level();
 
    // Recursive function to print right view of a binary tree.
    void rightViewUtil(Node node, int level, Max_level max_level) {
 
        // Base Case
        if (node == null) 
            return;
 
        // If this is the last Node of its level
        if (max_level.max_level < level) {
            System.out.print(node.data + " ");
            max_level.max_level = level;
        }
 
        // Recur for right subtree first, then left subtree
        rightViewUtil(node.right, level + 1, max_level);
        rightViewUtil(node.left, level + 1, max_level);
    }
 
    void rightView()
    {
    	//levelOrderTraversal(root);
        rightView(root);
    }
 
    // A wrapper over rightViewUtil()
    void rightView(Node node) {
 
        rightViewUtil(node, 1, max);
    }
 
    public static  void printData(Node node , Node leftChild ){

	    
  	   if(node != null ) {
  	       if(node.right != null){
  	         System.out.println(node.data);
  	         
  	          printData(node.right , node.left);
  	       } else {
  	          
  	          if(leftChild!= null){
  	          if(leftChild.right != null){
  	        	  System.out.println(leftChild.right.data);
  	             printData(leftChild .right , leftChild .left);
  	          } else {
  	        	 System.out.println(leftChild .left.data);
  	           printData(leftChild .left, null);
  	          
  	          }
  	          }}}     
  	       
  	       
  	  
  	}
    
    // Driver program to test the above functions
    public static void main(String args[]) {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.left.left = new Node(4);
        tree.root.left.left.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);
        tree.root.right.left.right = new Node(8);
        tree.root.left.left.left.left.left = new Node(19);
         
        tree.rightView();
 
        }
}