//https://leetcode.com/problems/maximum-product-subarray/

class Solution {
    public int maxProduct(int[] nums) {
        int curMax = nums[0];
        int curMin = nums[0];
        int maxProduct = nums[0];
        for(int i = 1; i < nums.length; i++) {
            int tempMax = curMax;
            curMax = Math.max(Math.max(curMax * nums[i], curMin * nums[i]), nums[i]);
            curMin = Math.min(Math.min(tempMax * nums[i], curMin * nums[i]), nums[i]);
            maxProduct = Math.max(maxProduct, curMax);
        }
        return maxProduct;
    }
}

/*
    Time Complexity: O(n) where n is the length of the input int array nums
    Space Complexity: O(1)
*/