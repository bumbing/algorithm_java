public class Solution {
    public int integerBreak(int n) {
        int[] result = new int[Math.max(n, 4)];
        result[0] = 1;
        result[1] = 2;
        result[2] = 3;
        result[3] = 4;
        for(int i=4; i<n; i++){
            result[i] = Math.max(result[i-1], Math.max(result[i-2]*2, result[i-3]*3));
        }
        return result[n-1];
    }
}