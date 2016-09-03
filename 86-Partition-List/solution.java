/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode d1 = new ListNode(0), d2 = new ListNode(0);
        ListNode h1 = d1, h2 = d2;
        while(head!=null){
            if(head.val>=x){
                h2.next = head;
                h2 = h2.next;
            } else {
                h1.next = head;
                h1 = h1.next;
            }
            head = head.next;
        }
        h2.next = null;
        h1.next = d2.next;
        return h1.next;
    }
}