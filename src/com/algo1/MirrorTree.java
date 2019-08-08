package com.algo1;

public class MirrorTree {
	public void mirror(Node root){
		print(root);
		Node x = mirrorTree(root);
		System.out.print("\n Mirror Image ");
		print(x);
	}
	public boolean checkMirror(Node root1, Node root2) {
		if (root1 == null && root2 == null) {
			return true;
		}
                if(root1.data !=root2.data){
                        return false;
                }

		if ((root1 == null && root2 != null)
				|| (root1 != null && root2 == null)) { // if any node doesn't
			// have corresponding node in the another tree, return false
			return false;
		}
		// check if left node in one tree is the right node in another tree, and
		// vice versa
		return checkMirror(root1.left, root2.right)
				&& checkMirror(root1.right, root2.left);

	}
	public Node mirrorTree(Node root){
		if(root!=null){
			Node t = root.left;
			root.left = root.right;
			root.right = t;
			mirrorTree(root.right);
			mirrorTree(root.left);
		}
		return root;
	}
	public void print(Node root){
		if(root!=null){
			print(root.left);
			System.out.print("" + root.data);
			print(root.right);
		}
	}
	public static void main (String[] args) throws java.lang.Exception
	{
		Node root = new Node(4);
		root.left = new Node(2);
		root.right = new Node(6);
		root.left.left = new Node(1);
		root.left.right = new Node(3);
		root.right.left = new Node(5);
		root.right.right = new Node(7);

		MirrorTree i  = new MirrorTree();
		i.mirror(root);
	}
}
class Node{
	int data;
	Node left;
	Node right;
	public Node(int data){
		this.data = data;
		this.left = null;
		this.right =null;
	}
}