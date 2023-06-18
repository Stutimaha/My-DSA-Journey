class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        int carry = 0;

        while (l1 != null || l2 != null) {
            int sum = carry;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            carry = sum / 10;
            int digit = sum % 10;
            ListNode newNode = new ListNode(digit);
            current.next = newNode;
            current = current.next;
        }

        if (carry > 0) {
            ListNode newNode = new ListNode(carry);
            current.next = newNode;
        }

        return dummy.next;
    }
}
