//https://leetcode.com/problems/delete-leaves-with-a-given-value/

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
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if(root == null) {
            return null;
        }
        
        TreeNode left = removeLeafNodes(root.left, target);
        TreeNode right = removeLeafNodes(root.right, target);
        if(left == null && right == null && root.val == target) {
            return null;
        }
        root.left = left;
        root.right = right;
        return root;
    }
}

/*
    Time Complexity: O(n) where n is the number of nodes in the tree
    Space Complexity: O(log(n)) for balanced tree and O(n) for skewed tree where n is the height of the tree 
*/