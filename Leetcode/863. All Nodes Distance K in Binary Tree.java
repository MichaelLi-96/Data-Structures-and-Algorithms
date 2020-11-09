//https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/submissions/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        Map<TreeNode, TreeNode> parents = new HashMap<>();
        mapParents(root, null, parents);
        return bfs(target, parents, K);
        
    }
    
    public void mapParents(TreeNode root, TreeNode parent, Map<TreeNode, TreeNode> parents) {
        if(root == null) {
            return;
        }
        if(parent != null) {
            parents.put(root, parent);
        }
        else {
            parents.put(root, null);
        }
        mapParents(root.left, root, parents);
        mapParents(root.right, root, parents);   
    }
    
    public List<Integer> bfs(TreeNode root, Map<TreeNode, TreeNode> parents, int K) {
        List<Integer> list = new ArrayList<>();
        List<TreeNode> seen = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 0;
        while(!queue.isEmpty() && level <= K) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if(level == K) {
                    list.add(node.val);
                }
                seen.add(node);
                TreeNode parent = parents.get(node);
                if(parent != null && !seen.contains(parent)) {
                    queue.add(parent);
                }
                if(node.left != null && !seen.contains(node.left)) {
                    queue.add(node.left);
                }
                if(node.right != null && !seen.contains(node.right)) {
                    queue.add(node.right);
                }
            }
            level++;
        }
        return list;
    }
}

/*
	Time Complexity: O(n) where n is the number of nodes in the binary tree
	Space Complexity: O(n) auxiliary space, O(log(n)) for balanced tree O(n) for skewed tree stack space (recursion) where n is the number of nodes in the binary tree
*/