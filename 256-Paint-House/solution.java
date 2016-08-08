public class Solution {
    public int minCost(int[][] costs) {
        int[][] result = new int[2][3];
        for(int i=0; i<costs.length; i++){
            for(int j=0; j<3; j++){
                result[i%2][j] = Math.min(result[(i+1)%2][(j+1)%3], result[(i+1)%2][(j+2)%3]);    
            }
        }
        int r = Integer.MAX_VALUE;
        for(int i=0; i<3; i++)  r = Math.min(r, result[(costs.length+1)%2][i]);
        return r;
    }
}