//https://leetcode.com/problems/validate-binary-search-tree/

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
    public boolean isValidBST(TreeNode root) {
        return preorder(root, null, null);   
    }
    
    public boolean preorder(TreeNode root, Integer min, Integer max) {
        if(root == null) {
            return true;
        }
        if(min != null && root.val <= min) {
            return false;
        }
        if(max != null && root.val >= max) {
            return false;
        }
        boolean left = preorder(root.left, min, root.val);
        boolean right = preorder(root.right, root.val, max);
        return left && right;
    }
}

/*
    Time Complexity: O(n) where n is the number of nodes in the tree
    Space Complexity: O(log(n)) for balanced tree and O(n) for skewed tree where n is the height of the tree 
*/
