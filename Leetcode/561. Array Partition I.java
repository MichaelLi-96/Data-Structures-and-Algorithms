//https://leetcode.com/problems/array-partition-i/

public class Solution {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int maxSum = 0;
        for (int i = 0; i < nums.length; i += 2) {
            sum += nums[i];
        }
        return maxSum;
    }
}

/*
    Time Complexity: O(nlog(n) + n) => O(nlog(n)) where n is the length of the input int array nums 
    Space Complexity: O(1)
*/