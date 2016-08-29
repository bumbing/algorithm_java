public class Solution {
    public char findTheDifference(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for(int i=0; i<t.length(); i++){
            char tmp = t.charAt(i);
            map.put(tmp, map.getOrDefault(tmp, 0)+1);
        }
        for(int i=0; i<s.length(); i++){
            char tmp = s.charAt(i);
            if(map.get(tmp)!=1){
                map.put(tmp, map.get(tmp)-1);
            }else{
                map.remove(tmp);
            }
        }
        for(char c: map.keySet()){
            return c;
        }
    }
}