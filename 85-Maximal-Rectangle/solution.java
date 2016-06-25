public class Solution {
    public int maximalRectangle(char[][] matrix) {
        if(matrix.length==0)    return 0;
        if(matrix[0].length==0) return 0;
        int[][] heights = new int[matrix.length][matrix[0].length];
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                if(matrix[i][j]=='1')
                    heights[i][j] = (i==0)?1:heights[i-1][j]+1;
            }
        }
        
        int result = 0;
        for(int i=0; i<matrix.length; i++)  result = Math.max(result, largestRectangleArea(heights[i]));
        return result;
    }
    
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack();
        int result = 0;
        for(int i=0; i<heights.length; i++){
            result = Math.max(add(stack, i, heights[i], heights), result);
        }
        result = Math.max(add(stack, heights.length, 0, heights), result);
        return result;
    }
    
    private int add(Stack<Integer> stack, int index, int height, int[] heights){
        int result = 0;
        while(true){
            if(stack.empty())   break;
            if(heights[stack.peek()] < height)   break;
            int product = heights[stack.pop()] * (index - (stack.empty()?0:(stack.peek()+1)));
            result = Math.max(product, result);
        }
        stack.push(index);
        return result;
    }
}