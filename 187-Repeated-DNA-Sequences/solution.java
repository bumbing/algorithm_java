public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        Map<String, Integer> map = new HashMap<>();
        List<String> result = new ArrayList<String>();
        int head = 0;
        if(s.length() < 10) return result;
        while(head + 10 <= s.length()){
            String temp = s.substring(head, head+10);
            if(map.containsKey(temp)){
                map.put(temp, map.get(temp)+1);
            }else{
                map.put(temp, 1);
            }
            head++;
        }
        for (String key : map.keySet()) {
            if(map.get(key) > 1)    result.add(key);
        }
        return result;
    }
}