//https://leetcode.com/problems/path-sum/
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
    public boolean hasPathSum(TreeNode root, int targetSum) {
       return dfs(root, 0, targetSum);
    }
    
    public boolean dfs(TreeNode root, int currentSum, int targetSum) {
         if(root == null) {
            return false;
        }
        int sum = currentSum += root.val;
        if(sum == targetSum && root.left == null && root.right == null) {
            return true;
        }
        return dfs(root.left, sum, targetSum) || dfs(root.right, sum, targetSum);
    }
}

/*
    Time Complexity: O(n) where n is the number of nodes in the tree
    Space Complexity: O(log(n)) for balanced tree and O(n) for skewed tree where n is the height of the tree 
*/