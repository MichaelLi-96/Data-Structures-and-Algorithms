//https://leetcode.com/problems/maximum-average-subarray-i/

class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double currentWindowSum = 0; 
        for(int i = 0; i < k; i++) {
            currentWindowSum += nums[i];
        }
        double maxAvg = currentWindowSum / k;
        for(int i = k; i < nums.length; i++) {
            currentWindowSum += nums[i];
            currentWindowSum -= nums[i - k];
            maxAvg = Math.max(maxAvg, currentWindowSum / k);
        }
        return maxAvg;
    }
}

/*
    Time Complexity: O(n) where n is the length of the input array nums
    Space Complexity: O(1)
*/