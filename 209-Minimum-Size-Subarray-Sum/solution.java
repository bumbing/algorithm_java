public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if(nums.length==0)  return 0;
        int head=0, tail=0, sum=0, result = Integer.MAX_VALUE;
        while(tail<nums.length){
            if(sum<s){
                if(tail==nums.length)   break;
                sum+= nums[tail];
                tail++;
            }else{
                result = Math.min(tail-head, result);
                sum -= nums[head];
                head++;
            }
        }
        return (result==Integer.MAX_VALUE)?0:result;
    }
}