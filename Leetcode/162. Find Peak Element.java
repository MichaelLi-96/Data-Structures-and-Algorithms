//https://leetcode.com/problems/find-peak-element/

class Solution {
    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(mid + 1 <= nums.length - 1 && nums[mid] < nums[mid + 1]) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        return left;
    }
}

/*
    Time Complexity: O(log(n)) where n is the length of the input array nums
    Space Complexity: O(1)
*/

class Solution {
    public int findPeakElement(int[] nums) {
        for(int i = 0; i < nums.length - 1; i++) {
            if(nums[i] > nums[i + 1]) {
                return i;
            }
        }
        return nums.length - 1;
    }
}

/*
    Time Complexity: O(n) where n is the length of the input array nums
    Space Complexity: O(1)
*/
