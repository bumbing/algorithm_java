public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        for(int num: nums1) set.add(num);
        List<Integer> result = new ArrayList<>();
        for(int num: nums2){
            if(set.contains(num)){
                set.remove(num);
                result.add(num);
            }
        }
        int[] res = new int[result.size()];
        for(int i=0; i<result.size(); i++){
            res[i] = Integer.valueOf(result.get(i));
        }
        return res;
    }
}