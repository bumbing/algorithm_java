public class Solution {
    public boolean search(int[] nums, int target) {
        if(nums.length==0 || nums==null)    return false;
        return helper(nums, 0, nums.length-1, target);
    }
    
    public boolean helper(int[] nums, int head, int tail, int target){
        while(head+1<tail && nums[head]!=target && nums[tail]!=target){
            int mid = (tail+head)/2;
            if(nums[mid]==target)   return true;
            if(nums[head]==nums[tail]){
                head++;
                tail--;
            }else if(nums[head]<nums[tail]){
                if(target<nums[mid])    tail = mid;
                else head = mid;
            }else{
                if(target>nums[head]){
                    if(nums[mid]>=nums[head] && target>nums[mid])    head = mid; //this '=' is a trick part
                    else   tail = mid;
                } else if(target<nums[tail]){
                    if(nums[mid]<=nums[tail] && target<nums[mid])    tail = mid;    // also here
                    else    head = mid;
                } else
                    return false;
            }
        }
        if(nums[head]==target || nums[tail]==target)    return true;
        return false;
    }
}
