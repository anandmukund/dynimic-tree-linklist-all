package com.algo1;

public class MaxSum {
	public static int  contiguousSubArrayWithLargestsum(int a[], int size){
		 
	    int startIndex = 0, endIndex = 0;
	    int index;
	    int currStartIndex = 0;
	 
	    int maxSum = 0;
	    int currentSum = 0;
	 
	    for(index = 0 ; index < size; index++){
	        currentSum  = currentSum + a[index];
	        // case 1 : When ith element can be included
	        // Change the end index and also update the start index.
	        if(currentSum > maxSum){
	            maxSum = currentSum;
	            endIndex = index;
	            startIndex = currStartIndex;
	        }
	        /*case 2 : When ith index cannot be included and 
	        we need to start with i+1 index. till now our max sum
	        and start and end index of that sum remain same */
	        if(currentSum < 0){
	            currStartIndex = index + 1;
	            currentSum = 0;
	        }
	    }
	    return maxSum;
	}
	public static int KandaneModify(int[] arrA) {
		int max_end_here = arrA[0];
		int max_so_far = arrA[0];
		for(int i=1;i<arrA.length;i++){
			max_end_here = Math.max(arrA[i], max_end_here+arrA[i]);
			max_so_far = Math.max(max_so_far,max_end_here);
		}
		return max_so_far;
	}
	public static void main (String as[]){
		int[] a = {3,3,37,-9,3,55,};
		System.out.println(contiguousSubArrayWithLargestsum(a, a.length));
	}
}
