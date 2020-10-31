//https://leetcode.com/problems/intersection-of-two-linked-lists/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a = headA;
        ListNode b = headB;
        boolean aHitEnd = false;
        boolean bHitEnd = false;
        while(a != null && b != null) {
            if(a == b) {
                return a;
            }
            a = a.next;
            b = b.next;
            if(!aHitEnd && a == null) {
                a = headB;
                aHitEnd = true;
            }
            if(!bHitEnd && b == null) {
                b = headA;
                bHitEnd = true;
            }
        }
        return null;
    }
}

/*
	Time Complexity: O(n + m) where n is the number of nodes in LinkedList A and m is the number of nodes in LinkedList B
	Space Complexity: O(1)
*/