/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode plusOne(ListNode head) {
        ListNode firstNone9 = null;
        ListNode cur = head;
        while(cur!=null){
            if(cur.val!=9)  firstNone9=cur;
            cur = cur.next;
        }
        if(cur==null){
            firstNone9 = new ListNode(0);
            firstNone9.next = head;
            head = firstNone9;
        }
        
        while(firstNone9!=null){
            firstNone9.val = firstNone9.val + 1;
            firstNone9 = firstNone9.next;
        }
        return head;
    }
}