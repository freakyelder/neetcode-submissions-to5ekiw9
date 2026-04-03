class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int c = 0;
        ListNode curr = head;

        // Count length
        while (curr != null) {
            curr = curr.next;
            c++;
        }

        // Edge case: remove head
        if (n == c) {
            return head.next;
        }

        // Go to (c-n-1)th node
        curr = head;
        for (int i = 0; i < c - n - 1; i++) {
            curr = curr.next;
        }

        // Delete node
        curr.next = curr.next.next;

        return head;
    }
}