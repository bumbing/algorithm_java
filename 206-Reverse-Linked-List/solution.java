/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null)   return head;
        ListNode cur = null, next = head;
        while(next!=null){
            ListNode temp = next.next;
            next.next = cur;
            cur = next; 
            next = temp;
        }
        return cur;
    }
}