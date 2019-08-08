package src.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class MakeTreefromInorderAndPreorder {
	public static int pIndex=0;
	public Node makeBTree(int [] inOrder, int [] preOrder, int iStart, int iEnd ){
		if(iStart>iEnd){
			return null;
		}
		Node root = new Node(preOrder[pIndex]);pIndex++;

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
	public void printINORDER(Node root){
		if(root!=null){
			printINORDER(root.left);
			System.out.print("  " + root.data);
			printINORDER(root.right);
		}
	}
	// sum of each leval of a string
	static Node newRoot;

	public int SumTree(Node root){
		if(root!=null){
			int left = SumTree(root.left);//take the left tree sum
			int right = SumTree(root.right);//take the right tree sum
			int retData = root.data+left+right; // return data left+right+root
			root.data = left+right; //update the root with left + right
			newRoot = root; //update the new root
			return retData; //return 
		}
		return 0;
	}
	//DFS 
	
	public void DFS(Node root) {
		Stack<Node> s = new Stack<Node>();
		s.add(root);
		while (s.isEmpty() == false) {
			Node x = s.pop();
			if(x.right!=null) s.add(x.right);
			if(x.left!=null) s.add(x.left);			
			System.out.print(" " + x.data);
		}
	}
	
	//BFS
	public void levelOrderQueue(Node root) {
		Queue<Node> q = new LinkedList<Node>();
		if (root == null)
			return;
		q.add(root);
		while (!q.isEmpty()) {
			Node n = (Node) q.remove();
			System.out.print(" " + n.data);
			if (n.left != null)
				q.add(n.left);
			if (n.right != null)
				q.add(n.right);
		}
	}
	public static void main (String[] args) throws java.lang.Exception
	{
		int [] inOrder = {2,5,6,10,12,14,15};
		int [] preOrder = {10,5,2,6,14,12,15};
		MakeTreefromInorderAndPreorder  i = new MakeTreefromInorderAndPreorder();
		Node x = i.makeBTree(inOrder, preOrder, 0, inOrder.length-1);
		System.out.println("Constructed Tree : ");
		i.printINORDER(x);
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