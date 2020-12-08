//https://leetcode.com/problems/flatten-binary-tree-to-linked-list/

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
    public void flatten(TreeNode root) {
        reversePostorder(root, null);
        
    }
    
    public TreeNode reversePostorder(TreeNode root, TreeNode currentflattenedTree) {
        if(root == null) {
            return currentflattenedTree;
        }
        TreeNode rightFlattenedTree = reversePostorder(root.right, currentflattenedTree);
        TreeNode leftFlattenedTree = reversePostorder(root.left, rightFlattenedTree);
        root.right = leftFlattenedTree;
        root.left = null;
        return root;
    }
}

/*
	Time Complexity: O(n) where n is the number of nodes in the tree
	Space Complexity: O(log(n)) for balanced tree and O(n) for skewed tree where n is the height of the tree 
*/