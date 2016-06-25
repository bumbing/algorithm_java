public class Solution {
    int[] numbers;
    int[][] result;
    public int maxCoins(int[] nums) {
        if(nums.length==0)  return 0;
        this.numbers = nums;
        this.result = new int[nums.length][nums.length];
        for(int l=0; l<nums.length; l++){
            for(int i=0; i<nums.length; i++){
                if(i+l<nums.length)     this.result[i][i+l] = helper(i, l);
            }
        }
        return result[0][nums.length-1];
    }
    
    private int helper(int head, int length){
        int tail = head+length;
        if(head>tail)   return 0;
        if(result[head][tail]!=0)  return this.result[head][tail];
        if(head==tail)  return this.numbers[head] * ((head==0)?1:this.numbers[head-1]) * ((tail==this.numbers.length-1)?1:this.numbers[tail+1]);
        int tmp = 0;
        for(int i=head; i<=tail; i++){
            tmp = Math.max(tmp, helper(head, i-1) + helper(i+1, tail));
        }
        return tmp + this.numbers[i] * (head==0)?1:this.numbers[i-1]) * ((tail==this.numbers.length-1)?1:this.numbers[tail+1]);
    }
}