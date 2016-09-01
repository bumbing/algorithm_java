/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void reorderList(ListNode head) {
        if(head==null)  return;
        ListNode p1 = head, p2 = head;
        while(p2!=null && p2.next!=null){
            p2 = p2.next.next;
            p1 = p1.next;
        }
        p2 = reverse(p1.next);
        p1.next = null;//need to handle it point to null
        p1 = head;
        while(p1!=null && p2!=null){
            ListNode tmp = p1.next;
            p1.next = p2;
            p2 = p2.next;
            p1.next.next = tmp;
            p1 = tmp;
        }
        return;
    }
    
    public ListNode reverse(ListNode head){
        if(head==null)  return head;
        ListNode p1 = null;
        while(head!=null){
            ListNode tmp = head.next;
            head.next = p1;
            p1 = head;
            head = tmp;
        }
        return p1;
        //Need to point the tail(initially as head) to null pointer
    }
}