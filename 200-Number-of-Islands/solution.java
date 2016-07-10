public class Solution {
    public int numIslands(char[][] grid) {
        if(grid.length==0)  return 0;
        if(grid[0].length==0)   return 0;
        int result = 0;
        //dfs
        Stack<Integer> stack = new Stack();
        boolean[][] traversed = new boolean[grid.length][grid[0].length];
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j]=='1'&&traversed[i][j]==false){
                    traversed[i][j] = true;
                    result++;
                    stack.push(i*grid[0].length+j);
                    traversed[i][j] = true;
                    while(!stack.empty()){
                        int temp = stack.pop();
                        int k = temp/grid[0].length;
                        int l = temp%grid[0].length;
                        if(k>0){
                            if(grid[k-1][l]=='1' && traversed[k-1][l]==false){
                                stack.push(temp-grid[0].length);
                                traversed[k-1][l]=true;
                            }
                        }
                        if(k<grid.length-1){
                            if(grid[k+1][l]=='1' && traversed[k+1][l]==false){
                                stack.push(temp+grid[0].length);
                                traversed[k+1][l]=true;
                            }
                        }
                        if(l>0){
                            if(grid[k][l-1]=='1' && traversed[k][l-1]==false){
                                stack.push(temp-1);
                                traversed[k][l-1]=true;
                            }
                        }
                        if(l<grid[0].length-1){
                            if(grid[k][l+1]=='1' && traversed[k][l+1]==false){
                                stack.push(temp+1);
                                traversed[k][l+1]=true;
                            }
                        }
                        
                    }
                }     
            }
        }
        return result;
    }
}