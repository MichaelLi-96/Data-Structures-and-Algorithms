//https://leetcode.com/problems/valid-palindrome-ii/

class Solution {
    public int singleNonDuplicate(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        while(start <= end) {
            int mid = start + (end - start) / 2;
            if(mid == 0 || mid == nums.length - 1) {
                return nums[mid];
            }
            if(nums[mid] == nums[mid - 1] || nums[mid] == nums[mid + 1]) {
                if(mid % 2 == 1 && nums[mid] == nums[mid - 1] || mid % 2 == 0 && nums[mid] == nums[mid + 1]) {
                    start = mid + 1;
                }
                else {
                    end = mid - 1;
                }
            }
            else {
                return nums[mid];
            }
        }
        return -1;
    }
}

/*
    Time Complexity: O(log(n)) where n is the length of the input array nums
    Space Complexity: O(1)
*/