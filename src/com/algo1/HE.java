package com.algo1;

import java.util.Arrays;


public class HE {
	
	
	public static int[] tr(int[] a , int n , int k){
		
		for(int i = 0 ; i < k ; i++){
			int t = a[0];
				a= Arrays.copyOfRange(a, 1, a.length);
				    int[] array3 = new int[ a.length + 1 ];
				    int[] tt = {t};
				    System.arraycopy( a, 0, array3, 0, a.length );
				    System.arraycopy( tt, 0, array3, a.length, tt.length );
				
				
				a = array3;
			}
		
		return a;
	}
public static boolean solve(String book , String re,int bn, int rn){
		boolean result = false;
		String[] bookList = book.split(" ");
		String[] reList = book.split(" ");
		return result;
	}
	
	public static void main(String s[]){
		int[] a = {1,2,3,4,5};
		int[] r = tr(a , 5 ,3);
		for(int i = 0; i < r.length ; i++){
		System.out.println(r[i]);
		}
	}
}