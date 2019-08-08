package src.tree;

public class BinarytreeisSubTreeOfAnother {
	//store the inOrder and postorder traversal for both the array, 
	//if one array is the sub array of another array, that means one tree is the subtree of another one
		
	public void inorderRecursive(Node root) {
		if (root != null) {
			inorderRecursive(root.left);
			System.out.print(root.data + " ");
			inorderRecursive(root.right);
		}
	}

	public void postOrderRecursive(Node root) {
		if (root != null) {
			postOrderRecursive(root.right);
			postOrderRecursive(root.left);
			System.out.print(root.data + " ");
		}
	}

	public void preOrderRecursive(Node root) {
		if (root != null) {
			System.out.print(root.data + " ");
			preOrderRecursive(root.left);
			preOrderRecursive(root.right);
		}
	}
	
	public String inOrder(Node root, String i){
			if(root!=null){
				return inOrder(root.left,i) + "  " + root.data + "  " +inOrder(root.right,i);
			}
			return "";
		}
		public String postOrder(Node root, String i){
			if(root!=null){
				return  postOrder(root.left,i) + "  " + postOrder(root.right,i) + "  " + root.data;
			}
			return "";
		}
		public boolean checkSubtree(Node rootA, Node rootB){
			inorderRecursive(rootA);
			String inOrderA = inOrder(rootA,"");
			String inOrderB = inOrder(rootB,"");
			String postOrderA = postOrder(rootA,"");
			String postOrderB = postOrder(rootB,"");
			return (inOrderA.toLowerCase().contains(inOrderB.toLowerCase()) && postOrderA.toLowerCase().contains(postOrderB.toLowerCase()));
		}
		public void display(Node root){
			if(root!=null){
				display(root.left);
				System.out.print(" " + root.data);
				display(root.right);
			}
		}
		/// create balanced BST from sorted array
		 Node sortedArrayToBST(int arr[], int start, int end) {
			 
		        /* Base Case */
		        if (start > end) {
		            return null;
		        }
		 
		        /* Get the middle element and make it root */
		        int mid = (start + end) / 2;
		        Node node = new Node(arr[mid]);
		 
		        /* Recursively construct the left subtree and make it
		         left child of root */
		        node.left = sortedArrayToBST(arr, start, mid - 1);
		 
		        /* Recursively construct the right subtree and make it
		         right child of root */
		        node.right = sortedArrayToBST(arr, mid + 1, end);
		         
		        return node;
		    }
		 
		public static void main (String[] args) throws java.lang.Exception
		{
			Node rootA = new Node(1);
			rootA.left = new Node(2);
			rootA.right = new Node(4);
			rootA.left.left = new Node(3); 
			rootA.right.right = new Node(6);
			rootA.right.left = new Node(5); 
			Node rootB = new Node(4);
			rootB.left = new Node(5);
			rootB.right = new Node(6); 
			BinarytreeisSubTreeOfAnother i  = new BinarytreeisSubTreeOfAnother();
			System.out.print(" Tree A : ");
			i.display(rootA);
			System.out.println();
			System.out.print(" Tree B : ");
			i.display(rootB);
			System.out.println();
			System.out.println(i.checkSubtree(rootA,rootB));
		}
	}
	
	