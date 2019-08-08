package com.dp;

public class CoinGame {


		public static int solve(int[] A) {
			int[][] MV = new int[A.length][A.length];

			for (int interval = 0; interval < A.length; interval++) {
				for (int i = 0, j = interval; j < A.length; i++, j++) {
					int a, b, c;
					if (i + 2 <= j)
						a = MV[i + 2][j];
					else
						a = 0;
					//////////////////////////////////
					if (i + 1 <= j - 1)
						b = MV[i + 1][j - 1];
					else
						b = 0;
					//////////////////////////////////
					if (i <= j - 2)
						c = MV[i][j-2];
					else
						c = 0;
					//////////////////////////////////
					MV[i][j] = Math
							.max(A[i] + Math.min(a, b), A[j]+ Math.min(b, c));
				}
			}
			return MV[0][A.length - 1];
		}

		public static long pow(int x , int y ){
			    long temp;
			    if( y == 0)
			        return 1;
			    temp = pow(x, y/2);
			    if (y%2 == 0)
			        return temp*temp;
			    else
			        return x*temp*temp;
			
		}
		
		public static long rV(int x , int y){
			return x*y;
		}
		public static void main(String[] args) {
			
			long p = pow(2, 8);
			System.out.println(p);
			int[] B = {10,2,1,5,68,56,44,5,7,33,10000,1000};
			System.out.println("Max value pick up by player1" + solve(B));
		}

	}

