//https://leetcode.com/problems/construct-string-from-binary-tree/

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
    public String tree2str(TreeNode t) {
        StringBuilder str = new StringBuilder();
        preorder(str, t);
        return str.toString();
    }
    
    public void preorder(StringBuilder str, TreeNode node) {
        if(node == null) {
            return;
        }
        str.append(node.val);
        if(node.left == null && node.right != null || node.left != null) {
            str.append("(");   
        }
        preorder(str, node.left);
        if(node.left == null && node.right != null || node.left != null) {
            str.append(")");   
        }
        if(node.right != null) {
            str.append("(");
        }
        preorder(str, node.right);
        if(node.right != null) {
            str.append(")");
        }
    }
}

/*
    Time Complexity: O(n) where n is the number of nodes in the tree
    Space Complexity: Auxiliary Space: O(n) where n is the number of nodes in the tree, Stack Space: O(log(n)) for balanced tree and O(n) for skewed tree where n is the height of the tree 
*/