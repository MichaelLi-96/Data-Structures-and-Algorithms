//https://leetcode.com/problems/binary-tree-paths/

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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<>();
        preorder(root, new StringBuilder(), list);
        return list;
    }
    
    public void preorder(TreeNode root, StringBuilder str, List<String> list) {
        if(root == null) {
            return;
        }
        int length = str.length();
        str.append(root.val);
        if(root.left != null || root.right != null) {
             str.append("->");     
        }
        else {
            list.add(str.toString());
        }
        preorder(root.left, str, list);
        preorder(root.right, str, list);
        str.setLength(length); 
    }
}

/*
	Time Complexity: O(n) where n is the number of nodes in the tree
	Space Complexity: O(log(n)) for balanced tree and O(n) for skewed tree where n is the height of the tree 
*/