//https://leetcode.com/problems/longest-continuous-increasing-subsequence/

class Solution {
    public int findLengthOfLCIS(int[] nums) {
        if(nums.length == 0) {
            return 0;
        }
        int left = 0;
        int longest = 1;
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] <= nums[i - 1]) {
                left = i;
            }
            longest = Math.max(longest, i - left + 1);

        }
        return longest;
    }
}

/*
	Time Complexity: O(n) where n is the length of input array nums
	Space Complexity: O(1)
*/