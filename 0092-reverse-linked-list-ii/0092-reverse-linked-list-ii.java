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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || head.next == null || left == right) {
            return head;
        }
        
        // Dummy node to simplify the logic
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        // Find the node before the left node
        ListNode prev = dummy;
        for (int i = 0; i < left - 1; i++) {
            prev = prev.next;
        }
        
        // Reverse the nodes from left to right
        ListNode curr = prev.next; // the left node
        for (int i = 0; i < right - left; i++) {
            // Cut out the next node and insert it after prev
            ListNode next = curr.next;
            curr.next = next.next;
            next.next = prev.next;
            prev.next = next;
        }
        
        // Return the new head
        return dummy.next;
    }
}
