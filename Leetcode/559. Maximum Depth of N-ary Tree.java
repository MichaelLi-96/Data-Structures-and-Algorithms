//https://leetcode.com/problems/maximum-depth-of-n-ary-tree/submissions/

/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public int maxDepth(Node root) {
        if(root == null) {
            return 0;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        int level = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                Node nd = queue.poll();
                for(int j = 0; j < nd.children.size(); j++) {
                    queue.add(nd.children.get(j));
                }
            }
            level++;
        }
        return level;
    }
}

/*
	Time Complexity: O(n) where n is the number of nodes in the tree
	Space Complexity: O(n) where n is the number of nodes in the tree
*/