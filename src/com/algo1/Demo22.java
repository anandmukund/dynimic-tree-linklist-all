package com.algo1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Demo22 {
	static Scanner sc = new Scanner(System.in);
	static int n = sc.nextInt();
	static int m = sc.nextInt();
	
	public static void main(String[] args) {
		String sss  = "qqq333tyt";
		System.out.println(sss.toUpperCase());
		int[][] ar;
		int count = 0;
		
		 BufferedReader inp = new BufferedReader (new InputStreamReader(System.in));
		
		ar = new int[n][m];
	
		for(int col = 0 ; col <n ; col ++){
		String[] data = null;
		try {
			data = inp.readLine().split(" ");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int j = 0;
		for (int i =0;i<data.length; i ++){
			if(j<m){
				ar[col][j]=Integer.valueOf(data[i]);
				j++;
				
			}
		}
		
	}
		System.out.println(getCount( ar));
	}
	
public static int getCount(int[][] arr){
	int count = 0 ;
	for (int i = 0 ; i <n ; i++){
		for (int j = 0 ; j <m ; j++){
			if(j!= m-1){
			if(arr[i][j] == arr [i][j+1] && arr [i][j+1] == 1){
				
				count ++;
			}
			// without daigonal 
			/*if(i>0){
				if(arr[i][j] == arr[i-1][j] && arr[i-1][j] ==1){
					count ++;
				}
			}*/
			// with daigonal
			if(i>0){
				if(arr[i][j] == arr[i-1][j] && arr[i-1][j] ==1){
					count ++;
				}
				if(i>0 && j>0 && j != m-1){
					if(arr[i][j] == arr[i-1][j-1] && arr[i-1][j-1] ==1){
						count ++;
					}
					if(arr[i][j] == arr[i-1][j+1] && arr[i-1][j+1] ==1){
						count ++;
					}
				}
			}
			}
		}
	}
	return count;
	
}
	    
}