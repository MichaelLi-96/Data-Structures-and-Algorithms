//https://leetcode.com/problems/palindrome-linked-list/

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
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        if(fast != null) {
            slow = slow.next;
        }
        ListNode headA = reverseLinkedList(slow);
        ListNode headB = head;
        
        while(headA != null && headB != null) {
            if(headA.val != headB.val) {
                return false;
            }
            headA = headA.next;
            headB = headB.next;
        }
        return true;
    }
    
    public ListNode reverseLinkedList(ListNode head) {
        ListNode prev = null;
        while(head != null) {
            ListNode temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }
        
        return prev;
    }
}


/*
	Time Complexity: O(3(n/2)) -> O(n) where n is the number of nodes in the linked list
	Space Complexity: O(1)
*/