//https://leetcode.com/problems/all-elements-in-two-binary-search-trees/

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
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        inorderTraversal(root1, list1);
        inorderTraversal(root2, list2);
        List<Integer> list = new ArrayList<>();
        int i = 0;
        int j = 0;
        while(i < list1.size() || j < list2.size()) {
            if(i == list1.size()) {
                list.add(list2.get(j));
                j++;
            }
            else if(j == list2.size()) {
                list.add(list1.get(i));
                i++;
            }
            else if(list1.get(i) <= list2.get(j)){
                list.add(list1.get(i));
                i++;
            }
            else {
                list.add(list2.get(j));
                j++;
            }
        }
        return list;
    }
    
    public void inorderTraversal(TreeNode root,  List<Integer> list) {
        if(root == null) {
            return;
        }
        inorderTraversal(root.left, list);
        list.add(root.val);
        inorderTraversal(root.right, list);
    }
}
/*
    Time Complexity: O(2n) -> O(n) where n is the total number of nodes of both trees
    Space Complexity: O(2n) -> O(n) where n is the total number of nodes of both trees
*/