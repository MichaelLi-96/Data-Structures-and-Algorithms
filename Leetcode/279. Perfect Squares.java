//https://leetcode.com/problems/perfect-squares/

class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, n + 1);
        dp[0] = 0;
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j * j <= n; j++) {
                if(i - (j * j) >= 0) {
                    dp[i] = Math.min(dp[i], dp[i - (j * j)] + 1);
                }
            }
        } 

        return dp[dp.length - 1];
    }
}

/*
	Time Complexity: O(n * m) where n is the input int n and m is the number of perfect squares between 1 and n
	Space Complexity: O(n) where n is the input int n
*/