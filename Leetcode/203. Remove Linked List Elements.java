//https://leetcode.com/problems/remove-linked-list-elements/

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
    public ListNode removeElements(ListNode head, int val) {
        ListNode prev = new ListNode(0);
        prev.next = head;
        ListNode cur = head;
        ListNode beforeHead = prev;
        while(cur != null) {
            if(cur.val == val) {
                prev.next = cur.next;
            }
            else {
                prev = prev.next;
            }
            cur = cur.next;
        }
        return beforeHead.next;
    }
}

/*
    Time Complexity: O(n) where n is the length of the linkedlist
    Space Complexity: O(1)