//https://leetcode.com/problems/merge-two-binary-trees/

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
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if(t1 == null && t2 == null) {
            return null;
        }
        else if(t1 == null && t2 != null) {
            return t2;
        }
        else if(t1 != null && t2 == null) {
            return t1;
        }
        int newVal = t1.val + t2.val;
        TreeNode node = new TreeNode(newVal);
        node.left = mergeTrees(t1.left, t2.left);
        node.right = mergeTrees(t1.right, t2.right);
        return node;
    }
}

/*
	Time Complexity: O(n) where n is the number of nonoverlapping nodes in the tree
	Space Complexity: O(log(n)) for balanced tree and O(n) for skewed tree where n is the height of the tree 
*/