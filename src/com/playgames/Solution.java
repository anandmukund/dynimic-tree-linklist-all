package com.playgames;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Stack;
// beautiful arrangment
public class Solution {
    int count = 0;
    public int countArrangement(int N) {
        boolean[] visited = new boolean[N + 1];
        calculate(N, 1, visited);
        return count;
    }
    public void calculate(int N, int pos, boolean[] visited) {
        if (pos > N)
            count++;
        for (int i = 1; i <= N; i++) {
            if (!visited[i] && (pos % i == 0 || i % pos == 0)) {
                visited[i] = true;
                calculate(N, pos + 1, visited);
                visited[i] = false;
            }
        }
    }
    
   // ticket max value 
    static PriorityQueue<Integer> pq;
    static long maximumAmount(int[] a, long k) {
    	pq = new PriorityQueue<>(a.length, new Comparator<Integer>() {

    				@Override
    				public int compare(Integer o1, Integer o2) {
    					// TODO Auto-generated method stub
    					return o2 - o1;
    				}
    			});
    			long revenue = 0;
    			
    			for (int i = 0; i < a.length; i++) {
    				pq.offer(a[i]);
    			}

    			while (k > 0) {
    				int ticketPrice = pq.poll();
    				revenue += ticketPrice;
    				pq.offer(--ticketPrice);
    				k--;
    			}
    			return revenue;
    		}
    // delete node with value greater than x
    
   /* static LinkedListNode removeNodes(LinkedListNode list, int x) {
        if (list == null) return null;
      LinkedListNode helper = new LinkedListNode(0);
   helper.next = list;
   LinkedListNode p = helper;

   while(p.next != null){
       if(p.next.val > x){
           LinkedListNode next = p.next;
           p.next = next.next; 
       }else{
           p = p.next;
       }
   }

   return helper.next;
        
   } */
    
    // check given expression is true or not
    public static boolean isBalanced(String expression) {
    	  if ((expression.length() % 2) == 1) return false;
    	  else {
    	    Stack<Character> s = new Stack<>();
    	    for (char bracket : expression.toCharArray())
    	      switch (bracket) {
    	        case '{': s.push('}'); break;
    	        case '(': s.push(')'); break;
    	        case '[': s.push(']'); break;
    	        default :
    	          if (s.isEmpty() || bracket != s.peek()) { return false;}
    	          s.pop();
    	      }
    	    return s.isEmpty();
    	  }
    	}
    
    
   //count no of pairs 
    static int numberOfPairs(int[] a, long k) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        int result = 0;
        for (int i=0; i<a.length; i++){
        	int p = (int) (k-a[i]);
            if(hm.containsKey(a[i])){
            	int count = hm.get(a[i]);
            	result = result + 1;
            	 hm.put(p,result);
            } else {     
            hm.put(p,1);
            }
        }
 
        return result*2;
    }
	 
    
    
    
}