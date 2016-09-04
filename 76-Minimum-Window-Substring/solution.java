public class Solution {
    public String minWindow(String s, String t) {
        int head = 0, tail = 0, cnt = 0;
        int[] result = new int[2];
        result[1] = Integer.MAX_VALUE;
        Map<Character, Integer> map = new HashMap<>(), c = new HashMap<>();
        for(char cr: t.toCharArray()){
            set.put(cr, map.getOrDefault(cr, 0)+1);
        }
        while(tail<=s.length){
            if(cnt<t.length()){
                char t = s.charAt(tail);
                if(map.containsKey(t)){
                    c.put(t, c.getOrDefault(t)+1);
                    if(c.get(t)<=map.get(t))    cnt++;
                }
                tail++;
            }else{
                if(tail-head<result[1]-result[0]){
                    result[1] = tail;
                    result[0] = head;
                }
                char t = s.charAt(head);
                if(map.containsKey(t)){
                    c.put(t, c.get(t)-1);
                    if(map.get(t)>c.get(t)) cnt--;
                }  
                head++;
            }
        }
        return s.substring(result[0], result[1]);
    }
}