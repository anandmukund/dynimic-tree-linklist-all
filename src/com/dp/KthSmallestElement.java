package com.dp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;

public class KthSmallestElement {

	public int findkthSmallestElement(int[] arrA, int k) {
		k = k - 1; // since array index starts with 0
		return kSmall(arrA, 0, arrA.length - 1, k);
	}

	public int kSmall(int[] arrA, int start, int end, int k) {
		int left = start;
		int right = end;
		int pivot = start;
		while (left <= right) {
			while (left <= right && arrA[left] <= arrA[pivot])
				left++;
			while (left <= right && arrA[right] >= arrA[pivot])
				right--;
			if (left < right) {
				swap(arrA, left, right);
				left++;
				right--;
			}
		}
		swap(arrA, pivot, right);
		if (pivot == k)
			return arrA[pivot];// if pivot is kth element , return
		else if (pivot < k)
			// if pivot is less than k, then kth element will be on the right
			return kSmall(arrA, pivot + 1, end, k);
		else
			// if pivot is greater than k, then kth element will be on the right
			return kSmall(arrA, start, pivot - 1, k);
	}

	public void swap(int[] arrA, int a, int b) {
		int x = arrA[a];
		arrA[a] = arrA[b];
		arrA[b] = x;
	}
//Input Array : 2 6 9 1 4 4 2 1 10 13 5 7 8

//DefinedArray : 1 2 4 6

 //Output : 1 1 2 2 4 4 6 5 7 8 9 10 13
	public int [] usingHashing(int [] arrA, int [] arrB){
		//Insert all the elements of arrA in hash Table,
		//Element as key and its count as its value
		//Navigate through arrB, check element's presence in Hash table
		//if it is present then takes its value (count) and insert into arrA.
		//Once arrB is completed, take rest of the elements from Hash table
		// Sort Them and insert into arrB.
		int resIndex = -1;
		Hashtable<Integer, Integer> h = new Hashtable<>();
		for(int i=0;i<arrA.length;i++){
			if(h.containsKey(arrA[i])){
				int count = h.get(arrA[i]);
				count++;
				h.put(arrA[i], count);
			}else{
				h.put(arrA[i], 1);
			}
		}
		for(int i=0;i<arrB.length;i++){
			if(h.containsKey(arrB[i])){
				int count  = h.get(arrB[i]);
				while(count>0){
					arrA[++resIndex] = arrB[i];
					count--;
				}
				h.remove(arrB[i]);
			}
		}
		ArrayList<Integer> al = new ArrayList<Integer>();
		Set<Integer> keys = h.keySet();
		for(Integer x:keys){
			al.add(x);
		}
		Collections.sort(al);
		Iterator<Integer> it = al.iterator();
		while(it.hasNext()){
			arrA[++resIndex] = it.next();
		}
		return arrA;
	}
	public void displayArray(int [] b){
		for(int i=0;i<b.length;i++){
			System.out.print(" " + b[i]);
		}
	}

	public static void main(String args[]) {
		int[] arrA = { 2, 3, 11, 16, 27, 4, 15, 9, 8 };
		KthSmallestElement k = new KthSmallestElement();
		int a = 4;
		int x = k.findkthSmallestElement(arrA, a);
		System.out.print("The " + a + "th smallest element is : " + x);
	}
}