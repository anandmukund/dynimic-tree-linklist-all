package com.algo;

//Java program to sort an array of 0, 1 and 2
import java.io.*;

class countzot {

 // Sort the input array, the array is assumed to
 // have values in {0, 1, 2}
 static void sort012(int a[], int arr_size)
 {
     int lo = 0;
     int hi = arr_size - 1;
     int mid = 0,temp=0;
     while (mid <= hi)
     {
         switch (a[mid])
         {
         case 0:
         {
             temp   =  a[lo];
             a[lo]  = a[mid];
             a[mid] = temp;
             lo++;
             mid++;
             break;
         }
         case 1:
             mid++;
             break;
         case 2:
         {
             temp = a[mid];
             a[mid] = a[hi];
             a[hi] = temp;
             hi--;
             break;
         }
         }
     }
 }

 
 static void sort012_1(int[] a , int size){

	 int onecount = 0 ;
	 int twocount = 0; 
	 for(int i = 0 ; i < size ; i++){

		 if(a[i] == 0){
			 if(onecount > 0 || twocount > 0){

				 int temp = a[i];
				 int count = onecount + twocount;

				 if(a[i-count] == 2){
					 a[i] =a[i-count] ;
					 a[i-count] = temp;
				 } else {
					 a[i] =a[i-count] ;
					 a[i-count] = temp;
					 int temp2 =  a[i-twocount];
					 a[i-twocount] = a[i];
					 a[i] = temp2;
				 }
			 }
			 continue;
		 }
		 if(a[i] == 1){
			 int temp2 =  a[i-twocount];
			 a[i-twocount] = a[i];
			 a[i] = temp2;
			 onecount++;
			 continue;
		 }
		 if(a[i] == 2){
			 twocount++;
			 continue;
		 }
	 }

 }
 /* Utility function to print array arr[] */
 static void printArray(int arr[], int arr_size)
 {
     int i;
     for (i = 0; i < arr_size; i++)
         System.out.print(arr[i]+" ");
     System.out.println("");
 }

 /*Driver function to check for above functions*/
 public static void main (String[] args)
 {
     int arr[] = {0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1};
     int arr_size = arr.length;
     sort012_1(arr, arr_size);
     sort012(arr, arr_size);
     System.out.println("Array after seggregation ");
     printArray(arr, arr_size);
 }
}
/*This code is contributed by Devesh Agrawal*/