public class Solution {
    public int maxCoins(int[] nums) {
        if(nums.length == 0)    return 0;
        int[][] result = new int[nums.length][nums.length];
        for(int length = 0; length < nums.length; length++){
            for(int tail = nums.length-1; tail - length >= 0; tail--){
                int head = tail - length;
                int product = ((head!=0)?nums[head - 1]:1) * ((tail != nums.length-1)?nums[tail+1]:1);
                for(int i = head; i <= tail; i++){
                    int coins = product * nums[i] + ((i>head)?result[i-1-head][i-1]:0) + ((i<tail)?result[tail-i-1][tail]:0);
                    result[length][tail] = Math.max(result[length][tail], coins);
                }
            }
        }
        return result[nums.length-1][nums.length-1];    
    }
}