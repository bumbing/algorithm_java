public class Solution {
    public int maxSubArray(int[] nums) {
        if(nums.length==0)  return 0;
        int sum = 0, min = 0, result = nums[0];
        for(int i=0; i<nums.length; i++){
            sum += nums[i];
            result = Math.max(result, sum-min);
            min = Math.min(min, sum);
        }
        return result;
    }
}