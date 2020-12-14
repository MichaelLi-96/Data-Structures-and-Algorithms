//https://leetcode.com/problems/next-greater-node-in-linked-list/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[] nextLargerNodes(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while(head != null) {
            list.add(head.val);
            head = head.next;
        }
        
        Stack<Integer> stack = new Stack<>();
        int[] arr = new int[list.size()];
        for(int i = list.size() - 1; i >= 0; i--) {
            while(!stack.isEmpty() && list.get(i) >= stack.peek()) {
                stack.pop();
            }
            if(!stack.isEmpty()) {
                arr[i] = stack.peek();
            }
            stack.push(list.get(i));
        }
        return arr;
    }
}

/*
    Time Complexity: O(n) where n is the number of nodes in the linked list
    Space Complexity: O(n) where n is the number of nodes in the linked list
*/