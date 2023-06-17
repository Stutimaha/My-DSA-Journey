class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode slow = dummy;
        ListNode fast = dummy;

        // Move the fast pointer n+1 steps ahead
        for (int i = 0; i <= n; i++) {
            if (fast == null) {
                // Handle the case when n is greater than the length of the linked list
                return head;
            }
            fast = fast.next;
        }

        // Move both slow and fast pointers until fast reaches the end
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        // Remove the nth node from the end
        slow.next = slow.next.next;

        return dummy.next;
    }
}
