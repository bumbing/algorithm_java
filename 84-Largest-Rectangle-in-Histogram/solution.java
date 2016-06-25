public class Solution {
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
            if(heights[stack.peek()] == height){
                stack.pop();
                break;
            }
            int product = heights[stack.pop()];
            product *= index - (stack.empty()?0:(stack.peek()+1));
            result = Math.max(product, result);
        }
        stack.push(index);
        return result;
    }
}