class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode smallerHead = new ListNode(0);
        ListNode smaller = smallerHead;
        ListNode greaterOrEqualHead = new ListNode(0);
        ListNode greaterOrEqual = greaterOrEqualHead;
        
        ListNode curr = head;
        
        while (curr != null) {
            if (curr.val < x) {
                smaller.next = curr;
                smaller = smaller.next;
            } else {
                greaterOrEqual.next = curr;
                greaterOrEqual = greaterOrEqual.next;
            }
            curr = curr.next;
        }
        
        smaller.next = greaterOrEqualHead.next;
        greaterOrEqual.next = null; 
        
        return smallerHead.next;
    }
}