public class Solution {
    public int firstMissingPositive(int[] nums) {
        for(int i=0; i<nums.length; i++){
            if(nums[i]!=i && nums[i]>0 && nums[i]<=nums.length){
                
            }
        }
        int result = 1;
        for(int num:nums){
            if(result!=num) break;
            result++;
        }
        return result;
    }
}