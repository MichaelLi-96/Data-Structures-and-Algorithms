//https://leetcode.com/problems/copy-list-with-random-pointer/

/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        int idx = 0;
        Map<Node, Integer> map1 = new HashMap<>();
        Node prev = null;
        Node beforeClone = new Node(0);
        while(head != null) {
            Node node = new Node(head.val);
            node.random = head.random;
            if(prev == null) {
                beforeClone.next = node;
                prev = node;
            }
            else {
                prev.next = node;
                prev = prev.next;
            }
            map1.put(head, idx);
            idx++;
            head = head.next;
        }
        
        Map<Integer, Node> map2 = new HashMap<>();
        Node clone = beforeClone.next;
        idx = 0;
        while(clone != null) {
            map2.put(idx, clone);
            idx++;
            clone = clone.next;
        }
        clone = beforeClone.next;
        while(clone != null) {
            clone.random = map2.get(map1.get(clone.random));
            clone = clone.next;
        }
        return beforeClone.next;
    }
}

/*
	Time Complexity: O(n) where n is the number of nodes in the linked list
	Space Complexity: O(n) where n is the number of nodes in the linked list
*/