//https://leetcode.com/problems/leaf-similar-trees/

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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> bottomRow = new ArrayList<>();
        findBottomRow(root1, bottomRow);
        return compareBottomRow(root2, bottomRow) && bottomRow.size() == 0;
    }
    
    public void findBottomRow(TreeNode root, List<Integer> list) {
        if(root == null) {
            return;
        }
        if(root.left == null && root.right == null) {
            list.add(root.val);
        }
        findBottomRow(root.left, list);
        findBottomRow(root.right, list);
    }
    
    public boolean compareBottomRow(TreeNode root, List<Integer> list) {
        if(root == null) {
            return true;
        }
        if(root.left == null && root.right == null) {
            if(list.size() == 0) {
                return false;
            }
            int val = list.remove(0);
            if(root.val == val) {
                return true;
            }
            return false; 
        }
        boolean left = compareBottomRow(root.left, list);
        boolean right = compareBottomRow(root.right, list);
        return left && right;
    }
}

/*
    Time Complexity: O(n + m) where n is the number of nodes in the tree root1 and m is the number of nodes in the tree root2
    Space Complexity: O(n) auxillary space, O(log(n)) for balanced tree O(n) for skewed tree stack space 
*/