/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    //Two solutions, one is use hashmap, the other is use O(1) extra space
    public RandomListNode copyRandomList(RandomListNode head) {
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode temp1 = new RandomListNode(0), temp2 = new RandomListNode(0), head2 = temp2;
        temp1.next = head;
        while(temp1.next != null){
            if(map.containsKey(temp1.next) ){
                head2.next = map.get(temp1.next);
            }else{
                head2.next = new RandomListNode(temp1.next.label);
                map.put(temp1.next, head2.next);
            }
            
            if(temp1.next.random != null)
            {
                if(map.containsKey(temp1.next.random) )
                {
                    head2.next.random = map.get(temp1.next.random);
                }
                else
                {
                    head2.next.random = new RandomListNode(temp1.next.random.label);
                    map.put(temp1.next.random, head2.next.random);
                }
            }
            temp1 = temp1.next;
            head2 = head2.next;
        }
        return temp2.next;
    }
}