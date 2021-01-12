//https://leetcode.com/problems/search-in-rotated-sorted-array/

class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } 
            else if(nums[mid] < target) {
                // If right side is increasing and target is greater than biggest value (right), search left side
                if(nums[right] >= nums[mid] && target > nums[right]) {
                    right = mid - 1;
                }
                else {
                    left = mid + 1; 
                }
            }
            else {
                // If left side is increasing and target is less than smallest value (left), search right side
                if(nums[left] <= nums[mid] && target < nums[left]) {
                    left = mid + 1; 
                }
                else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}

/*
    Time Complexity: O(log(n)) where n is the length of the input array nums
    Space Complexity: O(1)
*/