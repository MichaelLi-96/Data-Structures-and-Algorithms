//https://leetcode.com/problems/coin-change/

class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, dp.length);
        dp[0] = 0;
        for(int i = 1; i < dp.length; i++) {
            for(int j = 0; j < coins.length; j++) {
                if(coins[j] <= i) {
                    dp[i] = Math.min(dp[i - coins[j]] + 1, dp[i]);
                }
            }
        }
        return dp[dp.length - 1] == dp.length ? -1 : dp[dp.length - 1];
    }
}

/*
	Time Complexity: O(n * m) where n the input int amount and m is the length of the input coins matrix
	Space Complexity: O(n) where n the input int amount
*/