/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(k<=1)    return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode root =dummy, cur = dummy;
        int cnt = k;
        while(cur!=null){
            if(cnt!=0){
                cur = cur.next;
                cnt--;
            }  
            else{
                cnt = k;
                ListNode tail = cur.next;
                cur.next = null;
                //Need to reverse from root.next to cur
                ListNode temp = reverse(root, root.next);
                temp.next = tail;
                root = temp;
                cur = temp;
            }
        }
        return dummy.next;
    }
    
    public ListNode reverse(ListNode root, ListNode p1){
        ListNode p2 = null, result = p1;
        while(p1!=null){
            ListNode temp = p1.next;
            p1.next = p2;
            p2 = p1;
            p1 = temp;
        }
        root.next = p2;
        return result;
    }
}