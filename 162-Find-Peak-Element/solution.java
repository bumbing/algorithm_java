public class Solution {
    public int findPeakElement(int[] nums) {
        if(nums[0]>nums[1]) return 0;
        if(nums[nums.length-1]>nums[nums.length-2]) return nums.length-1;
        int head = 0, tail = nums.length-1;
        while(head<tail){
            int mid = (head+tail)/2;
            if(nums[mid]>nums[mid-1] && nums[mid]>nums[mid+1])  return mid;
            else if(nums[mid]>nums[mid-1]){
                tail = mid;
            }else{
                head = mid;
            }
        }
        if(nums[head]>nums[head-1] && nums[head]>nums[head+1])  return head;
        else reutrn tail;
        return 0;
    }
}