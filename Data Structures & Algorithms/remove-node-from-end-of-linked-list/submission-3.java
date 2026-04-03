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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int c=0;
        ListNode curr=head;

        while(curr!=null){
            curr=curr.next;
            c++;
        }

        if(n==c)return head.next;

        curr=head;

        for(int i=0;i<c-n-1;i++){
            curr=curr.next;
        }

        curr.next=curr.next.next;

        return head;
    }
}
