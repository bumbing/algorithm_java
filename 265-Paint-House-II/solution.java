public class Solution {
    public int minCostII(int[][] costs) {
        if(costs==null || costs.length==0 || costs[0].length==0)     return 0;
        int[][] result = new int[costs.length+1][costs[0].length];
        int r1 = -1, r2 = -1;
        for(int i=1; i<=costs.length; i++){
            int t1=0, t2=0;
            for(int j=0; j<costs[0].length; j++){
                if(r1==-1 || r2==-1)  result[i][j] = costs[i-1][j];
                else if(j==r1)   result[i][j] = costs[i-1][j] + result[i-1][r2];
                else    result[i][j] = costs[i-1][j] + result[i-1][r1];
                if(result[i][j]<result[i][t1] || r1==-1){
                    t2 = r1;
                    t1 = j;
                }else if(result[i][j]<result[i][t2] || r2==-1){
                    t2 = j;
                }
            }
            r1 = t1;
            r2 = t2;
        }
        return result[result.length-1][r1];
    }
}

