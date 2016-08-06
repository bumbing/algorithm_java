public class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        Arrays.sort(nums);
        if(nums.length<3)   return 0;
        int result = 0;
        for(int i=0; i<nums.length-2; i++){
            int head=i+1, tail=nums.length-1;
            while(head<tail){
                if(nums[i]+nums[head]+nums[tail]>=target){
                    tail--;
                }else{
                    int tmp = nums[i]+nums[head]+nums[tail];
                    result = Math.max(result, tmp);
                    head++;
                }
            }
        }
        return result;
    }
}