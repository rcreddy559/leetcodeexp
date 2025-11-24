package com.leetcodeexp.practice;

public class BestTimeToBuySellStock {
    public static void main(String[] args) {
        int[] prices = { 7, 1, 5, 3, 6, 4 };
        int result = solution(prices);
        System.out.println(result);
    }

    private static int solution(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }

        int buyPrice = prices[0], maxProfit = 0;
        for (var i = 1; i < prices.length; i++) {
            if (buyPrice > prices[i]) {
                buyPrice = prices[i];
            } else {
                int currentPrice = prices[0] - buyPrice;
                maxProfit = Math.max(maxProfit, currentPrice);
            }

        }
        System.out.printf("Max profit: %d, Buy Price: %d\n", maxProfit, buyPrice);
        return maxProfit;
    }
}
