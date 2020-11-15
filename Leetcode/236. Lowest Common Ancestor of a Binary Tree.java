//https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    TreeNode lca = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        postorder(root, p, q);
        return lca;
    }
    
    public boolean postorder(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) {
            return false;
        }
        boolean left = postorder(root.left, p, q);
        boolean right = postorder(root.right, p, q);
        if((root == p || root == q && (left || right)) || (left && right)) {
            lca = root;
        }
        if(root == p || root == q) {
            return true;
        }
        return left || right;
    }
}

/*
    Time Complexity: O(n) where n is the number of nonoverlapping nodes in the tree
    Space Complexity: O(log(n)) for balanced tree and O(n) for skewed tree where n is the height of the tree 
*/