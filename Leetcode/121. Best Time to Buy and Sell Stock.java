//https://leetcode.com/problems/best-time-to-buy-and-sell-stock/

class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length == 0) {
            return 0;
        }
        int curMin = prices[0];
        int curMax = prices[0];
        int maxProfit = 0;
        for(int i = 1; i < prices.length; i++) {
            if(prices[i] < curMin) {
                maxProfit = Math.max(maxProfit, curMax - curMin);
                curMin = prices[i];
                curMax = prices[i];
            }
            else {
                curMax = Math.max(curMax, prices[i]);
            }
        }
        maxProfit = Math.max(maxProfit, curMax - curMin);
        return maxProfit;
    }
}

/*
    Time Complexity: O(n) where n is the length of the input array prices
    Space Complexity: O(1)
*/