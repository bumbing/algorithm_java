public class Solution {
    public int missingNumber(int[] nums) {
        int sum = (nums.length * (nums.length+1))/2;
        int temp = 0;
        for(int num: nums)  temp+= num;
        return sum-temp;
    }
}