public class Solution {
    public void sortColors(int[] nums) {
        if(nums==null || nums.length<=1)    return;
        int head = 0, tail = nums.length-1;
        for(int i=0; i<=tail;){
            if(nums[i]==0){
                swap(nums, head, i);
            }else if(nums[i]==2){
                swap(nums, tail, i);
            }else{
                i++;
            }
        }
    }
    public void swap(int[] nums, int x, int y){
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }
}