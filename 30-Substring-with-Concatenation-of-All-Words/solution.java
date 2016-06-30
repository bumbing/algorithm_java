public class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if(s == null || words == null || words.length == 0)  return result;
        int len = words[0].length();
        Map<String, Integer> map = new HashMap<>();
        for(String word: words){
            if(map.containsKey(word))   map.put(word, map.get(word)+1);
            else map.put(word, 1);
        }
        for(int i=0; i<len; i++){
            int head = i, tail = i;
            Map<String, Integer> lack = new HashMap<>(map);
            while(tail+len<=s.length() && head <= s.length() - len * words.length){
                String temp = s.substring(tail, tail+len);
                if(!map.containsKey(temp)){
                    head = tail + len;
                    tail = tail + len;
                    lack = new HashMap<>(map);
                    continue;
                }else {
                    while(!lack.containsKey(temp)){
                        String addBack = s.substring(head, head+len);
                        if(lack.containsKey(addBack))   lack.put(addBack, lack.get(addBack)+1);
                        else lack.put(addBack, 1);
                        head += len;
                    }
                    if(lack.get(temp) == 1) lack.remove(temp);
                    else    lack.put(temp, lack.get(temp)-1);
                    tail += len;
                    if(lack.isEmpty())  result.add(head);
                }
            }
        }
        return result;
        
    }
}