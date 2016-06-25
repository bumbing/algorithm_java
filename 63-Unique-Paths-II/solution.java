public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[][] result = new int[obstacleGrid.length+1][obstacleGrid[0].length+1];
        for(int i=1; i<=obstacleGrid.length; i++){
            for(int j=1; j<=obstacleGrid[0].length; j++){
                if(obstacleGrid[i-1][j-1]==1)   result[i][j] = 0;
                else if(i==1&&j==1)  result[i][j] = 1;
                else    result[i][j] = result[i-1][j] + result[i][j-1];
            }
        }
        return result[obstacleGrid.length][obstacleGrid[0].length];
    }
}