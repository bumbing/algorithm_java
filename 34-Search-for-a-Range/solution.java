public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int head = find(nums, target, true);
        if(head!=-1){
            int tail = find(nums, target, false);
            return new int[]{head, tail};
        }
        return new int[]{-1, -1};
    }
    public int find(int[] nums, int target, boolean min){
        int head = 0, tail = nums.length-1;
        while(head<tail-1){
            int mid = (head+tail)/2;
            if(nums[mid]>target){
                tail = mid;
            }else if(nums[mid]<target{
                head = mid;
            }else{
                if(min) tail = mid;
                else    head = mid;
            }
        }
        if(min){
            if(nums[head]==target)  return head;
            if(nums[tail]==target) return tail;
        }else{
            if(nums[tail]==target) return tail;
            if(nums[head]==target)  return head;
            
        }
        return -1;
    }
}