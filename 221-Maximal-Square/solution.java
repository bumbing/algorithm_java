public class Solution {
    public int maximalSquare(char[][] matrix) {
        if(matrix.length==0)    return 0;
        if(matrix[0].length==0) return 0;
        int[][] square = new int[matrix.length][matrix[0].length];
        int result = 0;
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                if(matrix[i][j]=='0')   continue;
                else if(i==0 || j==0)    square[i][j] = 1;
                else{
                    int min = Math.min(square[i-1][j], square[i][j-1]);
                    square[i][j] = min + (int)(matrix[i-min][j-min] - '0');
                }
                result = Math.max(result, square[i][j]);
            }
        }
        return result * result;
    }
}