//https://leetcode.com/problems/swap-nodes-in-pairs/

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
    public ListNode swapPairs(ListNode head) {
        boolean second = false;
        ListNode current = head;
        ListNode link = null;
        ListNode prev = null;
        boolean firstNode = true;
        ListNode first = head;
        while(current != null) {
            if(!second) {
                prev = current;
                current = current.next;
                second = true;
            }
            else {
                if(firstNode) {
                    first = current;
                    firstNode = false;
                }
                ListNode temp = current.next;
                current.next = prev;
                prev.next = temp;
                if(link != null) {
                    link.next = current;    
                }
                link = prev;
                current = temp;
                second = false;
            }
        }
        return first;
    }
}

/*
    Time Complexity: O(n) where n is the length of the linked list
    Space Complexity: O(1)
*/