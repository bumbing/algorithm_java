public class Solution {
    public int minTotalDistance(int[][] grid) {
        if(grid.length<=1 && grid[0].length<=1) return 0;
        int count = 0, result=0;
        int[] x = new int[grid.length];
        int[] y = new int[grid[0].length];
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j]>0){
                    x[i]++;
                    y[j]++;
                    count++;
                }
            }
        }
        int temp = 0;
        for(int i=0; i<x.length; i++){
            temp += x[i];
            if(x>count-x) {
                for(int k=0;k<x.length;k++) result += x[k] * Math.abs(k-i);
            }
        }
        for(int i=0; i<y.length; i++){
            temp += y[i];
            if(y>count-y) {
                for(int k=0;k<y.length;k++) result += y[k] * Math.abs(k-i);
            }
        }
        return result;
    }
}