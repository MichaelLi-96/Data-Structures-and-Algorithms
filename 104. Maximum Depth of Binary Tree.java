//https://leetcode.com/problems/maximum-depth-of-binary-tree/

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
    public int maxDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        
        Queue<TreeNode> bfsQueue = new LinkedList<>();
        bfsQueue.add(root);
        int depth = 0;
        while(!bfsQueue.isEmpty()) {
            int size = bfsQueue.size();
            for(int i = 0; i < size; i++) {
                TreeNode node = bfsQueue.poll();
                if(node.left != null) {
                    bfsQueue.add(node.left);
                }
                if(node.right != null) {
                     bfsQueue.add(node.right);
                }
            }
            depth++;
        }
        
        return depth;
    }
}
/*
	Time Complexity: O(n) where n is the number of nodes in the tree
	Space Complexity: O(n) where n is the number of nodes in the tree
*/