//https://leetcode.com/problems/deepest-leaves-sum/

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
    public int deepestLeavesSum(TreeNode root) {
        int lastRowSum = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            int rowCount = 0;
            for(int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                rowCount += node.val;
                if(node.left != null) {
                    queue.add(node.left);
                }
                if(node.right != null) {
                    queue.add(node.right);
                }
            }
            lastRowSum = rowCount;
        }
        return lastRowSum;
    }
}


/*
    Time Complexity: O(n) where n is the number of nodes in the tree 
    Space Complexity: O(n) where n is the number of nodes in the tree 
*/