package com.algo1;

public class Test1 {

	
	public static int getCount(int no){
		int count=0;
		
		while(no  >= 2){
			count++;
			if(no%3 ==0){
				no = no/3;
			}
			if(no%2 ==0){
				no = no/2;
			}
			if(no%3!=0 && no%2!=0 ){
				no = no-1;
			}
			
		}
		return count;
	}
	static int getMinSteps ( int n )
	{
	int [] dp = new int[n+1];
	int i;
	dp[1] = 0;  // trivial case
	for( i = 2 ; i <= n ; i ++ )
	{
	dp[i] = 1 + dp[i-1];
	if(i%2==0){
		dp[i] = Math.min( dp[i] , 1+ dp[i/2] );
	}
	if(i%3==0) {
		dp[i] = Math.min( dp[i] , 1+ dp[i/3] );
	}
	}
	return dp[n];
	}
	public static void main(String as[]){
		System.out.println(Test1.getMinSteps(10));
	}
}
