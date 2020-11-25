//https://leetcode.com/problems/univalued-binary-tree/

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
    public boolean isUnivalTree(TreeNode root) {
        return preorder(root, root);
    }
    
    public boolean preorder(TreeNode root, TreeNode parent) {
        if(root == null) {
            return true;
        }
        if(root.val != parent.val) {
            return false;
        }
        boolean left = preorder(root.left, root);
        boolean right = preorder(root.right, root);
        return left && right;
    }
}

/*
    Time Complexity: O(n) where n is the number of nodes in the tree
    Space Complexity: O(log(n)) for balanced tree and O(n) for skewed tree where n is the height of the tree 
*/