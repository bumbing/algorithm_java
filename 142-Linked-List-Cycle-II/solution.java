/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode cur=head, cur2=head;
        while(cur2!=null && cur2.next!=null){
            cur = cur.next;
            cur2 = cur2.next.next;
            if(cur==cur2)   break;
        }
        if(cur2==null || cur2.next==null)   return null;
        cur = head;
        while(cur!=cur2){
            cur = cur.next;
            cur2 = cur2.next;
            if(cur==cur2)   break;
        }
        return cur;
    }
}