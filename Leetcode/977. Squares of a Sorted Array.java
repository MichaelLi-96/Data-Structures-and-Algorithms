//https://leetcode.com/problems/squares-of-a-sorted-array/

class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] sortedArr = new int[nums.length];
        int left = 0;
        int right = nums.length - 1;
        int idx = nums.length - 1;
        while(idx >= 0) {
            int leftSquare = nums[left] * nums[left];
            int rightSquare = nums[right] * nums[right];
            if(leftSquare >= rightSquare) {
                sortedArr[idx] = leftSquare;
                left++;
            }
            else {
                sortedArr[idx] = rightSquare;
                right--;
            }
            idx--;
        }
        return sortedArr;
    }
}

/*
    Time Complexity: O(n) where n is the length of the input int array nums
    Space Complexity: O(1) not counting output array, O(n) counting output array where n is the length of the input int array nums
*/