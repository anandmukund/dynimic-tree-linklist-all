package com.linklist;

public class PALINO1 {

	
	ListNode left;
	 
    public boolean isPalindrome(ListNode head) {
        left = head;
 
        boolean result = helper(head);
        return result;
    }
 
    public boolean helper(ListNode right){
 
        //stop recursion
        if (right == null)
            return true;
 
        //if sub-list is not palindrome,  return false
        boolean x = helper(right.next);
        if (!x)
            return false;
 
        //current left and right
        boolean y = (left.val == right.val);
 
        //move left to next
        left = left.next;
 
        return y;
    }
   //  delete node  value greater than X 
    static ListNode removeNodes(ListNode list, int x) {
        if (list == null) return null;
        ListNode helper = new ListNode(0);
        helper.next = list;
        ListNode p = helper;

        while(p.next != null){
          if(p.next.val > x){
    	   ListNode next = p.next;
           p.next = next.next; 
         }else{
           p = p.next;
       }
   }

   return helper.next;
        
   }
    
    
}

class ListNode{
	public ListNode(int i) {
		// TODO Auto-generated constructor stub
	}
	ListNode next;
	int val;
}
