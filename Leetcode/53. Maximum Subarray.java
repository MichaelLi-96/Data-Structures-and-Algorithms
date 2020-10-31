//https://leetcode.com/problems/maximum-subarray/

class Solution {
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int currentMax = nums[0];
        for(int i = 1; i < nums.length; i++) {
            currentMax = Math.max(currentMax + nums[i], nums[i]);
            max = Math.max(max, currentMax);
        }
        return max;
    }
}

/*
	Time Complexity: O(n) where n is the length of the input nums array
	Space Complexity: O(1)
*/