public class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int result = 0;
        int chars = 0, index;
        Map<Character, Integer> map = new HashMap<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int head = 0, tail = 0;
        while(tail<s.length()){
            if(chars<2 || index>=head){
                index = map.getOrDefault(s.charAt(tail), -1);
                if(index<head){
                    chars++;
                }
                if(index!=-1)   pq.remove(index);
                pq.offer(tail);
                map.put(s.charAt(tail), tail);
                tail++;
                result = Math.max(result, tail-head+1);
            }else{
                index = map.getOrDefault(s.charAt(head), -1);
                if(index == head){
                    pq.remove(index);
                    map.remove(index);
                }
                head++;
            }
        }
        return result;
    }
}