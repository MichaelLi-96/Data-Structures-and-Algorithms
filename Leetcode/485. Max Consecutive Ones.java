//https://leetcode.com/problems/max-consecutive-ones/

class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int curMax = 0;
        int max = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 1) {
                curMax++;
            }
            else {
                max = Math.max(max, curMax); 
                curMax = 0;
            }
        }
        max = Math.max(max, curMax);
        return max;
    }
}

/*
	Time Complexity: O(n) where n is the length of the input array nums
	Space Complexity: O(1)
*/