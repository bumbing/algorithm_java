public class Solution {
    public int numSquares(int n) {
        int[] result = new int[n + 1];
        for(int i=1; i<=n; i++){
            int tmp = (int) Math.sqrt(i);
            result[i] = i;
            if(n == tmp * tmp){
                result[i] = 1;
            }else{
                for(int j=1; j<=tmp; j++)   result[i] = Math.min(result[i], result[i-j*j]+1);
            }
        }
        return result[n];
    }
}