//https://leetcode.com/problems/count-number-of-teams/

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
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> nodes = new ArrayList<>(); 
        List<Integer> toDeleteList = new ArrayList<>();
        for(int num : to_delete) {
            toDeleteList.add(num);
        }
        postorder(root, toDeleteList, nodes);
        if(root != null && !toDeleteList.contains(root.val)) {
            nodes.add(root);
        }
        return nodes;
    }
    
    public TreeNode postorder(TreeNode root, List<Integer> toDelete, List<TreeNode> nodes) {
        if(root == null) {
            return null;
        }  
        root.left = postorder(root.left, toDelete, nodes);
        root.right = postorder(root.right, toDelete, nodes);
        if(toDelete.contains(root.val)) {
            if(root.left != null) {
                nodes.add(root.left);
            }
            if(root.right != null) {
                nodes.add(root.right);
            }
            return null;
        }
        return root;
    }
}

/*
    Time Complexity: O(n + m) where n is the number of nodes in the tree root and m is the length of the input array to_delete
    Space Complexity: Auxiliary space: O(n) where n is the length of the input array to_delete Stack space: O(log(n)) for balanced tree and O(n) for skewed tree where n is the height of the tree 
*/