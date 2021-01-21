//https://leetcode.com/problems/add-two-numbers/

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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode beforeHead = new ListNode(0);
        ListNode prev = beforeHead;
        boolean carry = false;
        while(l1 != null && l2 != null) {
            int sum = l1.val + l2.val;
            if(carry) {
                sum += 1;
                carry = false;
            }
            if(sum >= 10) {
                carry = true;
                sum %= 10;
            }
            ListNode node = new ListNode(sum);
            prev.next = node;
            prev = node;
            l1 = l1.next;
            l2 = l2.next;
        }
        if(l1 == null && l2 != null) {
            while(l2 != null) {
                int val = l2.val;
                if(carry) {
                    val += 1;
                    carry = false;
                }
                if(val >= 10) {
                    carry = true;
                    val %= 10;
                }
                ListNode node = new ListNode(val);
                prev.next = node;
                prev = node;
                l2 = l2.next;
            }
        }
        if(l2 == null && l1 != null) {
             while(l1 != null) {
                int val = l1.val;
                if(carry) {
                    val += 1;
                    carry = false;
                }
                if(val >= 10) {
                    carry = true;
                    val %= 10;
                }
                ListNode node = new ListNode(val);
                prev.next = node;
                prev = node;
                 l1 = l1.next;
            }
        }
        if(carry) {
            ListNode node = new ListNode(1);
            prev.next = node;
        }
        return beforeHead.next;
    }
}

/*
    Time Complexity: O(n) where n is the greater length of the two input linkedlists
    Space Complexity: O(n) where n is the greater length of the two input linkedlists
*/
