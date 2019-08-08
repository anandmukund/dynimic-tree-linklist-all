package src.tree;
import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;

public class TreeViewLeftRightTopBottom {
	public static int currentLevel =0;
	//left view 
	public void leftViewRecur(Node root, int nextLevel){
		if(root==null) return;
		if(currentLevel<nextLevel){
			System.out.print ("  " + root.data);
			currentLevel = nextLevel;
		}
		leftViewRecur(root.left,nextLevel+1);
		leftViewRecur(root.right,nextLevel+1);
	}

	// Right view 

	public void rightViewRecur(Node root, int nextLevel){
		if(root==null) return;
		if(currentLevel<nextLevel){
			System.out.print ("  " + root.data);
			currentLevel = nextLevel;
		}
		rightViewRecur(root.right,nextLevel+1);
		rightViewRecur(root.left,nextLevel+1);
	}

	//Bottom view 

	public static TreeMap<Integer, Integer> ht = new TreeMap<>();;

	public static void bottomView(Node root, int level) {
		if (root == null)
			return;
		// create a queue for level order traversal
		Queue<QueuePack> queue = new LinkedList<>();
		// add root with level 0 (create a queue item pack)
		queue.add(new QueuePack(level, root));
		while (!queue.isEmpty()) {
			QueuePack q = queue.remove();
			// take out the items from the package
			Node tnode = q.tnode;
			int lvl = q.level;

			// keep updating the Map so that it will have the last entry from
			// each level(vertically) and that will the bottom view of the tree
			ht.put(lvl, tnode.data);

			// add the left and right children of visiting nodes to the queue
			if (tnode.left != null) {
				queue.add(new QueuePack(lvl - 1, tnode.left));
			}
			if (tnode.right != null) {
				queue.add(new QueuePack(lvl + 1, tnode.right));
			}
		}

	}

	// Top view 

	public void topView(Node root, int level) {
		if (root == null)
			return;
		// create a queue for level order traversal
		Queue<QueuePack> queue = new LinkedList<>();
		// add root with level 0 (create a queue item pack)
		queue.add(new QueuePack(level, root));
		while (!queue.isEmpty()) {
			QueuePack q = queue.remove();
			// take out the items from the package
			Node tnode = q.tnode;
			int lvl = q.level;

			// check if this is the first node you are visiting at the level
			if (ht.containsKey(lvl)) {

			} else {// print it, its the first element at his level
				System.out.print(tnode.data + "   ");
				ht.put(lvl, tnode.data);
			}

			// add the left and right children of visiting nodes to the queue
			if (tnode.left != null) {
				queue.add(new QueuePack(lvl - 1, tnode.left));
			}
			if (tnode.right != null) {
				queue.add(new QueuePack(lvl + 1, tnode.right));
			}
		}

	}

	//  print node b/w two given label
	public static int currLevel = 1;
	public void levelOrderQueue(Node root, int low, int high){
		Queue q = new LinkedList();
		int levelNodes =0;
		if(root==null) return;
		q.add(root);

		while(!q.isEmpty()){
			levelNodes = q.size();
			while(levelNodes>0){
				Node n = (Node)q.remove();
				if(currLevel>=low && currLevel<=high){
					System.out.print(" " + n.data);
				}
				if(n.left!=null) q.add(n.left);
				if(n.right!=null) q.add(n.right);
				levelNodes--;
			}
			if(currLevel>=low && currLevel<=high){
				System.out.println("");
			}
			currLevel++;
		}

	}
	// tree with preorder given data
	int pIndex = 0;
	public Node constructTree(int[] preorder, int data, int min, int max) {
		if (pIndex < preorder.length) {
			if (preorder[pIndex] > min && preorder[pIndex] < max) {
				Node root = new Node(data);
				pIndex++;
				if (pIndex < preorder.length) {
					// nodes lies between min and data will create left subtree
					root.left = constructTree(preorder, preorder[pIndex], min,
							data);
					// nodes lies between data and max will create right subtree
					root.right = constructTree(preorder, preorder[pIndex],
							data, max);
				}
				return root;
			}
		}
		return null;
	}
	
	// mirror image of a tree check
	
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
	
	// Convert a given tree to mirror tree
	
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
	
	// kth samllest element in a binary search tree
	
	static int temp=0;
	void inorder1(Node nod, int k){
	if(nod==null){
	return;
	}
	inorder1( nod.left, k);
	temp=temp+1;
	if( temp==k){
	System.out.println( nod.data);
	}
	inorder1( nod.right, k);

	}
	
	// smallest no in a binary tree

	int minvalue(Node node) {
        Node current = node;
 
        /* loop down to find the leftmost leaf */
        while (current.left != null) {
            current = current.left;
        }
        return (current.data);
    }
	
	// kth largest
	
	     static int count = 0;
	 static void kthLargestUtil(NodeFOR node,int k)
	 {   
	     // Base cases, the second condition is important to
	     // avoid unnecessary recursive calls
	     if (node == null || count >= k)
	         return;
	          
	     // Follow reverse inorder traversal so that the
	     // largest element is visited first
	     kthLargestUtil(node.right,k); 
	      
	      // Increment count of visited nodes
	     count++;
	      
	     // If c becomes k now, then this is the kth largest
	     if (count == k) {
	         System.out.print(k + " largest element is "+
	                                           node.data);
	         return;
	     }
	      
	      // Recur for left subtree
	     kthLargestUtil(node.left,k); 
	 }
	 
}




/*class Node {
	int data;
	Node left;
	Node right;

	public Node(int data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}
}*/
class QueuePack {
	int level;
	Node tnode;

	public QueuePack(int level, Node tnode) {
		this.level = level;
		this.tnode = tnode;
	}
}