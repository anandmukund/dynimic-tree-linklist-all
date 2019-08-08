package src.tree;

//Java code to find second largest element in BST

//A binary tree node
class NodeFOR {

 int data;
 NodeFOR left, right;

 NodeFOR(int d)
 {
     data = d;
     left = right = null;
 }
}

class BinarySearchTree {

 // Root of BST
 NodeFOR root;

 // Constructor
 BinarySearchTree()
 {
     root = null;
 }

 // function to insert new nodes
 public void insert(int data)
 {
     this.root = this.insertRec(this.root, data);
 }
  
 /* A utility function to insert a new node with given 
 key in BST */
 NodeFOR insertRec(NodeFOR node, int data)
 {
     /* If the tree is empty, return a new node */
     if (node == null) {
         this.root = new NodeFOR(data);
         return this.root;
     }

     /* Otherwise, recur down the tree */
     if (data < node.data) {
         node.left = this.insertRec(node.left, data);
     } else {
         node.right = this.insertRec(node.right, data);
     }
     return node;
 }

 // class that stores the value of count
 public class count {
     int c = 0;
 }

 // Function to find 2nd largest element
 void secondLargestUtil(NodeFOR node, count C)
 {   
     // Base cases, the second condition is important to
     // avoid unnecessary recursive calls
     if (node == null || C.c >= 2)
         return;
          
     // Follow reverse inorder traversal so that the
     // largest element is visited first
     this.secondLargestUtil(node.right, C); 
      
      // Increment count of visited nodes
     C.c++;
      
     // If c becomes k now, then this is the 2nd largest
     if (C.c == 2) {
         System.out.print("2nd largest element is "+
                                           node.data);
         return;
     }
      
      // Recur for left subtree
     this.secondLargestUtil(node.left, C); 
 }
/// kth largest
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
      
     // If c becomes k now, then this is the 2nd largest
     if (count == k) {
         System.out.print(k + " largest element is "+
                                           node.data);
         return;
     }
      
      // Recur for left subtree
     kthLargestUtil(node.left,k); 
 }
 
 // Function to find 2nd largest element
 void secondLargest(NodeFOR node)
 {   
     // object of class count
     count C = new count(); 
     this.secondLargestUtil(this.root, C);
 }

 // Driver function
 
 
 /// full node- a node having left as well as right both child
 
 public void FindFullNodes(Node root) {
		// do the traversal and print all the nodes which has left and right
		// child
		if (root != null) {
			FindFullNodes(root.left);
			if (root.left != null && root.right != null) {
				System.out.print(root.data + " ");
			}
			FindFullNodes(root.right);
		}
	}
 
 
 ///max difference of ansestor 
 class Res 
 {
     int r = Integer.MIN_VALUE;
 }
 int  maxDiffUtil(Node t, Res res) 
 {
     /* Returning Maximum int value if node is not
        there (one child case)  */
     if (t == null)
         return Integer.MAX_VALUE;
       
     /* If leaf node then just return node's value  */
     if (t.left == null && t.right == null)
         return t.data;

     /* Recursively calling left and right subtree
        for minimum value  */
     int val = Math.min(maxDiffUtil(t.left, res),
             maxDiffUtil(t.right, res));

     /* Updating res if (node value - minimum value
        from subtree) is bigger than res  */
     res.r = Math.max(res.r, t.data - val);

     /* Returning minimum value got so far */
     return Math.min(val, t.data);
 }
 public static void main(String[] args)
 {
     BinarySearchTree tree = new BinarySearchTree();
      
     /* Let us create following BST
           50
        /     \
       30      70
      /  \    /  \
    20   40  60   80 */
     
     tree.insert(50);
     tree.insert(30);
     tree.insert(20);
     tree.insert(40);
     tree.insert(70);
     tree.insert(60);
     tree.insert(80);

     //tree.secondLargest(tree.root);
     kthLargestUtil(tree.root,4);
 }
}

//This code is contributed by Kamal Rawal