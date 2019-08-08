package src.tree;

public class PrintNodesAtKDistance {
	public void print(Node root, int k) {
		if (root != null) {
			if (k == 0) {
				System.out.print(" " + root.data);
				//return;
			}
			print(root.left, --k);
			print(root.right, k);
		}
	}
	//height of a tree
	public static int treeHeight(Node root){
		if(root==null)return 0;
		return (1+ Math.max(treeHeight(root.left),treeHeight(root.right)));
	}
// print path whose sum is equal to given no
	String path;
	public void hasPath(Node root, int sum, String path){
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
	public static void main(String[] args) throws java.lang.Exception {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.left.left = new Node(7);
		root.right.left = new Node(6);
		root.right.left.left = new Node(8);
		root.right.left.right = new Node(9);
		System.out.print("Nodes at distance by 2 :");
		int treeh = treeHeight(root);
		/*Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.left.right.left = new Node(6);
		root.left.right.right = new Node(7);
		root.right.right = new Node(8);
		root.right.right.right = new Node(9);
		PrintNodesAtKDistance i = new PrintNodesAtKDistance();
		System.out.println("Nodes at 3 distance from root : ");
		i.print(root, 3);*/
		PrintNodesAtKDistance i = new PrintNodesAtKDistance();
		System.out.println("Nodes at 3 distance from root : ");
		i.print(root, 3);
	}

}