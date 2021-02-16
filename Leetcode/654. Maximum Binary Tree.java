//https://leetcode.com/problems/maximum-binary-tree/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return constructTree(nums, 0, nums.length);
    }
    
    public TreeNode constructTree(int[] nums, int left, int right) {
        if(left >= right) {
            return null;
        }
        int maxIndex = left;
        for(int i = left; i < right; i++) {
            if(nums[i] > nums[maxIndex]) {
                maxIndex = i;
            }
        }
        TreeNode node = new TreeNode(nums[maxIndex]);
        node.left = constructTree(nums, left, maxIndex);
        node.right = constructTree(nums, maxIndex + 1, right);
        return node;
    }
}

/*
    Time Complexity: O(n^2) where n is the length of the input int array nums
    Space Complexity: O(n) stack space where n is the length of the input int array nums 
*/