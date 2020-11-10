//https://leetcode.com/problems/merge-sorted-array/

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(nums2.length == 0) {
            return;
        }
        int left = nums1.length - 1;
        for(int i = m - 1; i >= 0; i--) {
            nums1[left] = nums1[i];
            left--;
        }
        int idx1 = nums1.length - m;
        int idx2 = 0;
        for(int i = 0; i < nums1.length; i++) {
            if(idx1 == nums1.length) {
                nums1[i] = nums2[idx2];
                idx2++;       
            } 
            else if(idx2 == nums2.length) {
                nums1[i] = nums1[idx1];
                idx1++;
            }
            else {
                if(nums1[idx1] <= nums2[idx2]) {
                    nums1[i] = nums1[idx1];
                    idx1++;
                }
                else {
                    nums1[i] = nums2[idx2];
                    idx2++;
                }
            }
        }
    }
}

/*
	Time Complexity: O(2n) -> O(n) where n is the length of the input array nums1  
	Space Complexity: O(1) 
*/