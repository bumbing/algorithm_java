/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        //two pass algorithm without hashmap
        RandomListNode temp = new RandomListNode(0);
        temp.next = head;
        while(head != null)
        {
            //Copy an same node
            RandomListNode copyNode = new RandomListNode(head.label);
            copyNode.next = head.next;
            head.next = copyNode;
            //Advance pointer to next one to copy
            head = head.next.next;
        }
        
        head = temp.next;
        while(head != null){
            if(head.random != null)
            head.next.random = head.random.next;
            
            head = head.next.next;
        }
        
        head = temp.next;
        RandomListNode temp2 = new RandomListNode(0), head2 = temp2;
        while(head!=null){
            head2.next = head.next;
            head.next = head.next.next;
            
            head = head.next;
            head2 = head2.next;
        }
        return temp2.next;
    }
}