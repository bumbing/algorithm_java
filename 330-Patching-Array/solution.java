public class Solution {
    public int minPatches(int[] nums, int n) {
        int max = 1, index = 0, result = 0;
        while(max<=n){
            if(index == nums.length || nums[index]>max){
                max *= 2;
                result++;
            }else{
                max += nums[index++];
            }
        }
        return result;
    }
}