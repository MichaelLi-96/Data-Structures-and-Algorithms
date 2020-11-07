//https://leetcode.com/problems/serialize-and-deserialize-binary-tree/submissions/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder str = new StringBuilder();
        preorder(root, str);
        return str.toString();
    }
    
    public void preorder(TreeNode root, StringBuilder str) {
        if(root == null) {
            str.append("n,");
            return;
        }
        str.append(root.val);
        str.append(",");
        preorder(root.left, str);
        preorder(root.right, str);
        
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] nodes = data.substring(0, data.length()).split(",");
        Queue<String> queue = new LinkedList<>();
        for(String node : nodes) {
            queue.add(node);
        }
        return buildTree(queue);
    }
    
    public TreeNode buildTree(Queue<String> queue) {
        String val = queue.poll();
        if(val.equals("n")) {
            return null;
        }
        TreeNode node = new TreeNode(Integer.valueOf(val));
        node.left = buildTree(queue);
        node.right = buildTree(queue);
        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));

/*
	Time Complexity: O(n) for serialize and O(n) for buildTree
	Space Complexity: O(log(n)) for serialize and O(n) for buildTree
*/