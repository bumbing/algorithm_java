public class Solution {
    public int maxProduct(int[] nums) {
        return maxProductHelper(nums, 0);
    }
    public int maxProductHelper(int[] nums, int index){
        int[] product = new int[2];
        product[0] = 1;
        product[1] = 0;
        int max = Integer.MIN_VALUE;
        for(int i=index; i<nums.length; i++){
            if(nums[i]>0){
                product[0] *= nums[i];
                max = Math.max(max, product[0]);
            }else if(nums[i]<0){
                int temp = product[0] * nums[i];
                if(product[1]==0)   product[0]=1;
                else    product[0] = product[1] * nums[i];
                product[1] = temp;
            }else{
                max = Math.max(max, maxProductHelper(nums, i+1));
            }
        }
        return max;
    }
}