public class Solution {
    public int maxSubArray(int[] nums) {
        if(nums.length==0)  return 0;
        int[] sum = new int[nums.length];
        int min = 0;
        int result = nums[0];
        for(int i=0; i<nums.length; i++){
            if(i==0){
                sum[i] = nums[i];
            }else{
                sum[i] = sum[i-1] + nums[i];
            }
            result = Math.max(result, sum[i]-min);
            min = Math.min(min, sum[i]);
            
        }
        return result;
    }
}