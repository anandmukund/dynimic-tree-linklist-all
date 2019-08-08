package com.algo1;

public class BinarytreeisSubTreeOfAnother {
	//store the inOrder and postorder traversal for both the array, 
	//if one array is the sub array of another array, that means one tree is the subtree of another one
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
	///balance tree check	
		public static int getHeight(Node root){
			if(root==null)return 0;
			return (1+ Math.max(getHeight(root.left), getHeight(root.right)));
		}
		
		// mirror tree check 
		
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
		
		
		public static boolean isBalancedNaive(Node root){
			if(root==null)return true;
			int heightdifference = getHeight(root.left)-getHeight(root.right);
			if(Math.abs(heightdifference)>1){
				return false;
			}else{
				return isBalancedNaive(root.left) && isBalancedNaive(root.right);
			}
		}
		//// balanced tree check end
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
	
	