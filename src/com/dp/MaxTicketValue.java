package com.dp;


public class MaxTicketValue {

	public int gerNumber(int k, int[] a){

		int[][] result = new int[a.length+1][k+1];

	/*	for(int i = 0 ; i <= k; i++ ){
			result[0][i] = 0;
		}
		for(int i = 0 ; i <= a.length; i++ ){
			result[i][0] = 0;
		}*/
		int sum = 0;
		for(int i =1 ;i <= a.length ; i ++){
			int st = 0;
			int ed = 1;
			sum += a[i-1];
			for(int j =1 ;j <= k; j ++){

				if(sum < j){
					result[i][j] = 0;
				}
				else {
					if(result[i-1][j]>=result[i][j-1] + a[i-1]){
						result[i][j] = result[i-1][j];
						st++;
						ed++;
					} else {
						if(a[i-1]  >= result[i-1][ed] - result[i-1][st] ){
							result[i][j] = a[i-1] + result[i][j-1];
							a[i-1] = a[i-1] -1;
						} else {
							result[i][j] = result[i][j-1] + result[i-1][ed] - result[i-1][st];
							st++;
							ed++;
						}
					}
				}
			}
		}
		return result[a.length][k];
	}
	
	
	//
	static long maximumAmount(int[] a, long k){

		int[][] result = new int[a.length+1][(int) (k+1)];
		int sum = 0;
		for(int i =1 ;i <= a.length ; i ++){
			int st = 0;
			int ed = 1;
			sum += a[i-1];
			for(int j =1 ;j <= k; j ++){

				if(sum < j){
					result[i][j] = 0;
				}
				else {
					if(result[i-1][j]>=result[i][j-1] + a[i-1]){
						result[i][j] = result[i-1][j];
						st++;
						ed++;
					} else {
						if(a[i-1]  >= result[i-1][ed] - result[i-1][st] ){
							result[i][j] = a[i-1] + result[i][j-1];
							a[i-1] = a[i-1] -1;
						} else {
							result[i][j] = result[i][j-1] + result[i-1][ed] - result[i-1][st];
							st++;
							ed++;
						}
					}
				}
			}
		}
		return result[a.length][(int) k];
	}
	
	
	public static void main(String as[]){
		int[]o = {3,8,9,7,5,4};
		MaxTicketValue n = new MaxTicketValue();
		System.out.println(n.gerNumber(6, o));
	}
}
