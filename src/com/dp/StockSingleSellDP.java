package com.dp;
/*
  int[] prices = {200, 500, 1000, 700, 30, 400, 900, 400, 50};
  Output: Maximum Profit: 870, buy date index: 4, sell date index: 6
 */
public class StockSingleSellDP {
    public static void maxProfit(int[] prices) {
        int period = prices.length;
        int buyDateIndex = 0;
        int tempIndex = 0;
        int sellDateIndex = 0;
        int current_profit = 0;
        int max_sell_price = prices[period - 1]; //assign the last element
        for (int i = period - 2; i > 0; i--) {
            if (max_sell_price < prices[i]) {
                max_sell_price = prices[i];
                tempIndex = i;
            } else if (max_sell_price > prices[i]) {
                if (current_profit < max_sell_price - prices[i]) {
                    current_profit = max_sell_price - prices[i];
                    buyDateIndex = i;
                    sellDateIndex = tempIndex;
                }
            }
        }
        System.out.println("Maximum Profit(DP): " + current_profit + ", buy date index: " + buyDateIndex +
                ", sell date index: " + sellDateIndex);
    }

    public static void main(String[] args) {
        int[] prices = {200, 500, 1000, 700, 30, 400, 900, 400, 50};
        maxProfit(prices);
    }
}