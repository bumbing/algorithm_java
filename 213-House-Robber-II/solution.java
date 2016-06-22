public class Solution {
    public int rob(int[] nums) {
        if(nums.length==0)  return 0;
        return Math.max(rob_helper(nums, 1, nums.length-1), rob_helper(nums, 2, nums.length-2) + nums[0]);
    }
    
    public int rob_helper(int[] nums, int head, int tail){
        if(head > tail)     return 0;
        int[] result = new int[tail+1];
        int index = head;
        while(head <= tail){
            if(index==1)    result[index] = nums[head];
            else            result[index] = Math.max(result[index-1], result[index-2]+nums[head]);
            index++;
            head++;
        }
        return result[result.length-1];
    }
}