//https://leetcode.com/problems/flip-equivalent-binary-trees/

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
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        if(root1 == null && root2 == null) {
            return true;
        }
        if(root1 == null && root2 != null || root1 != null && root2 == null || root1.val != root2.val) {
            return false;
        }
        
        boolean notFlipped = flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right);
        boolean flipped = flipEquiv(root1.left, root2.right) && flipEquiv(root1.right, root2.left);
        return notFlipped || flipped;
    }
}

/*
    Time Complexity: O(n) where n is the number of nodes in the tree of the longest height between root1 and root2
    Space Complexity: O(log(n)) for balanced tree and O(n) for skewed tree where n is the height of the tree 
*/
