import java.io.IOException;
import java.util.Arrays;

public class GS {
public GS() throws IOException{
	
}
	public static void main(String[] args) {
		//System.out.println(minCoinDynamic1(12));
		System.out.println(getMaxGroceryItems(50, 3, 10, "22,12,1,2,5,4,8,6,14,18,7"));

	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	static int i = -1;
	static int count = 0;
	static int rem  =0;
	static String getMaxGroceryItems(int salary, int itemsToBuyForCashback, int cashback, String prices) {
		 String result = "";
		 int tempCount = 0;
		  int currentCost = 0;
			String[] pri = prices.split(",");
			int[] re = new int[pri.length];
			
			
			for (int i = 0; i < pri.length; i++) {
				re[i] = Integer.valueOf(pri[i]);
			}
			Arrays.sort(re);
			for (i = i+1; i < re.length; i++) {
				if (currentCost + re[i] <= salary) {
					currentCost = currentCost + re[i];
					count++;
					tempCount++;
	                if(tempCount > 5){
						break;
					}
				} else {
					break;
				}
			}
			if (tempCount > 5) {
	             int cb = 0;
	            if(count == 6){
	                cb = itemsToBuyForCashback * cashback + 10; 
	            } else {
				 cb = itemsToBuyForCashback * cashback;
	            }
				salary = salary - currentCost  + cb;
				return getMaxGroceryItems( salary,  itemsToBuyForCashback,  cashback,  prices);
			}
			int rem = salary - currentCost;
			result = String.valueOf(count) + " " + String.valueOf(rem);
			return result;
		}
	
	
	
	

	public static int minCoinDynamic1(int totalScore) {
		int le = totalScore / 2;
		int[][] result = new int[4][le + 1];
		for (int i = 0; i <= le; i++) {
			result[1][i] = 1;
		}
		for (int i = 2; i < 4; i++) {
			for (int j = 1; j <= le; j++) {
				if (j == i) {
					result[i][j] = result[i - 1][j] + 1;
				} else {
					if (j > i) {
						if (i == 2) {
							result[i][j] = result[i][j - 1] + result[i][j - 2];
						}
						if (i == 3) {
							result[i][j] = result[i][j - 1] + result[i][j - 2] + result[i][j - 3];
						}
					} else {
						result[i][j] = result[i - 1][j];
					}
				}
			}
		}
		return result[3][le];

	}
}
