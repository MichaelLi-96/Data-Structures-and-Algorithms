//https://leetcode.com/problems/kth-smallest-element-in-a-bst/

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
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        inorder(root, k, list);
        return list.get(k - 1);
    }
    
    public void inorder(TreeNode root, int k, List<Integer> list) {
        if(root == null) {
            return;
        }
        inorder(root.left, k, list);
        list.add(root.val);
        inorder(root.right, k, list);
    }
}

/*
    Time Complexity: O(n) where n is the number of nodes in the tree
    Space Complexity: auxillary space: O(n) where n is the number of nodes in the tree, stack space: O(log(n)) for balanced tree and O(n) for skewed tree where n is the height of the tree 
*/
