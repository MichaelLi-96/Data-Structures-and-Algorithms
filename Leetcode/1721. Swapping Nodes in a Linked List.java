//https://leetcode.com/problems/swapping-nodes-in-a-linked-list/

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
    public ListNode swapNodes(ListNode head, int k) {
        ListNode node1 = head;
        int count = 1;
        while(count != k) {
            node1 = node1.next;
            count++;
        }
        ListNode end = head;
        ListNode node2 = head;
        count = 1;
        while(end != null) {
            end = end.next;
            if(count > k) {
                node2 = node2.next;
            }
            count++;
        }
        
        int temp = node1.val;
        node1.val = node2.val;
        node2.val = temp;
        return head;
    }
}

/*
    Time Complexity: O(n) where n is the number of nodes in the linked list
    Space Complexity: O(1)
*/