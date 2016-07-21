public class Solution {
    public boolean wordPattern(String pattern, String str) {
        String[] strs = str.split(" ");
        if(pattern.length() != strs.length) return false;
        Map<Character, String> map = new HashMap<>(); 
        for(int i=0; i<pattern.length(); i++){
            char tmp = pattern.charAt(i);
            if(map.containsKey(tmp)){
                if(!map.get(tmp).equals(strs[i]))   return false;
            }else{
                if(map.containsValue(strs[i]))  return false;
                map.put(tmp, strs[i]);
            }
        }
        return true;
    }
}