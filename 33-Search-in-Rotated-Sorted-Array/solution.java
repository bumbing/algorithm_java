public class Solution {
    public int search(int[] nums, int target) {
        int head = 0, tail = nums.length-1;
        while(head<tail-1){
            int mid = (head+tail)/2;
            if(nums[tail]>nums[head]){
                tail = mid;
            }else{
                if(nums[mid]>nums[head])    head = mid;
                else    tail = mid;
            }
        }
        if(nums[head]<nums[tail])   return nums[head];
        else return nums[tail];
    }
}