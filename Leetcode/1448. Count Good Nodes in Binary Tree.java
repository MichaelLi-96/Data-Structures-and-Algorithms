//https://leetcode.com/problems/count-good-nodes-in-binary-tree/

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
    //int totalCount = 0;
    public int goodNodes(TreeNode root) {
        return preorder(root, root.val);
        
    }
    
    public int preorder(TreeNode root, int currentMax) {
        if(root == null) {
            return 0;
        }
        boolean hit = false;
        if(root.val >= currentMax) {
            hit = true;
        }
        int max = Math.max(currentMax, root.val);
        int left = preorder(root.left, max);
        int right = preorder(root.right, max);
        return (hit ? 1 : 0) + left + right;
    }
}

/*
    Time Complexity: O(n) where n is the number of nodes in the tree
    Space Complexity: O(log(n)) for balanced tree and O(n) for skewed tree where n is the height of the tree 
*/