package com.dp;
/*
 * Length	1	2	3	4	5	6	7	8	9	10
Price	1	5	8	9	10	17	17	20	24	30
for rod of length: 4
Ways to sell :
•	selling length : 4  ( no cuts) , Price: 9
•	selling length : 1,1,1,1  ( 3 cuts) , Price: 4
•	selling length : 1,1,2  ( 2 cuts) , Price: 7
•	selling length : 2,2  ( 1 cut) , Price: 10
•	selling length : 3, 1  ( 1 cut) , Price: 9

 */
public class RodCutting {

	public static int profitDP(int[] value, int length) {
		int[] solution = new int[length + 1];
		solution[0] = 0;

		for (int i = 1; i <= length; i++) {
			int max = -1;
			for (int j = 0; j < i; j++) {
				max = Math.max(max, value[j] + solution[i - (j + 1)]);
				solution[i] = max;
			}
		}
		return solution[length];
	}
	public static int minCoinDynamic1(int[] value, int length) {
		int[][] coinReq = new int[value.length+1][length+1]; 
											
		for(int i =0 ; i <= length ; i++ ){
			coinReq[0][i] =i;
		}
		for(int i =0 ; i <= value.length ; i++ ){
			coinReq[i][0] =0;
		}
		for(int i =1 ; i < value.length+1 ; i++){
			for(int j =1 ; j <=length ; j++){
			
				if(j >= i){
					coinReq[i][j] = Math.max(coinReq[i-1][j] ,value[i-1]+coinReq[i][j-i]);
				} else{
					coinReq[i][j] = coinReq[i-1][j]; 
				}
			}
		}
		return coinReq[value.length][length];
		
	}
	public static void main(String[] args) {
		int[] value = { 2, 3, 7, 8, 9 };
		int len = 5;
		System.out.println("Max profit for length is " + len + ":"
				+ profitDP(value, len));

	}

}