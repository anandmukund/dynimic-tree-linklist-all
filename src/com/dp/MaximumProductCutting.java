package com.dp;

/*
 * 
•	Rope length: 2 
•	Options: (1*1)
•	Maximum Product Cutting : 1*1 = 1

•	Rope length: 3 
•	Options: (1*1*1, 2*1)
•	Maximum Product Cutting : 2*1 = 2

•	Rope length: 4 
•	Options: (1*1*1*1, 2*1*1, 3*1, 2*2)
•	Maximum Product Cutting : 2*2 = 4

•	Rope length: 5 
•	Options: (1*1*1*1*1, 2*1*1*1, 3*1*1, 2*2*1, 3*2)
•	Maximum Product Cutting : 3*2 = 2

 */
public class MaximumProductCutting {
	public void maxProductCutting(int n) {
		int[] MPC = new int[n + 1];
		MPC[1] = 1;
		for (int i = 2; i < n + 1; i++) {
			int mp = Integer.MIN_VALUE;
			for (int j = 1; j < i; j++) {
				mp = Math.max(mp, Math.max(j * MPC[i - j], j * (i - j)));
			}
			MPC[i] = mp;
		}
		System.out.println("Dynamic Programming: Maximum product cutting in "
				+ n + "is " + MPC[n]);
	}
	public int maxProdutRecursion(int n) {
		// base case
		if (n == 0 || n == 1) {
			return 0;
		}
		// make all possible cuts and get the maximum
		int max = 0;
		for (int i = 1; i < n; i++) {
			// Either this cut will produce the max product OR
			// we need to make further cuts
			max = Math.max(max,
					Math.max(i * (n - i), i * maxProdutRecursion(n - i)));
		}
		//return the max of all
		return max;
	}
	public static void main(String[] args) throws java.lang.Exception {
		MaximumProductCutting i = new MaximumProductCutting();
		i.maxProductCutting(10);
	}
}
