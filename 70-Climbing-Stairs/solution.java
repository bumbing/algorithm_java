public class Solution {
    public int climbStairs(int n) {
        int[] result = new int[n+2];
        result[1] = 1;
        for(int i=2; i<result.length; i++){
            result[i]=result[i-1] + result[i-2];
        }
        return result[n+1];
    }
}