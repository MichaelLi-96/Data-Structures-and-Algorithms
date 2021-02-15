//https://leetcode.com/problems/fibonacci-number/

class Solution {
    public int fib(int N) {
        int[] dp = new int[N + 1];
        dp[1] = 1;
        for(int i = 2; i < dp.length; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[N];
    }
}

/*
    Time Complexity: O(n) where n is the input int N
    Space Complexity: O(n) where n is the input int N
*/