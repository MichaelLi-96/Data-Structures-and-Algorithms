//https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/

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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, inorder, 0, 0, inorder.length - 1);
    }
    
    public TreeNode build(int[] preorder, int[] inorder, int preorderIndex, int left, int right) {
        if(left > right) {
            return null;
        }
        int inorderIndex = -1;
        for(int i = left; i <= right; i++) {
            if(inorder[i] == preorder[preorderIndex]) {
                inorderIndex = i;
            }
        }

        TreeNode node = new TreeNode(preorder[preorderIndex]);
        node.left = build(preorder, inorder, preorderIndex + 1, left, inorderIndex - 1);
        node.right = build(preorder, inorder, preorderIndex + 1 + (inorderIndex - left), inorderIndex + 1, right);
        return node;
    }
}

/*
    Time Complexity: O(n^2) when tree is balanced, O(nlog(n)) when tree is skewed where n is the number of nodes in the tree 
    Space Complexity: O(log(n)) for balanced tree and O(n) for skewed tree where n is the height of the tree 
*/