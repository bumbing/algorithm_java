public class Solution {
    public boolean isAnagram(String s, String t) {
        if(s == null || t == null || s.length() != t.length())  return false;
        Map<Character, Integer> map = new HashMap<>();
        for(int i=0; i<s.length(); i++){
            char temp = s.charAt(i);
            if(map.containsKey(temp))   map.put(temp, map.get(temp)+1);
            else    map.put(temp, 1);
        }
        for(int i=0; i<s.length(); i++){
            char temp = t.charAt(i);
            if(!map.containsKey(temp))  return false;
            else if(map.get(temp)==1)   map.remove(temp);
            else map.put(temp, map.get(temp)-1);
        }
        return map.isEmpty();
    }
}