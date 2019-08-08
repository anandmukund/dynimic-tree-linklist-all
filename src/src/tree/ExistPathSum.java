package src.tree;

public class ExistPathSum {
	String path;
	public void hasPath(Node2 root, int sum, String path){
		if(root!=null){
			if(root.data>sum){ // if root is greater than Sum required, return
				return;
			}else{
				path+=" " + root.data; //add root to path
				sum=sum-root.data; // update the required sum
				if(sum==0){ //if sum required =0, means we have found the path
					System.out.println(path);
				}
				hasPath(root.left, sum, path);
				hasPath(root.right, sum, path);
			}			
		}
	}
	public static void main(String[] args) {
		Node2 root = new Node2(1);
		root.left = new Node2(2);
		root.right = new Node2(3);
		root.left.left = new Node2(7);
		root.left.right = new Node2(5);
		root.right.left = new Node2(6);
		root.right.right = new Node2(7);
		
		ExistPathSum i = new ExistPathSum();
		i.hasPath(root, 10, "");
	}

}

class Node2 {
	int data;
	Node2 left, right;

	public Node2(int data) {
		this.data = data;
	}
}