public class Solution {
    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num: nums){
            if(map.containsKey(num)) continue;
            if(map.containsKey(num-1)){
                map.put(num-1, num);
            }
            if(map.containsKey(num+1) && num<num+1){
                map.put(num, num+1);
            }else{
                map.put(num, null);
            }
            
        }
        int result = 0;
        for(int num: nums){
            int tail = num;
            while(map.containsKey(tail)){
                if(map.get(tail)==null){
                    map.remove(tail);
                    break;
                }
                int temp = map.get(tail);
                map.remove(tail);
                tail = temp;
            }
            map.put(num, tail);
            result = Math.max(result, tail-num+1);
        }
        return result;
    }
}