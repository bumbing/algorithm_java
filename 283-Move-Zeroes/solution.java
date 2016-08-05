public class Solution {
    public void moveZeroes(int[] nums) {
        int head1=0, head2=0;
        while(head1<nums.length){
            if(nums[head1]!=0){
                nums[head2] = nums[head1];
                head2++;
            }
        }
        while(head2<nums.length){
            nums[head2] = 0;
            head2++;
        }
    }
    
}