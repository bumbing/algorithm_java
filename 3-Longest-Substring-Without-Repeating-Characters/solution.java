public class Solution {
    public int lengthOfLongestSubstring(String s) {
        //two pointer
        char[] array = s.toCharArray();
        int result = 0, index1 = 0, index2 = 0;
        Map<Character, Integer> map = new HashMap<>();
        while(index2 <= array.length-1){
            if(map.containsKey(array[index2])){
                int tmp = map.get(array[index2]);
                if(tmp >= index1)   index1 = tmp+1;
            }
            
            map.put(array[index2], index2);
            result = Math.max(result, index2 - index1 + 1);
            index2++;
        }
        return result;
        
    }
}