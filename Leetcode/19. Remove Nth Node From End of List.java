//https://leetcode.com/problems/remove-nth-node-from-end-of-list/

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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode beforeHead = new ListNode(0);
        beforeHead.next = head;
        ListNode slow = beforeHead;
        ListNode fast = beforeHead;
        
        while(n >=0) {
            fast = fast.next;
            n--;
        }
        
        while(fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return beforeHead.next;
    }
}

/*
	Time Complexity: O(n) where n is the number of nodes in the linkedlist
	Space Complexity: O(1)
*/