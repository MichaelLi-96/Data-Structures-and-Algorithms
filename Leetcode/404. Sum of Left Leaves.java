//https://leetcode.com/problems/sum-of-left-leaves/

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
    public int sumOfLeftLeaves(TreeNode root) {
        return findLeftLeavesSum(root, false);
    }
    
    public int findLeftLeavesSum(TreeNode root, boolean isLeft) {
        if(root == null) {
            return 0;
        }
        if(isLeft && root.left == null && root.right == null) {
            return root.val;
        }
        int left = findLeftLeavesSum(root.left, true);
        int right = findLeftLeavesSum(root.right, false);
        return left + right;
    }
}

/*
    Time Complexity: O(n) where n is the number of nodes in the tree
    Space Complexity: O(log(n)) for balanced tree and O(n) for skewed tree where n is the height of the tree 
*/