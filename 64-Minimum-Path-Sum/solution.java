public class Solution {
    public int minPathSum(int[][] grid) {
        if(grid.length==0)  return 0;
        if(grid[0].length==0)   return 0;
        int[] result = new int[grid[0].length];
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(j==0){
                    result[j] = result[j] + grid[i][j];
                }else if(i==0){
                    result[j] = result[j-1] + grid[i][j];
                }else{
                    result[j] = Math.min(result[j], result[j-1]) + grid[i][j];
                }
            }
        }
        return result[grid[0].length-1];
    }
}