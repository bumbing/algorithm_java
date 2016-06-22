public class Solution {
    public int rob(int[] nums) {
        if(nums.length==0)  return 0;
        return Math.max(rob_helper(nums, 1, nums.length-1), rob_helper(nums, 2, nums.length-2) + nums[0]);
    }
    
    public int rob_helper(int[] nums, int head, int tail){
        if(head > tail)     return 0;
        int[] result = new int[tail+1];
        while(head <= tail){
            if(head==1)    result[head] = nums[head];
            else            result[head] = Math.max(result[head-1], result[head-2]+nums[head]);
            head++;
        }
        return result[result.length-1];
    }
}