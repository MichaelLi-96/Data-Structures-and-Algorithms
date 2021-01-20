//https://leetcode.com/problems/linked-list-components/solution/

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
    public int numComponents(ListNode head, int[] G) {
        Set<Integer> set = new HashSet<>();
        for(int num : G) {
            set.add(num);
        }
        
        ListNode current = head;
        int count = 0;
        while(current != null) {
            if(set.contains(current.val) && (current.next == null || !set.contains(current.next.val))) {
                count++;
            }
            current = current.next;
        }
       
        return count;
    }
}

/*
    Time Complexity: O(n + m) where n is the length of input int array G and m is the number of nodes in the linked list
    Space Complexity: O(n) where n is the length of input int array G
*/
