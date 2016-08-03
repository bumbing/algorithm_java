public class Solution {
    public int removeElement(int[] nums, int val) {
        int head = 0, tail = nums.length-1;
        while(head<tail){
            if(nums[tail]==val) tail--;
            else if(nums[head]==val){
                int tmp = nums[head];
                nums[head] = nums[tail];
                nums[tail] = tmp;
            }else head++;
        }
        while(tail>-1 && nums[tail]==val)    tail--;
        return tail+1;
    }
}