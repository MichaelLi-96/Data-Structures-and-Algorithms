//https://leetcode.com/problems/longest-increasing-subsequence/solution/

class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int lis = 1;
        for(int i = 1; i < dp.length; i++) {
            int max = 0;
            for(int j = 0; j < i; j++) {
                if(nums[i] > nums[j]) {
                    max = Math.max(max, dp[j]);
                }
            }
            dp[i] = max + 1;
            lis = Math.max(lis, dp[i]);
        }
        return lis;
    }
}

/*
	Time Complexity: O(n^2) where n is the length of input array nums
	Space Complexity: O(n) where n is the length of input array nums
*/