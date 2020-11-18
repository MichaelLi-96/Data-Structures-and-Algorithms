//https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/submissions/

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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) {
            return null;
        }
        int parentVal = root.val;
        int pVal = p.val; 
        int qVal = q.val;
        if(pVal < parentVal && qVal < parentVal) {
            return lowestCommonAncestor(root.left, p, q);
        }
        else if(pVal > parentVal && qVal > parentVal) {
            return lowestCommonAncestor(root.right, p, q);
        }
        else {
            return root;
        }
    }
}

/*
    Time Complexity: O(n) where n is the number of nonoverlapping nodes in the tree
    Space Complexity: O(log(n)) for balanced tree and O(n) for skewed tree where n is the height of the tree 
*/