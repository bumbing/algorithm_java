public class Solution {
    public int rob(int[] nums) {
        if(nums.length==0)  return 0;
        return Math.max(rob_helper(nums, 1, nums.length-1), rob_helper(nums, 2, nums.length-2) + nums[0]);
    }
    
    public int rob_helper(int[] nums, int head, int tail){
        if(head > tail)     return 0;
        int[] result = new int[tail-head+1];
        for(int i=head; i<=tail; i++){
            int index = i-head;
            if(i==head){
                result[index] = nums[i];
                continue;
            } 
            if(i==head+1){
                result[index] = Math.max(nums[i], nums[i-1]);
                continue;
            }   
            result[index] = Math.max(result[index-1], result[index-2]+nums[i]);
            index++;
        }
        return result[result.length-1];
    }
}