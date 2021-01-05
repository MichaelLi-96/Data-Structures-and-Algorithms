//https://leetcode.com/problems/smallest-subtree-with-all-the-deepest-nodes/

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
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        Map<TreeNode, TreeNode> mapToParent = new HashMap<>();
        mapToParent.put(root, root);
        List<TreeNode> lastRow = new ArrayList<>(); 
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                lastRow.add(node);
                if(node.left != null) {
                    mapToParent.put(node.left, node);
                    queue.add(node.left);
                }
                if(node.right != null) {
                    mapToParent.put(node.right, node);
                    queue.add(node.right);
                }
            }
            if(!queue.isEmpty()) {
                lastRow.clear();
            }
        }
        Set<TreeNode> currentNodes = new HashSet<>();
        for(TreeNode lastRowNode : lastRow) {
            currentNodes.add(lastRowNode);
        } 
        
        while(currentNodes.size() != 1) {
            Set<TreeNode> parents = new HashSet<>();
            for(TreeNode node : currentNodes) {
                parents.add(mapToParent.get(node));
            }
            currentNodes = parents;
        }
        return currentNodes.iterator().next();
    }
}

/*
    Time Complexity: O(3n) -> O(n) where n is the number of nodes in the tree  
    Space Complexity: O(4n) -> O(n) where n is the number of nodes in the tree
*/

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
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        Map<TreeNode, TreeNode> mapToParent = new HashMap<>();
        mapToParent.put(root, root);
        List<TreeNode> lastRow = new ArrayList<>(); 
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                lastRow.add(node);
                if(node.left != null) {
                    mapToParent.put(node.left, node);
                    queue.add(node.left);
                }
                if(node.right != null) {
                    mapToParent.put(node.right, node);
                    queue.add(node.right);
                }
            }
            if(!queue.isEmpty()) {
                lastRow.clear();
            }
        }
        Set<TreeNode> currentNodes = new HashSet<>();
        for(TreeNode lastRowNode : lastRow) {
            currentNodes.add(lastRowNode);
        } 
        
        while(currentNodes.size() != 1) {
            Set<TreeNode> parents = new HashSet<>();
            for(TreeNode node : currentNodes) {
                parents.add(mapToParent.get(node));
            }
            currentNodes = parents;
        }
        return currentNodes.iterator().next();
    }
}

/*
    Time Complexity: O(3n) -> O(n) where n is the number of nodes in the tree  
    Space Complexity: O(4n) -> O(n) where n is the number of nodes in the tree
*/

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
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        Map<TreeNode, Integer> depths = new HashMap<>();
        mapDepth(root, 1, depths);
        int maxDepth = 0;
        for(Integer depth : depths.values()) {
            maxDepth = Math.max(maxDepth, depth);
        }
        return findSubtree(root, maxDepth, depths);
    }
    
    public void mapDepth(TreeNode node, int currentDepth, Map<TreeNode, Integer> depths) {
        if(node == null) {
            return;
        }
        depths.put(node, currentDepth);
        mapDepth(node.left, currentDepth + 1, depths);
        mapDepth(node.right, currentDepth + 1, depths);
    }
    
    public TreeNode findSubtree(TreeNode node, int maxDepth, Map<TreeNode, Integer> depths) {
        if(node == null || depths.get(node) == maxDepth) {
            return node;
        }
        TreeNode left = findSubtree(node.left, maxDepth, depths);
        TreeNode right = findSubtree(node.right, maxDepth, depths);
        if(left != null && right != null) {
            return node;
        }
        if(left != null) {
            return left;
        }
        if(right != null) {
            return right;
        }
        return null;
    }
}

/*
    Time Complexity: O(n) where n is the number of nodes in the tree
    Space Complexity: O(n) auxiliary space where n is the number of nodes in the tree, 
                      O(log(n)) stack space for balanced tree and O(n) stack space for skewed tree where n is the height of the tree 
*/