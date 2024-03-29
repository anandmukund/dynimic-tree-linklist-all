package com.dp;

public class MinCoinChange {
	

	public int minCoinDynamic(int amount, int[] coins) {
		int[] coinReq = new int[amount+1]; // this will store the optimal solution
											// for all the values -- from 0 to
											// given amount.
		int[] CC = new int[coins.length]; // resets for every smaller problems
											// and minimum in it is the optimal
											// solution for the smaller problem.
		coinReq[0] = 0; // 0 coins are required to make the change for 0
		// now solve for all the amounts
		for (int amt = 1; amt <= amount; amt++) {
			for (int j = 0; j < CC.length; j++) {
				CC[j] = -1;
			}
			// Now try taking every coin one at a time and fill the solution in
			// the CC[]
			for (int j = 0; j < coins.length; j++) {
				if (coins[j] <= amt) { // check if coin value is less than
										// amount
					CC[j] = coinReq[amt - coins[j]] + 1; // if available,
																// select the
																// coin and add
																// 1 to solution
																// of
																// (amount-coin
					// value)
				}
			}
			//Now solutions for amt using all the coins is stored in CC[]
//			take out the minimum (optimal) and store in coinReq[amt]
			coinReq[amt]=-1;
			for(int j=1;j<CC.length;j++){
				if(CC[j]>0 && (coinReq[amt]==-1 || coinReq[amt]>CC[j])){
					coinReq[amt]=CC[j];
				}
			}
		}
		//return the optimal solution for amount
		return coinReq[amount];
		
	}

	public int minCoinDynamic1(int amount, int[] coins) {
		int[][] coinReq = new int[coins.length+1][amount+1]; 
											
		for(int i =0 ; i <= amount ; i++ ){
			coinReq[0][i] =i;
		}
		for(int i =0 ; i <= coins.length ; i++ ){
			coinReq[i][0] =0;
		}
		for(int i =1 ; i < coins.length+1 ; i++){
			for(int j =1 ; j <=amount ; j++){
			
				if(j >= coins[i-1]){
					coinReq[i][j] = Math.min(coinReq[i-1][j] ,1+coinReq[i][j-coins[i-1]])	;
				} else{
					coinReq[i][j] = coinReq[i-1][j]; 
				}
			}
		}
		
		
		return coinReq[coins.length][amount];
		
	}

	
	
	public static void main(String[] args) {
		int[] coins = { 1, 2, 3 };
		int amount = 20;
		MinCoinChange m = new MinCoinChange();		
		System.out.println("(Dynamic Programming) Minimum Coins required to make change for "
				+ amount + " are: " + m.minCoinDynamic1(amount, coins));
	}

}