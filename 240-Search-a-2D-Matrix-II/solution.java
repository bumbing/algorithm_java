public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length==0 || matrix[0].length==0) return false;
        return searchSubMatrix(matrix, 0, 0, matrix.length-1, matrix[0].length-1, target);
    }
    
    public boolean searchSubMatrix(int[][] matrix, int a, int b, int c, int d, int target){
        if(a>c || b>d)  return false;
        if(a==c && b==d)    return target==matrix[a][c];
        int x=(a+c)/2, y=(b+d)/2;
        if(matrix[x][y]==target)    return true;
        else if(matrix[x][y]>target){
            if(searchSubMatrix(matrix, a, b, x, y, target)==true)   return true;
        }else{
            if(searchSubMatrix(matrix, x, y, c, d, target)==true)   return true;
        }
        if(searchSubMatrix(matrix, a, y, x, d, target)==true)   return true;
        if(searchSubMatrix(matrix, x, b, c, y, target)==true)   return true;
        return false;
    }
}