public class NumMatrix {
    int[][] matrix, sum;

    public NumMatrix(int[][] matrix) {
        if(matrix.length==0)    return;
        this.matrix = matrix;
        sum = new int[matrix.length][matrix[0].length+1];
        for(int i=0; i<matrix.length; i++){
            int temp = 0;
            for(int j=0; j<matrix[0].length; j++){
                temp += matrix[i][j];
                sum[i][j+1] = temp;
            }
        }
        this.sum = sum;
    }

    public void update(int row, int col, int val) {
        int diff = val - this.matrix[row][col];
        for(int j=col+1; j<this.sum[0].length; j++){
            this.sum[row][j] += diff;
        }
        this.sum[row][col] = val;
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int result = 0;
        for(int i=row1; i<=row2; i++){
            result += this.sum[i][col2+1] - this.sum[i][col1];
        }
        return result;
    }
}


// Your NumMatrix object will be instantiated and called as such:
// NumMatrix numMatrix = new NumMatrix(matrix);
// numMatrix.sumRegion(0, 1, 2, 3);
// numMatrix.update(1, 1, 10);
// numMatrix.sumRegion(1, 2, 3, 4);
