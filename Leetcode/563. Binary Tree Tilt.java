//https://leetcode.com/problems/binary-tree-tilt/

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
    int totalTilt = 0;
    public int findTilt(TreeNode root) {
        findSum(root);
        return totalTilt;
    }
    
    public int findSum(TreeNode root) {
        if(root == null) {
            return 0;
        }
        
        int left = findSum(root.left);
        int right = findSum(root.right);
        int tilt = Math.abs(left - right);
        totalTilt += tilt;
        return root.val + left + right;
    }
}

/*
    Time Complexity: O(n) where n is the number of nodes in the tree
    Space Complexity: O(log(n)) for balanced tree and O(n) for skewed tree where n is the height of the tree 
*/