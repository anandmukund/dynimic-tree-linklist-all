package com.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinJumpToReachEnd {

    public int minJump(int arr[],int result[]){
        
        int []jump = new int[arr.length];
        jump[0] = 0;
        for(int i=1; i < arr.length ; i++){
            jump[i] = Integer.MAX_VALUE-1;
        }
        
        for(int i=1; i < arr.length; i++){
            for(int j=0; j < i; j++){
                if(arr[j] + j >= i){
                    if(jump[i] > jump[j] + 1){
                        result[i] = j;
                        jump[i] = jump[j] + 1;
                    }
                }
            }
        }
        
        return jump[jump.length-1];
    }

    /**
     * https://leetcode.com/problems/jump-game-ii/
     */
    public int jump(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        int count = 0;
        int i = 0;
        while (i + nums[i] < nums.length - 1) {
            int maxVal = 0;
            int maxValIndex = 0;
            for (int j = 1; j <= nums[i]; j++) {
                if (nums[j + i] + j > maxVal) {
                    maxVal = nums[j + i] + j;
                    maxValIndex = i + j;
                }
            }
            i = maxValIndex;
            count++;
        }
        return count + 1;
    }
    //my
    public static int minJump(int[] a , int size , int mi , int mx , int count ){

		 if (mx >= size){
			 return count;
		 }
		 int maxV = a[mi] + mi;
		 int index =mi;
		 for(int i = mi ; i <mx ; i++) {
			 if(i + a[i] == size ){
				 maxV =  a[i];
			     index = i;
				 break;
			 } 
			 if(maxV < a[i] + i){
				 maxV = a[i];
				 index =i;
				 break;
			 }

		 }

		 return minJump(a ,  size , index+1 , index+1 + maxV ,  ++count );

	 }
    
    public static int CompatibilityChecker(int[] first, int[] second)
    {
    	int relativeDifference = 0;
    	for (int i = 0; i < first.length; i++)
    	{
    		if (first[i] != second[i])
    		{
    			int j = i + 1;
    			while (first[i] != second[j])
    			{
    				j++;
    			}
    			while (j != i)
    			{
    				Swap(second, j, j - 1);
    				j--;
    				relativeDifference++;
    			}

    		}
    	}
    	return relativeDifference;
    }
    private static void Swap(int[] ip , int no , int no1){
    	
    	int temp = ip[no];
    	ip[no] = ip[no1];
    	ip[no1] = temp;
    }
    public static void main(String args[]){
    	int[] o = {3,1,2,4,5};
    	int[] o1 = {3,2,4,1,5};
    	int pp = CompatibilityChecker(o, o1);
    	List<String> ls = new ArrayList<String>();
        MinJumpToReachEnd mj = new MinJumpToReachEnd();
        int arr[] = {1,3,5,3,2,2,6,1,6,8,9};
        int r[] = new int[arr.length];
        int result = mj.minJump(arr,r);
        System.out.println(result);
        int i = arr.length-1;
        Arrays.toString(r);
        int arr1[] = {2,3,1,1,4};
        System.out.print(mj.jump(arr));
    }
}