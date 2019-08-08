package com.algo1;

import java.util.HashMap;

public class Paytm2nd {

	
	public int gerNumber(int input1, int[] input2 , int input3){
		
		if(input1 != input2.length){
			
			return 0;
		}
		
		int[][] result = new int[input2.length + 1][input3+1];
		
		for(int i = 0 ; i <= input2.length ; i++ ){
			result[0][i] = 0;
		}
		for(int i = 0 ; i <= input3; i++ ){
			result[1][0] = 0;
		}
		int sum = 0;
		for(int i =1 ;i <= input2.length ; i ++){
			sum += input2[i-1];
			for(int j =1 ;j <= input3; j ++){
		
				if(input2[i-1] > j){
					result[i][j] = result[i-1][j];
				}
				else {
					if(input2[i-1] == j){
						result[i][j] = result[i-1][j] +1;	
					} else {
						if( sum > j){
					      result[i][j] = result[i-1][j] + result[i][j-input2[i-1]];
						} 
						if(sum == j){
							  result[i][j] = 1;
						}
						if(sum <j) {
							result[i][j] = result[i-1][j];
						}
					}
				}
			}
		}
		
		return result[input2.length][input3];
	}
	
	
	/*static int numberOfPairs(int[] a, long k) {

		
		int[][] result = new int[a.length + 1][(int) (k+1)];
		
		for(int i = 0 ; i <= a.length ; i++ ){
			result[0][i] = 0;
		}
		for(int i = 0 ; i <= k; i++ ){
			result[1][0] = 0;
		}
		int sum = 0;
		for(int i =1 ;i <= a.length ; i ++){
			sum += a[i-1];
			for(int j =1 ;j <= k; j ++){
		
				if(a[i-1] > j){
					result[i][j] = result[i-1][j];
				}
				else {
					if(a[i-1] == j){
						result[i][j] = result[i-1][j] +1;	
					} else {
						if( sum > j){
					      result[i][j] = result[i-1][j] + result[i][j-a[i-1]];
						} 
						if(sum == j){
							  result[i][j] = 1;
						}
						if(sum <j) {
							result[i][j] = result[i-1][j];
						}
					}
				}
			}
		}
		
		return result[a.length][(int) k];
    }
*/
	static int numberOfPairs(int[] a, long k) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        int result = 0;
        for (int i=0; i<a.length; i++){
        	int p = (int) (k-a[i]);
            if(hm.containsKey(a[i])){
            	int count = hm.get(a[i]);
            	result = result + 1;
            	 hm.put(p,result);
            } else {     
            hm.put(p,1);
            }
        }
 
        return result*2;
    }
	
	
	public static void main(String as[]){
		int[]o = {1,3,46,1,3,8};
		numberOfPairs(o, 47);
		Paytm2nd n = new Paytm2nd();
		System.out.println(n.gerNumber(9, o, 20));
	}
}
