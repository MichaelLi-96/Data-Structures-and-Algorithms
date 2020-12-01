//https://leetcode.com/problems/insert-into-a-binary-search-tree/

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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null) {
            return new TreeNode(val);
        }
        if(root.val > val) {
            root.left = insertIntoBST(root.left, val);
        }
        if(root.val < val) {
            root.right = insertIntoBST(root.right, val);
        }
        return root;
    }
}

/*
    Time Complexity: O(n) where n is the number of nodes in the tree
    Space Complexity: O(log(n)) for balanced tree and O(n) for skewed tree where n is the height of the tree 
*/