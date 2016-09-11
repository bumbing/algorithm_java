public class Solution {
    public int searchInsert(int[] nums, int target) {
        int head = 0, tail = nums.length-1;
        while(head+1<tail){
            int mid = (head + tail)/2;
            if(nums[mid]==target)   return mid;
            if(nums[mid]<target)    tail = mid-1;
            else    head = mid+1;
        }
        
    }
}