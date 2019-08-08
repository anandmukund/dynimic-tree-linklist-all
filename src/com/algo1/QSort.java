package com.algo1;

public class QSort {

	static  int count = 0;
	public static int  quickSort(int[] arr, int low, int high) {
		if (arr == null || arr.length == 0)
			return 0;
 
		if (low >= high)
			return 0;
 
		// pick the pivot
		int middle = low + (high - low) / 2;
		int pivot = arr[middle];
 
		// make left < pivot and right > pivot
		int i = low, j = high;
		while (i <= j) {
			while (arr[i] < pivot) {
				i++;
			}
 
			while (arr[j] > pivot) {
				j--;
			}
 
			if (i <= j) {
				count++;
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				i++;
				j--;
			}
		}
 
		// recursively sort two sub parts
		if (low < j)
			quickSort(arr, low, j);
 
		if (high > i)
			quickSort(arr, i, high);
		
		return count;
	}
	
	public static void main(String sd[]){
		int[] a = {2, 4, 1, 3, 5 };
		int ss = quickSort(a, 0, 4);
		
		int p =  ss - 1;
		int y = (p+1)*p;
		System.out.println(y/2);
	}
}

