package com.test.tv;


public class PayTm {

	
	public static int pIndex=0;
	public Node makeBTree(int [] inOrder, int [] preOrder, int iStart, int iEnd ){
		if(iStart>iEnd){
			return null;
		}
		Node root = new Node(preOrder[pIndex]);
		pIndex++;

		if(iStart==iEnd){
			return root;
		}
		int index = getInorderIndex(inOrder, iStart, iEnd, root.data);
			root.left = makeBTree(inOrder,preOrder,iStart, index-1);
			root.right = makeBTree(inOrder,preOrder,index+1, iEnd);
		//}
		return root;
	}
	public int getInorderIndex(int [] inOrder, int start, int end, int data){
		for(int i=start;i<=end;i++){
			if(inOrder[i]==data){
				return i;
			}
		}
		return -1;
	}
	public static int index = 0; 
	 public void printPost(Node node,int[] va) {
		    if (node != null) {
		    	printPost(node.left,va);
		    	printPost(node.right,va);
		    	va[index]= node.data;
		    	index++;
		    }
		  }
	 
	 public int[] make(int i , int[] in , int[]pr){
		
		 Node n = makeBTree(in, pr, 0, i-1);
		 int[] r = new int[i];
		 printPost(n, r);
		 
		 return r;
	 }
	 
	 
	 
	 public static int search(int start, int end, int arr[], int x)
	    {
	        for (int i = start; i <= end; i++)
	            if (arr[i] == x)
	            return i;
	        return -1;
	    }
	 
	 static int preIndex=0;
	// Prints postorder traversal from given inorder and preorder traversals
	 
	 
	 
	    public static void printPostOrder(int inStart, int inEnd, int in[], int pre[])
	    {
	        if(inStart > inEnd){
	        	return;
	        }
	        
	        if(inStart == inEnd) {
	        	System.out.print(pre[preIndex++] + " ");
	        	return;
	        }
	        
	        int index = search(inStart, inEnd, in, pre[preIndex++]);
	        printPostOrder(inStart, index-1, in, pre);
	        printPostOrder(index+1, inEnd, in, pre);
	        System.out.print(in[index]+" ");
	    }
	 
	 
	 public static void main(String[] s){
		 
		 int[] in ={4,2,5,1,3,6};
		 int[] pr ={1,2,4,5,3,6};
		 printPostOrder(0,in.length-1, in, pr);
		 PayTm p = new PayTm();
		 p.make(6, in, pr);
		 
	 }
 
}

class Node{
	int data;
	Node left;
	Node right;
	public Node (int data){
		this.data = data;
		left = null;
		right = null;
	}
}
