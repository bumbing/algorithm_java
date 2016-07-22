public class Solution {
    public void nextPermutation(int[] nums) {
        if(nums.length<=1)  return;
        int i = nums.length-2;
        while(i>=0){
            if(nums[i]>=nums[i+1])   i--;
            else break;
        }
        if(i==-1){
            reverse(nums, 0, nums.length-1);
            return;
        }
        int j=nums.length-1;
        while(nums[j]<=nums[i]) j--;
        
        
        swap(nums, i, j);
        reverse(nums, i+1, nums.length-1);
        
    }
    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
        return;
    }
    
    public void reverse(int[] nums, int head, int tail){
        while(head<tail){
            int temp = nums[head];
            nums[head] = nums[tail];
            nums[tail] = temp;
            head++;
            tail--;
        }
        return;
    }
}