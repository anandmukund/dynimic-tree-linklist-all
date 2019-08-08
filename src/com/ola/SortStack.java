package com.ola;

import java.util.Stack;

public class SortStack {
	void StackSort( Stack S )
	{
	    
	    if(  S.isEmpty() )
	     return;
	     
	    int X=(int) S.peek();
	    S.pop();
	    
	    StackSort( S );
	    Insert( X , S );
	    
	}

	void Insert( int X , Stack S ) 
	{
	    if( S.isEmpty()  )
	     {
	          S.push( X );
	          return;
	          
	          }
	          
	     if( X > (int)S.peek() )
	      {
	           int t=(int) S.peek();
	           S.pop();
	           
	           Insert( X , S );
	           S.push( t );
	           
	           }
	           
	     else
	      {
	           S.push( X );
	           return;
	           
	           }
	           
	           
	}
	
	//max sum in array by selecting non adjusent elements
	
	public int getMaxSumNonAdjacent(int[] arr, int curIndex){
		if(curIndex > arr.length-1){
		return 0;
		}
		int frst = arr[curIndex] + getMaxSumNonAdjacent(arr,curIndex +2);
		int second = getMaxSumNonAdjacent(arr,curIndex +1);
		return Math.max(frst,second);

		}
	
	public static void main(String[] args) {
		
		int [] ar = {10,2,5,6};
		SortStack s = new SortStack();
		System.out.println(s.getMaxSumNonAdjacent(ar, 0));
    }
}
