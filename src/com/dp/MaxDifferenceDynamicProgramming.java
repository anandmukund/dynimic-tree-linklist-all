package com.dp;
/*
 * int [] A = { 2, 5, 1, 7, 3, 9, 5};
   Maximum Difference between two elements A[i] and A[j] and where j > i: 8
   int [] A = { 22,2, 12, 5, 4, 7, 3, 19, 5};
   Maximum Difference between two elements A[i] and A[j] and where j > i: 17
 */


public class MaxDifferenceDynamicProgramming {
	//n2
	public static int maxDifferenceRecur(int [] A){
        int maxDiff = -1;
        for (int i = 0; i <A.length ; i++) {
            for (int j = i; j <A.length ; j++) {
                if(A[j]>A[i] && (A[j]-A[i]>maxDiff))
                    maxDiff = A[j]-A[i];
            }
        }
        return maxDiff;
    }
	//n
    public static int maxDifferenceDP(int [] A){
        int size = A.length;
        int maxDiff = -1;
        int max_so_far = A[size-1]; //assign the last element
        for (int i = size - 2 ; i >0 ; i--) {
            if(max_so_far<A[i])
                max_so_far = A[i];
            else if(max_so_far>A[i])
                maxDiff = Math.max(maxDiff,max_so_far-A[i]);
        }
        return maxDiff;
    }
//nlogn
    public int maxDifferenceDivideAndCon(int [] A, int start, int end){
        if(start>=end){
            return -1;
        }
        int mid = start +  (end-start)/2;
        int leftDiff = maxDifferenceDivideAndCon(A,start,mid);
        int rightDiff = maxDifferenceDivideAndCon(A,mid+1,end);
        int minLeft = getMin(A, start, mid);
        int maxRight = getMax(A, mid, end);
        int centerDiff = maxRight - minLeft;
        return Math.max(centerDiff, Math.max(leftDiff,rightDiff));
    }

    public int getMin(int [] A, int i, int j){
        int min = A[i];
        for (int k = i+1; k <=j ; k++) {
            if(A[k]<min)
                min = A[k];
        }
        return min;
    }
    public int getMax(int [] A, int i, int j){
        int max = A[i];
        for (int k = i+1; k <=j ; k++) {
            if(A[k]>max)
                max = A[k];
        }
        return max;
    }

    public static void main(String[] args) {
        int [] A = { 12, 5, 1, 7, 3, 9, 5};
        System.out.println("Maximum Difference between two elements A[i] and A[j] and where j > i: " + maxDifferenceDP(A));
    }
}