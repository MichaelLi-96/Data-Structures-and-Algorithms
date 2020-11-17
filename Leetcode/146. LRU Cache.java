//https://leetcode.com/problems/lru-cache/

class Node {
    int key;
    int val;
    Node prev;
    Node next;
    
    public Node(int key, int val) {
        this.key = key;
        this.val = val;
        prev = null;
        next = null;
    }
}

class LRUCache {
    Map<Integer, Node> map;
    Node head;
    Node tail;
    int capacity;
    
    public LRUCache(int capacity) {
        this.map = new HashMap<>();
        this.head = new Node(0, 0);
        this.tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)) {
            return -1;
        }
        Node node = map.get(key);
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
        putNodeAsMostRecent(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        if(!map.containsKey(key)) {
            Node node = new Node(key, value);
            map.put(key, node);
            putNodeAsMostRecent(node);
        }
        else {
            Node node = map.get(key);
            node.val = value;
            Node prev = node.prev;
            Node next = node.next;
            prev.next = next;
            next.prev = prev;
            putNodeAsMostRecent(node);
        }
        
        if(map.size() > capacity) {
            Node lruNode = tail.prev;
            Node prev = lruNode.prev;
            prev.next = tail;
            tail.prev = prev;
            map.remove(lruNode.key);
        }
    }
    
    public void putNodeAsMostRecent(Node node) {
        Node firstNode = head.next;
        head.next = node;
        node.prev = head;
        node.next = firstNode;
        firstNode.prev = node;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

/*
    Time Complexity: O(1) for get and put methods
    Space Complexity: O(n) where n is the capacity
*/