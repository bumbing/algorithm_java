public class Solution {
    public int firstMissingPositive(int[] nums) {
        if(nums==null || nums.length==0)    return 1;
        for(int i=0; i<nums.length; i++){
            while(nums[i]>0 && nums[i]<nums.length && nums[i]!=i+1){
                swap(nums, i, nums[i]-1);
            }
            
        }
        int miss = 1;
        for(int num: nums){
            if(num == miss) miss++;
            else break;
        }
        return miss;
    }
    public void swap(int[] nums, int x, int y){
        if(nums[x]==nums[y]){
            nums[x]= -1;
            return;
        } 
        int tmp = nums[x];
        nums[x] = nums[y];
        nums[y] = tmp;
    }
}