public class Solution {
    public int maxCoins(int[] nums) {
        if(nums.length==0)  return 0;
        int[][] result = new int[nums.length][nums.length];
        for(int l=0; l<nums.length; l++){
            for(int i=0; i<nums.length; i++){
                if(i+l<nums.length)     helper(nums, result, i, l);
            }
        }
        return result[0][nums.length-1];
    }
    
    private void helper(int[] nums, int[][] result, int head, int length){
        int tail = head+length;
        if(head>tail)   return 0;
        if(head==tail)  return nums[head] * (head==0)?1:nums[head-1] * (head==nums.length-1)?1:nums[head+1];
        if(result[head][tail]!=0)   return result[head][tail];
        int tmp = 0;
        for(int i=head; i<=tail; i++){
            tmp = Math.max(tmp, result[head, i-1]+result[i+1, tail]+nums[i]*(head==0)?1:nums[head-1] *(tail==nums.length-1)?1:nums[head+1]);
        }
    }
}