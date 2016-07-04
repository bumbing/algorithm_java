/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode oddEvenList(ListNode head) {
        if(head==null)  return null;
        ListNode head2 = new ListNode(0), cur = head2;
        ListNode head1 = new ListNode(0);
        head1.next = head;
        while(head.next != null && head.next.next != null){
            cur.next = head.next;
            cur = cur.next;
            head.next = head.next.next;
            head = head.next;
        }
        cur.next = head.next;
        head.next = head2.next;
        return head1.next;
    }
}