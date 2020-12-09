//https://leetcode.com/problems/increasing-order-search-tree/

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
    TreeNode cur = new TreeNode(0);
    public TreeNode increasingBST(TreeNode root) {
        TreeNode head = cur;
        inorder(root);
        return head.right;
    }
    
    public void inorder(TreeNode root) {
        if(root == null) {
            return;
        }
        inorder(root.left);
        root.left = null;
        cur.right = root;
        cur = cur.right;
        inorder(root.right);
    }
}

/*
	Time Complexity: O(n) where n is the number of nodes in the tree
	Space Complexity: O(log(n)) for balanced tree and O(n) for skewed tree where n is the height of the tree 
*/