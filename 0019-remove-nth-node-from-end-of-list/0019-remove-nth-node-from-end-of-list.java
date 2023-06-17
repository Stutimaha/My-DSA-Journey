class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Handle the case when the head node is null
        if (head == null) {
            return null;
        }
        
        // Create a dummy node to handle the case when the target node is the head node
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode curr = head;
        int length = 0;
        
        // Calculate the length of the linked list
        while (curr != null) {
            length++;
            curr = curr.next;
        }
        
        // Handle the case when n is equal to the length of the linked list
        if (n == length) {
            return head.next;
        }
        
        ListNode removeNext = head;
        
        // Find the node before the target node to be removed
        for (int i = 0; i < length - n-1; i++) {
            removeNext = removeNext.next;
        }
        
        // Remove the target node
        removeNext.next = removeNext.next.next;
        
        return head;
    }
}
