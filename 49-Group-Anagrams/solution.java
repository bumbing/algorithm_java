public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<List<String>>();
        Map<String, Integer> map = new HashMap<>();
        for(String str: strs){
            String temp = sortString(str);
            if(map.containsKey(temp)){
                result.get(map.get(temp)).add(str);
            }else{
                map.put(temp, result.size());
                List<String> strings = new ArrayList<String>();
                strings.add(str);
                result.add(strings);
            }
            
        }
        return result;
    }
    
    private String sortString(String str){
        char[] ar = str.toCharArray();
        Arrays.sort(ar);
        return String.valueOf(ar);
    }
}