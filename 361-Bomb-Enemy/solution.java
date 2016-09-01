public class Solution {
    public int maxKilledEnemies(char[][] grid) {
        if(grid==null || grid.length==0 || grid[0].length==0)   return 0;
        int[][] result = new int[grid.length][grid[0].length];
        int head = 0, cnt = 0;
        for(int i=0; i<grid.length; i++){
            head = 0;
            cnt = 0;
            for(int j=0; j<=grid[0].length; j++){
                if(j==grid[0].length || grid[i][j] == 'W'){
                    while(head<j && cnt>0){
                        result[i][head] += cnt;
                        head++;
                    }
                    head = j+1;
                    cnt = 0;
                }else if(grid[i][j] == 'E'){
                    cnt++;
                }
            }
        }
        int max = 0;
        for(int j=0; j<grid[0].length; j++){
            head = 0;
            cnt = 0;
            for(int i=0; i<=grid.length; i++){
                if(i==grid.length || grid[i][j] == 'W'){
                    while(head<i && cnt>0){
                        result[head][j] += cnt;
                        if(grid[head][j]=='E')  result[head][j]=0;
                        max = Math.max(max, result[head][j]);
                        head++;
                    }
                    head = i+1;
                    cnt = 0;
                }else if(grid[i][j] == 'E'){
                    cnt++;
                }
            }
        }
        return max;
    }
}