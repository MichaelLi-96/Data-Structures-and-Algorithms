//https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] indexes = new int[2];
        indexes[0] = binarySearchLeft(nums, target);
        indexes[1] = binarySearchRight(nums, target);
        return indexes;
    }
    
    public int binarySearchLeft(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while(start <= end) {
            int mid = start + (end - start) / 2;
            if(nums[mid] == target) {
                while(nums[mid] == target) {
                    if(mid == 0) {
                        return 0;
                    }
                    mid--;
                }
                return mid + 1;
            }
            else if(nums[mid] > target) {
                end = mid - 1;
            }
            else {
                start = mid + 1;
            }
        }
        return -1;
    }
    
    public int binarySearchRight(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while(start <= end) {
            int mid = start + (end - start) / 2;
            if(nums[mid] == target) {
                 while(nums[mid] == target) {
                    if(mid == nums.length - 1) {
                        return nums.length - 1;
                    }
                    mid++;
                }
                return mid - 1;
            }
            else if(nums[mid] > target) {
                end = mid - 1;
            }
            else {
                start = mid + 1;
            }
        }
        return -1;
    }
}

/*
	Time Complexity: O(2log(n)) -> O(log(n)) where n is the length of the input array nums
	Space Complexity: O(1)
*/

