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
    public void reorderList(ListNode head) {
        ListNode slow=head;
        ListNode fast=head.next;

        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }

        ListNode cur2=slow.next;
        ListNode prev=slow.next=null;

        while(cur2!=null){
            ListNode temp=cur2.next;
            cur2.next=prev;
            prev=cur2;
            cur2=temp;
        }

        ListNode cur1=head;
        cur2=prev;

        while(cur2!=null){
            ListNode tp1=cur1.next;
            ListNode tp2=cur2.next;
            cur1.next=cur2;
            cur2.next=tp1;
            cur1=tp1;
            cur2=tp2;
        }
    }
}
