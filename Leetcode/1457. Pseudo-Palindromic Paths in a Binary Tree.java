//https://leetcode.com/problems/pseudo-palindromic-paths-in-a-binary-tree/

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
    public int pseudoPalindromicPaths (TreeNode root) {
        List<int[]> list = new ArrayList<>();
        preorder(root, new int[10], list);
        int count = 0;
        for(int[] path : list) {
            int hit = 0;
            boolean allEven = true;
            for(int num : path) {
                if(num % 2 != 0) {
                    hit++;
                    allEven = false;
                }
            }
            if(hit == 1 || allEven) {
                count++;
            }
        }
        return count;
    }
    
    public void preorder(TreeNode root, int[] vals, List<int[]> list) {
        if(root == null) {
            return;
        }
        vals[root.val]++;
        if(root.left == null && root.right == null) {
            list.add(vals.clone());
        }
        preorder(root.left, vals, list);
        preorder(root.right, vals, list);
        vals[root.val]--;
    }
}

/*
    Time Complexity: O(n) where n is the number of nodes in the tree
    Space Complexity: Auxiliary: O(n) where n is the number of paths that exist from root to leaf node | Stack space: O(log(n)) for balanced tree and O(n) for skewed tree where n is the height of the tree 
*/