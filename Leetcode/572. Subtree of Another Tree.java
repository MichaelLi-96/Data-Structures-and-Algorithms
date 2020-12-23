//https://leetcode.com/problems/subtree-of-another-tree/

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
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if(s == null) {
            return false;
        }
        if(matchTree(s, t)) {
            return true;
        }
        boolean left = isSubtree(s.left, t);
        boolean right = isSubtree(s.right, t);
        return left || right;
    }
    
    public boolean matchTree(TreeNode n1, TreeNode n2) {
        if(n1 == null && n2 == null) {
            return true;
        }
        if(n1 == null && n2 != null || n1 != null && n2 == null || n1.val != n2.val) {
            return false;
        }
        boolean left = matchTree(n1.left, n2.left);
        boolean right = matchTree(n1.right, n2.right);
        return left && right;
    }
}

/*
    Time Complexity: O(n*m) where n is the number of nodes in tree s and m is the number of nodes in tree t
    Space Complexity: O(Math.max(log(n), log(m))) for balanced tree and O(Math.max(n, m)) for skewed tree where n is the height of the tree s and m is the height of tree t
*/