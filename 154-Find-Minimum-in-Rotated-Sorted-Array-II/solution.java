public class Solution {
    public int findMin(int[] nums) {
        int head = 0, tail = nums.length-1;
        while(head<tail-1){
            int mid = (head+tail)/2;
            if(nums[head]==nums[mid] && nums[tail]==nums[mid]){
                if(nums[mid]-1 == nums[mid])    head = mid;
                else    tail = mid;
            }else if(nums[tail]>nums[head]){
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